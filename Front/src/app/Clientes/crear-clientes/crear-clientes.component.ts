import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Actividad } from 'src/app/Modelos/actividad';
import { Calificacion } from 'src/app/Modelos/calificacion';
import { Ciudad } from 'src/app/Modelos/ciudad';
import { Clientes } from 'src/app/Modelos/clientes';
import { Plan } from 'src/app/Modelos/plan';
import { Producto } from 'src/app/Modelos/producto';
import { ActividadesServiceService } from 'src/app/Servicios/actividades-service.service';
import { CalificacionesServiceService } from 'src/app/Servicios/calificaciones-service.service';
import { CiudadesServiceService } from 'src/app/Servicios/ciudades-service.service';
import { ClientesServiceService } from 'src/app/Servicios/clientes-service.service';
import { PlanesServiceService } from 'src/app/Servicios/planes-service.service';
import { ProductosServiceService } from 'src/app/Servicios/productos-service.service';

@Component({
  selector: 'app-crear-clientes',
  templateUrl: './crear-clientes.component.html',
  styleUrls: ['./crear-clientes.component.css']
})
export class CrearClientesComponent implements OnInit {

  cliente: Clientes = new Clientes();
  actividades: Actividad[];
  planes: Plan[];
  calificaciones: Calificacion[];
  ciudades: Ciudad[];
  productos: Producto[];
  form: FormGroup;

  constructor(private servicioClientes: ClientesServiceService, private router: Router, private fb: FormBuilder, private servicioActividades: ActividadesServiceService, private servicioPlanes: PlanesServiceService, private servicioCalificaciones: CalificacionesServiceService, private servicioCiudades: CiudadesServiceService, private servicioProductos: ProductosServiceService) { 
      this.form = this.fb.group({
        clienteNombre: ['', [Validators.required]],
        clienteDireccion: ['', [Validators.required]],
        clienteTelefono: ['', [Validators.required]],
        clienteCiudad: ['Selecciones una opción', [Validators.required]],
        clientePlan: ['Selecciones una opción', [Validators.required]],
        clienteActividad: ['Selecciones una opción', [Validators.required]],
        clienteCalificacion: ['Selecciones una opción', [Validators.required]],
        clienteProducto: ['Selecciones una opción', [Validators.required]],
      });
    }

  ngOnInit(): void {
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
    this.servicioProductos.getProductos().subscribe(data5 => {
      this.productos = data5;
    });
  }

  onSubmit(){
    this.servicioClientes.postClientes(this.cliente).subscribe(data => {
      alert('Cliente creado exitosamente');
      this.router.navigate(['clientes']);
    })
  }

}
