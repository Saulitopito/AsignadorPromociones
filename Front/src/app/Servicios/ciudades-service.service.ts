import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Ciudad } from '../Modelos/ciudad';

@Injectable({
  providedIn: 'root'
})
export class CiudadesServiceService {

  constructor(private http: HttpClient) { }

  /**
   * getCiudades: obtiene la totalidad de ciudades, para ser mostradas en los formularios de 
   *              creación y de modificación de promociones
   * @returns - Listado de ciudades
   */
  getCiudades(): Observable<Ciudad[]>{
    return this.http.get<Ciudad[]>('http://localhost:8080/api/ciudades');
  }
}
