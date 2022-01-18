package jpa.promociones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import jpa.promociones.servicios.ServiciosCliente;
import jpa.promociones.DTO.ClientePromoDTO;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ClientesController {
	
	@Autowired
	private ServiciosCliente servicioCliente;
	
	//
	/**
	 * getClientesPromo: Ruta y m�todo HTTP para obtener los clientes como DTO que tienen una 
	 * 					 promoci�n espec�fica asignada
	 * @param promoId
	 * @return - Lista de clientes asociados a una promoci�n
	 */
	@GetMapping("/clientes")
	public ResponseEntity<List<ClientePromoDTO>> getClientesPromo() {
		try {
			return ResponseEntity.ok(servicioCliente.getClientesPromo());
		} catch (Exception e) {
			//return ResponseEntity.noContent().build();
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sucedi� un error inesperado. \nPor favor verifique su conexi�n o comun�quese con el administrador.", e);			
		}
	}
}
