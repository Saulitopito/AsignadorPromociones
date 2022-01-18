import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-principal',
  templateUrl: './principal.component.html',
  styleUrls: ['./principal.component.css']
})
export class PrincipalComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  Clientes(){
    this.router.navigate(['clientes']);
  }
  Promociones(){
    this.router.navigate(['promos']);
  }
  Asignaciones(){
    this.router.navigate(['asignaciones']);
  }

}
