import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { Clientes } from '../Modelos/clientes';
import { catchError } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class ClientesServiceService {

  constructor(private http: HttpClient) { }

  getClientes(idPromo: number): Observable<Clientes[]>{
    return this.http.get<Clientes[]>(`http://localhost:8080/api/clientes/${idPromo}`).pipe(catchError(this.handleError));
  }

  /*postClientes(cliente: Clientes): Observable<Clientes>{
    return this.http.post<Clientes>('http://localhost:8080/api/clientes', cliente);
  }*/

  handleError(error){
    return throwError(error);
  }

}
