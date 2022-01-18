package jpa.promociones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jpa.promociones.servicios.ServiciosCalificacion;
import jpa.promociones.DTO.CalificacionDTO;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CalificacionController {
	
	@Autowired
	private ServiciosCalificacion servicioCalificacion;
	
	/**
	 *listarCalificaciones: Ruta y m�todo HTTP para obtener todas las calificaciones como DTO 
	 * @return - Lista de calificaciones
	 */
	@GetMapping("/calificaciones")
	public ResponseEntity<List<CalificacionDTO>> listarCalificaciones() {
		try {
			return ResponseEntity.ok(servicioCalificacion.getCalificaciones());
		} catch (Exception e) {
			return ResponseEntity.noContent().build();
		}
	}
	
	/**
	 *getCalificacion: Ruta y m�todo HTTP para obtener un calificaci�n como DTO, seg�n su id 
	 * @param calificacionId
	 * @return - Una calificaci�n
	 */
	@GetMapping("/calificaciones/{id}")
	public ResponseEntity<CalificacionDTO> getCalificacion(@PathVariable(value = "id") Integer calificacionId) {
		try {
			return ResponseEntity.ok(servicioCalificacion.getCalificacion(calificacionId));
		} catch (Exception e) {
			return ResponseEntity.noContent().build();
		}
	}
	
}
