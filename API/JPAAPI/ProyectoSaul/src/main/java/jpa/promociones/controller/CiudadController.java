package jpa.promociones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jpa.promociones.servicios.ServiciosCiudad;
import jpa.promociones.DTO.CiudadDTO;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CiudadController {
	
	@Autowired
	private ServiciosCiudad servicioCiudad;
	
	/**
	 * listarCiudades: Ruta y método HTTP para obtener todas las ciudades como DTO
	 * @return - Lista de ciudades
	 */
	@GetMapping("/ciudades")
	public ResponseEntity<List<CiudadDTO>> listarCiudades() {
		try {
			return ResponseEntity.ok(servicioCiudad.getCiudades());
		} catch (Exception e) {
			return ResponseEntity.noContent().build();
		}
	}
	
	/**
	 * getCiudad: Ruta y método HTTP para obtener una ciudad como DTO, según su id
	 * @param ciudadId
	 * @return - Una ciudad
	 */
	@GetMapping("/ciudades/{id}")
	public ResponseEntity<CiudadDTO> getCiudad(@PathVariable(value = "id") Integer ciudadId) {
		try {
			return ResponseEntity.ok(servicioCiudad.getCiudad(ciudadId));
		} catch (Exception e) {
			return ResponseEntity.noContent().build();
		}
	}
	
}
