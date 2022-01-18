import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Plan } from '../Modelos/plan';

@Injectable({
  providedIn: 'root'
})
export class PlanesServiceService {

  constructor(private http: HttpClient) { }

  /**
   * getPlanes: obtiene la totalidad de planes comerciales, para ser mostradas en los formularios de 
   *            creación y de modificación de promociones
   * @returns - Listado de planes comerciales
   */
  getPlanes(): Observable<Plan[]>{
    return this.http.get<Plan[]>('http://localhost:8080/api/planes');
  }
}
