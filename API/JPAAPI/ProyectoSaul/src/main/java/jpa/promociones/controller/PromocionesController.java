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
	 * listarPromociones: Ruta y método HTTP para obtener todas las promociones como DTO
	 * @return - Lista de promociones
	 */
	@GetMapping("/promociones")
	public ResponseEntity<List<PromocionDTO>> listarPromociones() {
		try {
			return ResponseEntity.ok(servicioPromo.getPromociones());
		} catch (Exception e) {
			//return ResponseEntity.noContent().build();
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hay promociones para mostrar.\nPor favor verifique su conexión o comuníquese con el administrador.", e);
					
		}
	}
	
	/**
	 * getPromocion: Ruta y método HTTP para obtener una promoción como DTO, según su id
	 * @param promocionId
	 * @return - Una promoción
	 */
	@GetMapping("/promociones/{id}")
	public ResponseEntity<PromocionDTO> getPromocion(@PathVariable(value = "id") Integer promocionId) {
		try {
			return ResponseEntity.ok(servicioPromo.getPromocion(promocionId));
		} catch (Exception e) {
			//return ResponseEntity.badRequest().build();
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Debe especificar una promoción a modificar.", e);
		}
	}
	
	/**
	 * crearPromocion: Ruta y método HTTP para crear una promocón, recibiendo un DTO
	 * @param nuevaPromocion
	 * @return - Una promoción creada
	 */
	@PostMapping("/promociones")
	public ResponseEntity<PromocionDTO> crearPromocion(@RequestBody PromocionDTO nuevaPromocion) {
		try {
			return ResponseEntity.ok(servicioPromo.crearPromocion(nuevaPromocion));
		} catch (Exception e) {
			//return ResponseEntity.badRequest().build();
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ha sucedido un error inesperado. Intenta la creación nuevamente y asegúrate de diligenciar todos los campos.", e);
		}
	}
	
	/**
	 *actualizarPromocion: Ruta y método HTTP para actualizar una promoción, recibiendo una 
	 *					   promoción como DTO y su id 
	 * @param promocionId
	 * @param promocionDTO
	 * @return - Una promoción actualizada
	 */
	@PutMapping("/promociones/{id}")
	public ResponseEntity<PromocionDTO> actualizaPromocion(@PathVariable(value = "id") Integer promocionId, @RequestBody PromocionDTO promocionDTO){
		try {
			return ResponseEntity.ok(servicioPromo.actualizarPromocion(promocionId, promocionDTO));
		}
		catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ha sucedido un error inesperado. Intenta la creación nuevamente y asegúrate de diligenciar todos los campos.", e);
		}
		
	}
	
	/**
	 * inhabilitarPromocion: Ruta y método HTTP para inhabilitar una promoción según su id, ya 
	 * 						 que no se eliminan
	 * @param promocionID
	 * @return - Una promoción actualizada
	 */
	@PutMapping("/promocionesInhabilitar/{id}")
	public ResponseEntity<?> inhabilitarPromocion(@PathVariable(value = "id") Integer promocionID){
		try {
			servicioPromo.inhabilitarPromocion(promocionID);
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		catch (Exception e) {
			//return ResponseEntity.badRequest().build();
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sucedió un error inesperado en la eliminación de la promoción. \nPor favor intentar nuevamente.", e);
		}
	}
	
	/**
	 * asignarPromociones: Ruta y método HTTP para poder realizar la asignación de promociones 
	 * 					   bajo demanda desde la App
	 * @return - Resultado de la asignación de promociones
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
	 * quitarPromociones: Ruta y método HTTP para poder quitar las asignación de las promociones
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
