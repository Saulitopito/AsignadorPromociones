import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Producto } from '../Modelos/producto';

@Injectable({
  providedIn: 'root'
})
export class ProductosServiceService {

  constructor(private http: HttpClient) { }

  getProductos(): Observable<Producto[]>{
    return this.http.get<Producto[]>('http://localhost:8080/api/productos');
  }
}
