package jpa.promociones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jpa.promociones.servicios.ServiciosPlan;
import jpa.promociones.DTO.PlanDTO;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PlanController {
	
	@Autowired
	private ServiciosPlan servicioPlan;
	
	/**
	 * listarPlanes: Ruta y método HTTP para obtener todos los planes comerciales como DTO
	 * @return - Lista de planes comerciales
	 */
	@GetMapping("/planes")
	public ResponseEntity<List<PlanDTO>> listarPlanes() {
		try {
			return ResponseEntity.ok(servicioPlan.getPlanes());
		} catch (Exception e) {
			return ResponseEntity.noContent().build();
		}
	}
	
	/**
	 * getPlan: Ruta y método HTTP para obtener un plan comercial como DTO, según su id
	 * @param planId
	 * @return - Un plan comercial
	 */
	@GetMapping("/planes/{id}")
	public ResponseEntity<PlanDTO> getPlan(@PathVariable(value = "id") Integer planId) {
		try {
			return ResponseEntity.ok(servicioPlan.getPlan(planId));
		} catch (Exception e) {
			return ResponseEntity.noContent().build();
		}
	}
	
}
