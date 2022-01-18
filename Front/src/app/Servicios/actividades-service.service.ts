import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Actividad } from '../Modelos/actividad';

@Injectable({
  providedIn: 'root'
})
export class ActividadesServiceService {

  constructor(private http: HttpClient) { }

  /**
   * getActividades: obtiene la totalidad de actividades económicas, para ser mostradas en los 
   *                 formularios de creación y de modificación de promociones
   * @returns - Listado de actividades económicas
   */
  getActividades(): Observable<Actividad[]>{
    return this.http.get<Actividad[]>('http://localhost:8080/api/actividades');
  }
}
