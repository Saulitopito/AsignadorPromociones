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
	 * getClientesPromo: Ruta y método HTTP para obtener los clientes como DTO que tienen una 
	 * 					 promoción específica asignada
	 * @param promoId
	 * @return - Lista de clientes asociados a una promoción
	 */
	@GetMapping("/clientes")
	public ResponseEntity<List<ClientePromoDTO>> getClientesPromo() {
		try {
			return ResponseEntity.ok(servicioCliente.getClientesPromo());
		} catch (Exception e) {
			//return ResponseEntity.noContent().build();
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sucedió un error inesperado. \nPor favor verifique su conexión o comuníquese con el administrador.", e);			
		}
	}
}
