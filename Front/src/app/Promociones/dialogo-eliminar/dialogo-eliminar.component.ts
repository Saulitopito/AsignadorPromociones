import { Component, OnInit, Inject } from '@angular/core';
import { Promociones } from 'src/app/Modelos/promociones';
import { GeneralService } from 'src/app/Servicios/general.service';
import { PromocionesServiceService } from 'src/app/Servicios/promociones-service.service';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-dialogo-eliminar',
  templateUrl: './dialogo-eliminar.component.html',
  styleUrls: ['./dialogo-eliminar.component.css']
})
export class DialogoEliminarComponent implements OnInit {

  constructor(@Inject(MAT_DIALOG_DATA) public data: Promociones,
              private servicioPromos: PromocionesServiceService, private snackBar: MatSnackBar) { }

  ngOnInit(): void {
  }

  /**
   * eliminarPromocion: ejecuta el procedimiento de actualización de la promoción para pasar su 
   *                    estado de activo (1) a inhabilitado (0)
   */
  eliminarPromocion(): void {
    this.servicioPromos.inhabilitarPromocion(this.data).subscribe(() => {
      this.snackBar.open('Promoción ' + this.data.nombreDTO + ' inhabilitada con éxito.', 'Hecho');
    }, error => {
      // Si es error del Cliente
      if (error.error.error == 'Bad Request') {
        this.snackBar.open('Sucedió un error inesperado en la eliminación de la promoción.'
                          + 'Por favor intentar nuevamente.', 'Hecho');
      }
      // Si es error del Back-End
      else {
        this.snackBar.open(error.error.message, 'Hecho');
      }
    });
  }
}
