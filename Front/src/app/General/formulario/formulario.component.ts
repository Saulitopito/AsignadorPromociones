import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
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
import { ProductosServiceService } from 'src/app/Servicios/productos-service.service';
import { PromocionesServiceService } from 'src/app/Servicios/promociones-service.service';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.css']
})
export class FormularioComponent implements OnInit {

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
  largo: any;
  ciudad: Ciudad;
  plan: Plan;
  act: Actividad;
  cal: Calificacion;
  nombre: string;
  fecha_inicio: Date;
  fecha_fin: Date;
  descuento: number;
  promedio: number;
  ciudadesSeleccionadas: string[];
  actividadesSeleccionadas: string[];
  planesSeleccionados: string[];
  calificacionesSeleccionadas: string[];

  constructor(private servicioPromo: PromocionesServiceService, private router: Router, private fb: FormBuilder, private servicioActividades: ActividadesServiceService, private servicioPlanes: PlanesServiceService, private servicioCalificaciones: CalificacionesServiceService, private servicioCiudades: CiudadesServiceService, private servicioProductos: ProductosServiceService) {}

  ngOnInit(): void {
    this.form = this.fb.group({
      promoNombre: ['', [Validators.required]],
      promoFechaInicio: ['', [Validators.required]],
      promoFechaFin: ['', [Validators.required]],
      promoDescuento: ['', [Validators.required]],
      promoMinVal: ['', [Validators.required]],
      promoCiudades: ['Seleccione una opción', [Validators.required]],
      promoPlanes: ['Seleccione una opción', [Validators.required]],
      promoActividades: ['Seleccione una opción', [Validators.required]],
      promoCalificaciones: ['Seleccione una opción', [Validators.required]],
    });

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

  onSubmit(){
    
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
    this.promocion = new Promociones(this.nombre, this.fecha_inicio, this.fecha_fin, this.descuento, this.promedio, this.actividadesReales, this.calificacionesReales, this.planesReales, this.ciudadesReales);
    console.log(this.promocion);
    /*this.planesReales.push({idDTO: 0, nombreDTO: this.planesSeleccionados} as Plan);
    console.log(this.planesReales);
    this.actividadesReales.push({idDTO: 0, nombreDTO: this.actividadesSeleccionadas} as Actividad);
    console.log(this.actividadesReales);
    this.calificacionesReales.push({idDTO: 0, nombreDTO: this.calificacionesSeleccionadas} as Calificacion);
    console.log(this.calificacionesReales);*/
    

    /*
    this.plan = {idDTO: 0, nombreDTO: this.planesSeleccionados};
    this.promocion.planDTO.push(this.plan);
    
    this.act = {idDTO: 0, nombreDTO: this.actividadesSeleccionadas};
    this.promocion.actividadDTO.push(this.act);
    
    this.cal = {idDTO: 0, nombreDTO: this.ciudadesSeleccionadas};
    this.promocion.calificacionDTO.push(this.cal);
    
    //Esta configuración los crea, sin pasar los objetos internos
    /*this.promocion.ciudadDTO = this.ciudadesSeleccionadas;
    this.promocion.planDTO = this.planesSeleccionados;
    this.promocion.actividadDTO = this.actividadesSeleccionadas;
    this.promocion.calificacionDTO = this.calificacionesSeleccionadas;*/

    this.servicioPromo.postPromocion(this.promocion).subscribe(data => {
      alert('Promoción creada exitosamente');
      this.router.navigate(['promos']);
    });
  }

}
