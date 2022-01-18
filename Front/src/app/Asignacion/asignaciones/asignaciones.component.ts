import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { PromocionesServiceService } from 'src/app/Servicios/promociones-service.service';
import { DialogoCargaComponent } from '../dialogo-carga/dialogo-carga.component';

@Component({
  selector: 'app-asignaciones',
  templateUrl: './asignaciones.component.html',
  styleUrls: ['./asignaciones.component.css']
})
export class AsignacionesComponent implements OnInit {

  constructor(private servicioPromociones: PromocionesServiceService, private snackBar: MatSnackBar,
              private dialog: MatDialog) { }

  ngOnInit(): void {
  }

  /**
   * abrirDialogo: Activa la ventana emergente se validación al momento de eliminar una promoción
   */
  abrirDialogo(): void {
    const dialogRef = this.dialog.open(DialogoCargaComponent);
    dialogRef.afterOpened().subscribe(() => {
      /* Hace llamado al método de asignación de promociones, y activa ventana emergente mientras
      se ejecuta, la cual se cierra tras la ejecución */
      this.servicioPromociones.asignarPromociones().subscribe(() => {
        this.snackBar.open('Asignación realizada con éxito', 'Hecho');
        dialogRef.close();
      }, error => {
        // Si es error del Cliente
        if (error.statusText == 'Unknown Error') {
          dialogRef.close();
          this.snackBar.open('Error en la asignación. Por favor intentarlo nuevamente.', 'Hecho');
        }
        // Si es error del Back-End
        else {
          dialogRef.close();
          this.snackBar.open(error.error.message, 'Hecho');
        }
      });
    });
  }

  /**
   * quitarPromociones: Quita todas las promociones asignadas a todos los clientes. Este método no es
   *                    oficial, pues sólo se usa a manera de ejercicio para ver de una manera más
   *                    notoria la asignación de las promociones.
   *                    Para desasignar promociones, existe un procedimiento en PL/SQL que se
   *                    encarga de esta operación de manera programada, como un job mensual.
   */
  quitarPromociones(): void {
    const dialogRef = this.dialog.open(DialogoCargaComponent);
    dialogRef.afterOpened().subscribe(() => {
      /* Hace llamado al método de quitar promociones, y activa ventana emergente mientras
      se ejecuta, la cual se cierra tras la ejecución */
      this.servicioPromociones.quitarPromociones().subscribe(() => {
        this.snackBar.open('Se han desasignado todas las promociones', 'Hecho');
        dialogRef.close();
        }, error => {
          // Si es error del Cliente
          if (error.statusText == 'Unknown Error') {
            dialogRef.close();
            this.snackBar.open('Error en la desasignación. Por favor intentarlo nuevamente.', 'Hecho');
          }
          // Si es error del Back-End
          else {
            dialogRef.close();
            this.snackBar.open(error.error.message, 'Hecho');
          }
        });
      });
  }
}
