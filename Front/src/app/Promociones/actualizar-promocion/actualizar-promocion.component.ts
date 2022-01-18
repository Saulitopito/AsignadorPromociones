import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { Actividad } from 'src/app/Modelos/actividad';
import { Calificacion } from 'src/app/Modelos/calificacion';
import { Ciudad } from 'src/app/Modelos/ciudad';
import { Plan } from 'src/app/Modelos/plan';
import { Promociones } from 'src/app/Modelos/promociones';
import { ActividadesServiceService } from 'src/app/Servicios/actividades-service.service';
import { CalificacionesServiceService } from 'src/app/Servicios/calificaciones-service.service';
import { CiudadesServiceService } from 'src/app/Servicios/ciudades-service.service';
import { GeneralService } from 'src/app/Servicios/general.service';
import { PlanesServiceService } from 'src/app/Servicios/planes-service.service';
import { PromocionesServiceService } from 'src/app/Servicios/promociones-service.service';
import { DialogoCargaActualizacionComponent } from '../dialogo-carga-actualizacion/dialogo-carga-actualizacion.component';

@Component({
  selector: 'app-actualizar-promocion',
  templateUrl: './actualizar-promocion.component.html',
  styleUrls: ['./actualizar-promocion.component.css']
})
export class ActualizarPromocionComponent implements OnInit {

  promocion: Promociones;
  actividades: Actividad[];
  planes: Plan[];
  calificaciones: Calificacion[];
  ciudades: Ciudad[];
  form: FormGroup;
  promo: Promociones;

  ciudadesReales: Ciudad[] = [];
  planesReales: Plan[] = [];
  actividadesReales: Actividad[] = [];
  calificacionesReales: Calificacion[] = [];

  nombre: string;
  fecha_inicio: Date;
  fecha_inicio_val: string;
  fecha_fin: Date;
  fechaReal_inicio: Date;
  fechaReal_fin: Date;
  descuento: number;
  promedio: number;

  ciudadesSeleccionadas: string[];
  actividadesSeleccionadas: string[];
  planesSeleccionados: string[];
  calificacionesSeleccionadas: string[];

  constructor(private servicioPromo: PromocionesServiceService, private router: Router,
              private fb: FormBuilder, private servicioActividades: ActividadesServiceService,
              private servicioPlanes: PlanesServiceService,
              private servicioCalificaciones: CalificacionesServiceService,
              private servicioCiudades: CiudadesServiceService, private gral: GeneralService,
              private matSnack: MatSnackBar, private dialog: MatDialog) {}

  ngOnInit(): void {
    /* Carga la información de la promoción seleccionada, y gestiona un error en caso de acceder a
    la ruta sin pasar id de la promoción */
    this.servicioPromo.getPromocion(this.gral.id).subscribe(data5 => {
      this.promo = data5;
    }, error => {
      // Si es error del Cliente
      if (error.error.error == 'Bad Request') {
        this.matSnack.open('Debe especificar una promoción a modificar.', 'Hecho').afterDismissed().subscribe(() => {
          this.router.navigate(['promos']);
        });
      }
      // Si es error del Back-End
      else {
        this.matSnack.open(error.error.message, 'Hecho').afterDismissed().subscribe(() => {
          this.router.navigate(['promos']);
        });
      }
    });

    /* Obtiene la información de la promoción, a ser mostrada en la vista. Se hace uso del 'gral'
    como servicio conector entre componentes */
    this.nombre = this.gral.nombre;
    this.fecha_inicio = this.gral.fecha_inicio;
    this.fecha_fin = this.gral.fecha_fin;
    this.descuento = this.gral.descuento * 100;
    this.promedio = this.gral.promedio;
    this.ciudadesSeleccionadas = this.gral.ciudades;
    this.actividadesSeleccionadas = this.gral.actividades;
    this.planesSeleccionados = this.gral.planes;
    this.calificacionesSeleccionadas = this.gral.calificaciones;

    // Definición del formulario reactivo que permite la actualización de la promoción
    this.form = this.fb.group({
      promoNombre: [, [Validators.required]],
      promoFechaInicio: [, [Validators.required]],
      promoFechaFin: [, [Validators.required]],
      promoDescuento: [, [Validators.required, Validators.min(0)]],
      promoMinVal: [, [Validators.required, Validators.min(0)]],
      promoCiudades: ['Seleccione una opción', [Validators.required]],
      promoPlanes: ['Seleccione una opción', [Validators.required]],
      promoActividades: ['Seleccione una opción', [Validators.required]],
      promoCalificaciones: ['Seleccione una opción', [Validators.required]],
    });

    /* Obtención de la información de ciudades, planes comerciales, actividades económicas y
    calificaciones a mostrar en el listado seleccionable */
    this.servicioActividades.getActividades().subscribe(data1 => {
      this.actividades = data1;
    });
    this.servicioCalificaciones.getCalificaciones().subscribe(data2 => {
      this.calificaciones = data2;
    });
    this.servicioCiudades.getCiudades().subscribe(data3 => {
      this.ciudades = data3;
    });
    this.servicioPlanes.getPlanes().subscribe(data4 => {
      this.planes = data4;
    });
  }

