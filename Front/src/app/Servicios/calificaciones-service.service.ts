import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Calificacion } from '../Modelos/calificacion';

@Injectable({
  providedIn: 'root'
})
export class CalificacionesServiceService {

  constructor(private http: HttpClient) { }

  /**
   * getCalificaciones: obtiene la totalidad de calificaciones, para ser mostradas en los 
   *                    formularios de creación y de modificación de promociones
   * @returns - Listado de calificaciones
   */
  getCalificaciones(): Observable<Calificacion[]>{
    return this.http.get<Calificacion[]>('http://localhost:8080/api/calificaciones');
  }
}
