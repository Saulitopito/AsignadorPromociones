import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ClientePromo } from '../Modelos/cliente-promo';

@Injectable({
  providedIn: 'root'
})
export class ReporteServiceService {

  constructor(private http: HttpClient) { }

  /**
   * getClientesPromo: obtiene el listado de clientes que cuentan con una promoción asignada
   * @param promoId - Id de la promoción que se encuentra asignada a uno ó más clientes
   * @returns - Lista de clientes DTO con información adicional
   */
  getClientesPromo(): Observable<ClientePromo[]>{
    return this.http.get<ClientePromo[]>('http://localhost:8080/api/clientes');
  }
}
