package jpa.promociones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jpa.promociones.servicios.ServiciosActividad;
import jpa.promociones.DTO.ActividadDTO;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ActividadController {
	
	@Autowired
	private ServiciosActividad servicioActividad;
	
	/**
	 * listarActividades: Ruta y método HTTP para obtener todas las actividades económicas como DTO
	 * @return - Lista de actividades económicas
	 */
	@GetMapping("/actividades")
	public ResponseEntity<List<ActividadDTO>> listarActividades() {
		try {
			return ResponseEntity.ok(servicioActividad.getActividades());
		} catch (Exception e) {
			
			return ResponseEntity.noContent().build();
		}
	}
	
	/**
	 * getActividad: Ruta y método HTTP para obtener una actividad económica como DTO, según su id
	 * @param actividadId
	 * @return - Una actividad económica
	 */
	@GetMapping("/actividades/{id}")
	public ResponseEntity<ActividadDTO> getActividad(@PathVariable(value = "id") Integer actividadId) {
		try {
			return ResponseEntity.ok(servicioActividad.getActividad(actividadId));
		} catch (Exception e) {
			return ResponseEntity.noContent().build();
		}
	}
	
}
