import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { Promociones } from 'src/app/Modelos/promociones';
import { GeneralService } from 'src/app/Servicios/general.service';
import { PromocionesServiceService } from 'src/app/Servicios/promociones-service.service';
import { DialogoEliminarComponent } from '../dialogo-eliminar/dialogo-eliminar.component';

@Component({
  selector: 'app-listar-promociones',
  templateUrl: './listar-promociones.component.html',
  styleUrls: ['./listar-promociones.component.css']
})
export class ListarPromocionesComponent implements OnInit {

  promos: Promociones[];
  page: number;

  constructor(private servicioPromos: PromocionesServiceService, private router: Router,
              private gral: GeneralService, private matSnack: MatSnackBar, private dialog: MatDialog) { }

  ngOnInit(): void {
    this.cargarPromociones();
  }

  /**
   * cargarPromociones: Obtención de todas las promociones desde la base de datos, para ser mostradas 
   *                    en la lista
   */
  cargarPromociones(): void {
    this.servicioPromos.getPromociones().subscribe((data: Promociones[]) => {
      this.promos = data;
      if (this.promos.length == 0 ){
        this.matSnack.open('Aun no existen promociones.', 'Hecho');
      }
    }, error => {
      // Si es error del Cliente
      if (error.statusText == 'Unknown Error') {
        this.matSnack.open('No hay promociones para mostrar. '
        + 'Por favor verifique su conexión o comuníquese con el administrador.', 'Hecho');
      }
      // Si es error del Back-End
      else {
        this.matSnack.open(error.error.message, 'Hecho');
      }
    });
  }

  /**
   * crearPromocion: Remite a la vista de creación de promociones
   */
  crearPromocion(): void {
    this.router.navigate(['crear-promociones']);
  }

  /*  */
  /**
   * actualizarPromocion: Hace uso del servicio GeneralService para pasar la información entre los 
   *                      componentes listar-promociones y actualizar-promociones, para que en el
   *                      formulario de actualización se pueda mostrar la información de la promoción 
   *                      a modificar
   * @param promo - Promoción a actualizar con toda su información básica
   */
  actualizarPromocion(promo: Promociones): void {
    this.gral.id = promo.idDTO;
    this.gral.nombre = promo.nombreDTO;
    this.gral.fecha_inicio = promo.fecha_inicioDTO;
    this.gral.fecha_fin = promo.fecha_finDTO;
    this.gral.descuento = promo.descuentoDTO;
    this.gral.promedio = promo.min_valDTO;
    let ciudades: string[] = [];
    let actividades: string[] = [];
    let planes: string[] = [];
    let calificaciones: string[] = [];

    /* Obtiene los textos de los elementos de selección múltiple asociados a la promoción, para que
    aparezca marcados al momento de acceder a la vista de actualización */
    promo.ciudadDTO.forEach((item) => {
      ciudades.push(item.nombreDTO);
    });
    this.gral.ciudades = ciudades;
    promo.actividadDTO.forEach((item) => {
      actividades.push(item.nombreDTO);
    });
    this.gral.actividades = actividades;
    promo.planDTO.forEach((item) => {
      planes.push(item.nombreDTO);
    });
    this.gral.planes = planes;
    promo.calificacionDTO.forEach((item) => {
      calificaciones.push(item.nombreDTO);
    });
    this.gral.calificaciones = calificaciones;
    this.router.navigate(['actualizar-promociones']);
  }

  /**
   * abrirDialogo: Activa la ventana emergente se validación al momento de eliminar una promoción
   * @param promo - Promoción a eliminar
   */
  abrirDialogo(promo: Promociones): void {
    const dialogRef = this.dialog.open(DialogoEliminarComponent, {data: promo});
    dialogRef.afterClosed().subscribe(() => {
      this.ngOnInit();
    });
  }

}
