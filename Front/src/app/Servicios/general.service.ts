import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class GeneralService {

  id: number;
  nombre: string;
  fecha_inicio: Date;
  fecha_fin: Date;
  descuento: number;
  promedio: number;
  ciudades: string[];
  actividades: string[];
  planes: string[];
  calificaciones: string[];

  constructor() { }
}
