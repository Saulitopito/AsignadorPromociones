package jpa.promociones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import jpa.promociones.servicios.ServiciosPromociones;
import jpa.promociones.DTO.PromocionDTO;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PromocionesController {
	
	@Autowired
	private ServiciosPromociones servicioPromo;
	
	/**
	 * listarPromociones: Ruta y m�todo HTTP para obtener todas las promociones como DTO
	 * @return - Lista de promociones
	 */
	@GetMapping("/promociones")
	public ResponseEntity<List<PromocionDTO>> listarPromociones() {
		try {
			return ResponseEntity.ok(servicioPromo.getPromociones());
		} catch (Exception e) {
			//return ResponseEntity.noContent().build();
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hay promociones para mostrar.\nPor favor verifique su conexi�n o comun�quese con el administrador.", e);
					
		}
	}
	
	/**
	 * getPromocion: Ruta y m�todo HTTP para obtener una promoci�n como DTO, seg�n su id
	 * @param promocionId
	 * @return - Una promoci�n
	 */
	@GetMapping("/promociones/{id}")
	public ResponseEntity<PromocionDTO> getPromocion(@PathVariable(value = "id") Integer promocionId) {
		try {
			return ResponseEntity.ok(servicioPromo.getPromocion(promocionId));
		} catch (Exception e) {
			//return ResponseEntity.badRequest().build();
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Debe especificar una promoci�n a modificar.", e);
		}
	}
	
	/**
	 * crearPromocion: Ruta y m�todo HTTP para crear una promoc�n, recibiendo un DTO
	 * @param nuevaPromocion
	 * @return - Una promoci�n creada
	 */
	@PostMapping("/promociones")
	public ResponseEntity<PromocionDTO> crearPromocion(@RequestBody PromocionDTO nuevaPromocion) {
		try {
			return ResponseEntity.ok(servicioPromo.crearPromocion(nuevaPromocion));
		} catch (Exception e) {
			//return ResponseEntity.badRequest().build();
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ha sucedido un error inesperado. Intenta la creaci�n nuevamente y aseg�rate de diligenciar todos los campos.", e);
		}
	}
	
	/**
	 *actualizarPromocion: Ruta y m�todo HTTP para actualizar una promoci�n, recibiendo una 
	 *					   promoci�n como DTO y su id 
	 * @param promocionId
	 * @param promocionDTO
	 * @return - Una promoci�n actualizada
	 */
	@PutMapping("/promociones/{id}")
	public ResponseEntity<PromocionDTO> actualizaPromocion(@PathVariable(value = "id") Integer promocionId, @RequestBody PromocionDTO promocionDTO){
		try {
			return ResponseEntity.ok(servicioPromo.actualizarPromocion(promocionId, promocionDTO));
		}
		catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ha sucedido un error inesperado. Intenta la creaci�n nuevamente y aseg�rate de diligenciar todos los campos.", e);
		}
		
	}
	
	/**
	 * inhabilitarPromocion: Ruta y m�todo HTTP para inhabilitar una promoci�n seg�n su id, ya 
	 * 						 que no se eliminan
	 * @param promocionID
	 * @return - Una promoci�n actualizada
	 */
	@PutMapping("/promocionesInhabilitar/{id}")
	public ResponseEntity<?> inhabilitarPromocion(@PathVariable(value = "id") Integer promocionID){
		try {
			servicioPromo.inhabilitarPromocion(promocionID);
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		catch (Exception e) {
			//return ResponseEntity.badRequest().build();
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sucedi� un error inesperado en la eliminaci�n de la promoci�n. \nPor favor intentar nuevamente.", e);
		}
	}
	
	/**
	 * asignarPromociones: Ruta y m�todo HTTP para poder realizar la asignaci�n de promociones 
	 * 					   bajo demanda desde la App
	 * @return - Resultado de la asignaci�n de promociones
	 */
	@GetMapping("/asignacion")
	public ResponseEntity<?> asignarPromociones() {
		try {
			servicioPromo.asignarPromociones();
			return ResponseEntity.ok().build();
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
		
	}
	
	/**
	 * quitarPromociones: Ruta y m�todo HTTP para poder quitar las asignaci�n de las promociones
	 * 					  a todos los clientes
	 * @return - Resultado de quitar las asignaciones de las promociones a todos los clientes
	 */
	@GetMapping("/quitarPromociones")
	public ResponseEntity<?> quitarPromociones() {
		try {
			servicioPromo.quitarPromociones();
			return ResponseEntity.ok().build();
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}

}
