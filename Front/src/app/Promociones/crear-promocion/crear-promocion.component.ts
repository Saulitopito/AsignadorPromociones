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
import { PlanesServiceService } from 'src/app/Servicios/planes-service.service';
import { PromocionesServiceService } from 'src/app/Servicios/promociones-service.service';
import { DialogoCargaCreacionComponent } from '../dialogo-carga-creacion/dialogo-carga-creacion.component';

@Component({
  selector: 'app-crear-promocion',
  templateUrl: './crear-promocion.component.html',
  styleUrls: ['./crear-promocion.component.css']
})
export class CrearPromocionComponent implements OnInit {

  promocion: Promociones;
  actividades: Actividad[];
  planes: Plan[];
  calificaciones: Calificacion[];
  ciudades: Ciudad[];
  form: FormGroup;

  ciudadesReales: Ciudad[] = [];
  planesReales: Plan[] = [];
  actividadesReales: Actividad[] = [];
  calificacionesReales: Calificacion[] = [];
  fechaReal_inicio: Date;
  fechaReal_fin: Date;

  nombre: string;
  fecha_inicio: Date;
  fecha_fin: Date;
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
              private servicioCiudades: CiudadesServiceService, private matSnack: MatSnackBar,
              private dialog: MatDialog) {}

  ngOnInit(): void {
    // Inicializa el promedio en 0
    this.promedio = 0;

    // Definición del formulario para la creación de una promoción
    this.form = this.fb.group({
      promoNombre: ['', [Validators.required]],
      promoFechaInicio: ['', [Validators.required]],
      promoFechaFin: ['', [Validators.required]],
      promoDescuento: ['', [Validators.required, Validators.min(0)]],
      promoMinVal: ['', [Validators.required, Validators.min(0)]],
      promoCiudades: ['Seleccione una opción', [Validators.required]],
      promoPlanes: ['Seleccione una opción', [Validators.required]],
      promoActividades: ['Seleccione una opción', [Validators.required]],
      promoCalificaciones: ['Seleccione una opción', [Validators.required]]
    });

    /* Obtención de la información necesaria para mostrar en los listados de selección múltiple, las
    ciudades, los planes comerciales, las actividades económcias y las calificación disponibles */
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
   * onSubmit: define lo que se hará al momento de dar clic en el botón de Crear Promoción
   */
  onSubmit(): void {
    /* Obtención de los elementos seleccionados en los desplegables de selección múltiple, y ajuste
    para ser remitidos en el DTO definido para la creación de la promoción */
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
    // Ajuste de fechas por desfase de horario (GMT-5)
    this.fechaReal_inicio = new Date(new Date(this.fecha_inicio).setHours(new Date(this.fecha_inicio).getHours() + 5));
    this.fechaReal_fin = new Date(new Date(this.fecha_fin).setHours(new Date(this.fecha_fin).getHours() + 5));

    // Creación del DTO de promoción que se enviará a la API para que sun información sea creada en BD
    this.promocion = new Promociones(this.nombre, this.fechaReal_inicio, this.fechaReal_fin,
                                    (this.descuento / 100), this.promedio, this.actividadesReales,
                                    this.calificacionesReales, this.planesReales, this.ciudadesReales);

    /* Activa la ventana emergente de carga del proceso de creación de una promoción, la cual se
    cierra tras la ejecución */
    const dialogRef = this.dialog.open(DialogoCargaCreacionComponent);
    dialogRef.afterOpened().subscribe(result => {
      // Hace llamado al método de creación de promoción
      this.servicioPromo.postPromocion(this.promocion).subscribe(() => {
        this.matSnack.open('Promoción creada exitosamente', 'Hecho');
        dialogRef.close();
        this.router.navigate(['promos']);
      }, error => {
        // Si es error del Cliente
        if (error.error.error == "Bad Request") {
          dialogRef.close();
          this.matSnack.open('Ha sucedido un error inesperado. Intenta la creación nuevamente y asegúrate de diligenciar todos los campos.', 'Hecho');
        }
        // Si es un error del Back-End
        else {
          dialogRef.close();
          this.matSnack.open(error.error.message, 'Hecho');
        }
      });
    });
  }

}