  /**
   * onSubmit: define lo que se hará al momento de dar clic en el botón de Modificar Promoción
   */
  onSubmit(): void {
    /* Tomar los elementos seleccionados de los desplegables mútliples, y ajsutarlos para ser
    enviados en el DTO */
    for(let ciudad of this.ciudadesSeleccionadas){
      this.ciudadesReales.push({idDTO: 0, nombreDTO: ciudad} as Ciudad);
    }
    for(let plan of this.planesSeleccionados){
      this.planesReales.push({idDTO: 0, nombreDTO: plan} as Plan);
    }
    for(let actividad of this.actividadesSeleccionadas){
      this.actividadesReales.push({idDTO: 0, nombreDTO: actividad} as Actividad);
    }
    for(let calificacion of this.calificacionesSeleccionadas){
      this.calificacionesReales.push({idDTO: 0, nombreDTO: calificacion} as Calificacion);
    }

    // Ajuste y modificación de las fechas por desfase horario (GMT-5)
    this.fechaReal_inicio = new Date(new Date(this.fecha_inicio).setHours(new Date(this.fecha_inicio).getHours() + 5));
    this.fechaReal_fin = new Date(new Date(this.fecha_fin).setHours(new Date(this.fecha_fin).getHours() + 5));

    // Creación del DTO que contiene la información de la promoción a actualizar
    this.promocion = new Promociones(this.nombre, this.fechaReal_inicio, this.fechaReal_fin,
                                    (this.descuento / 100), this.promedio, this.actividadesReales,
                                    this.calificacionesReales, this.planesReales, this.ciudadesReales);

    /* Activa la ventana emergente de carga del proceso de actualización de una promoción, la cual se
    cierra tras la ejecución */
    const dialogRef = this.dialog.open(DialogoCargaActualizacionComponent);
    dialogRef.afterOpened().subscribe(() => {
      /* Llamado del método, pasando id y cuerpo de la promoción, para su actualización en base de
      datos */
      this.servicioPromo.putPromocion(this.promocion, this.gral.id).subscribe(() => {
        this.matSnack.open('Promoción actualizada exitosamente', 'Hecho');
        dialogRef.close();
        this.router.navigate(['promos']);
      }, error => {
        // Si es error del Cliente
        if (error.error.error == 'Bad Request') {
          dialogRef.close();
          this.matSnack.open('Ha sucedido un error inesperado. Intenta la creación nuevamente y asegúrate de diligenciar todos los campos.', 'Hecho')
          .afterDismissed().subscribe(() => {
          this.router.navigate(['promos']);
        });
        }
        dialogRef.close();
        this.matSnack.open(error.error.message, 'Hecho')
          .afterDismissed().subscribe(() => {
          this.router.navigate(['promos']);
        });
      });
    });

  }

  /**
   * cambio: Permite ajustar el valor del slider y del input text en el formulario, para que sea
   *         dinámico
   * @param event - Valor del slider para mostrar en el input
   */
  cambio(event): void {
    this.promedio = event.value;
  }
}
