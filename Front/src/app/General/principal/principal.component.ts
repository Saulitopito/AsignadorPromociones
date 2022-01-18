import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-principal',
  templateUrl: './principal.component.html',
  styleUrls: ['./principal.component.css']
})
export class PrincipalComponent implements OnInit {

  foot: string;

  constructor(private router: Router) { }

  ngOnInit(): void {
    this.foot = 'val';
  }

}
