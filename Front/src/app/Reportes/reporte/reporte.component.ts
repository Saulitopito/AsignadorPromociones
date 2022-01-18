import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { ClientePromo } from 'src/app/Modelos/cliente-promo';
import { Promociones } from 'src/app/Modelos/promociones';
import { PromocionesServiceService } from 'src/app/Servicios/promociones-service.service';
import { ReporteServiceService } from 'src/app/Servicios/reporte-service.service';
import * as XLSX from 'xlsx';


@Component({
  selector: 'app-reporte',
  templateUrl: './reporte.component.html',
  styleUrls: ['./reporte.component.css']
})
export class ReporteComponent implements OnInit {

  clientes: ClientePromo[];
  promociones: Promociones[];
  mostrar = false;
  promocionSeleccionada: Promociones;
  promocion: Promociones;
  fileName: string;

  constructor(private servicioClientesPromo: ReporteServiceService,
              private servicioPromos: PromocionesServiceService, private matSnack: MatSnackBar) { }

  ngOnInit(): void {
    this.cargarTabla();
  }

  /**
   * cargarTabla: Obtiene los clientes asociados a la promoción seleccionada, para ser mostrados en
   *              la tabla
   */
   cargarTabla(): void {
    this.servicioClientesPromo.getClientesPromo().subscribe((data: ClientePromo[]) => {
      this.clientes = data;
      if (data.length == 0){
        this.matSnack.open('No existen clientes asignados a la promoción seleccionada', 'Hecho');
      }
    }, error => {
      // Si es error del Cliente
      if (error.statusText == 'Unknown Error') {
        this.matSnack.open('Sucedió un error inesperado. '
        + 'Por favor verifique su conexión o comuníquese con el administrador.', 'Hecho');
      }
      // Si es error del Back-End
      else {
        this.matSnack.open(error.error.message, 'Hecho');
      }
    });
  }

  /**
   * activar: Hace visible la sección de la fechas de vigencia de la promoción, al ser seleccionada
   * @param promo - Promoción cuyas fechas se van a mostrar
   */
  activar(promo: Promociones): void {
    this.promocion = promo;
    this.mostrar = true;
  }

  /**
   * generarReporte: Genera un reporte en Exce con la información de la tabla de clientes asociados
   *                 a la promoción seleccionada
   */
  generarReporte(): void {
    this.matSnack.open('Descarga en proceso', 'Hecho');

    const element = document.getElementById('tabla-reporte');
    const ws: XLSX.WorkSheet = XLSX.utils.table_to_sheet(element);

    const wb: XLSX.WorkBook = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(wb, ws, 'Hoja1');

    const timeSpan = new Date();
    this.fileName = `Reporte - ${timeSpan}.xlsx`;
    XLSX.writeFile(wb, this.fileName);
  }

}
