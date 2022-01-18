import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Clientes } from 'src/app/Modelos/clientes';
import { ClientesServiceService } from 'src/app/Servicios/clientes-service.service';

@Component({
  selector: 'app-listar-clientes',
  templateUrl: './listar-clientes.component.html',
  styleUrls: ['./listar-clientes.component.css']
})
export class ListarClientesComponent implements OnInit {

  clientes: Clientes[];

  constructor(private servicioClientes: ClientesServiceService, private router: Router) { }

  ngOnInit(): void {
    this.servicioClientes.getClientes().subscribe((data: Clientes[]) => {
      this.clientes = data;
    });
  }

  crearCliente(){
    this.router.navigate(['crear-clientes']);
  }

}
