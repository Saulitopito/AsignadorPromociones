import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Promociones } from '../Modelos/promociones';

@Injectable({
  providedIn: 'root'
})
export class PromocionesServiceService {

  constructor(private http: HttpClient) { }

  /**
   * getPromociones: obtiene todas las promociones
   * @returns - Listado de promociones
   */
  getPromociones(): Observable<Promociones[]>{
    return this.http.get<Promociones[]>('http://localhost:8080/api/promociones');
  }

  /**
   * getPromocion: obtiene una promoción en particular, según su id
   * @param id - Id de la promoción a consultar
   * @returns - Una promoción
   */
  getPromocion(id: number): Observable<Promociones>{
    return this.http.get<Promociones>(`http://localhost:8080/api/promociones/${id}`);
  }

  /**
   * postPromocion: crea una nueva promoción pasando su contenido como cuerpo
   * @param promocion - Cuerpo de la promoción a crear
   * @returns - Promoción creada
   */
  postPromocion(promocion: Promociones): Observable<Promociones>{
    return this.http.post<Promociones>('http://localhost:8080/api/promociones', promocion);
  }

  /**
   * putPromocion: actualiza una promoción en particular, pasando su id y su nuevo cuerpo
   * @param promocion - Cuerpo de la promoción a actualizar
   * @param id - Id de la promoción a actualizar
   * @returns - Promoción actualizada
   */
  putPromocion(promocion: Promociones, id: number): Observable<Promociones>{
    return this.http.put<Promociones>(`http://localhost:8080/api/promociones/${id}`, promocion);
  }

  /**
   * inhabilitarPromocion: actualiza una promoción en particular, pasando su cuerpo, con el fin de
   *                       cambiar su estado de activo (1) a inhabilitado (0)
   * @param promocion - Cuerpo de la promoción a inhabilitar
   * @returns - Promoción actualizada
   */
  inhabilitarPromocion(promocion: Promociones): Observable<any> {
    return this.http.put(`http://localhost:8080/api/promocionesInhabilitar/${promocion.idDTO}`, promocion);
  }

  /**
   * asignarPromociones: activa el procedimiento que asigna las promociones a los clientes que
   *                     cumplen con las condiciones necesarias para ello
   * @returns - Mensaje de cofirmación o error
   */
  asignarPromociones(): Observable<Promociones[]>{
    return this.http.get<any>('http://localhost:8080/api/asignacion');
  }

  /**
   * quitarPromociones: quita todas las promociones asignadas a todos los clientes. Este método no es
   *                    oficial, pues sólo se usa a manera de ejercicio para ver de una manera más
   *                    notoria la asignación de las promociones.
   *                    Para desasignar promociones, existe un procedimiento en PL/SQL que se
   *                    encarga de esta operación de manera programada, como un job mensual.
   * @returns - Mensaje de confirmación o error
   */
  quitarPromociones(): Observable<Promociones[]>{
    return this.http.get<any>('http://localhost:8080/api/quitarPromociones');
  }

}
