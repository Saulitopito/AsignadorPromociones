package jpa.promociones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jpa.promociones.servicios.ServiciosProductos;
import jpa.promociones.DTO.ProductoDTO;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ProductosController {
	
	@Autowired
	private ServiciosProductos servicioProd;
	
	/*@GetMapping("/productos")
	public ResponseEntity<List<ProductoDTO>> listarProductos() {
		try {
			return ResponseEntity.ok(servicioProd.getProductos());
			//return servicioCliente.getClientes();
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.noContent().build();
			//return null;
		}
	}
	
	@GetMapping("/productos/{id}")
	public ResponseEntity<ProductoDTO> getProducto(@PathVariable(value = "id") Integer prodId) {
		try {
			return ResponseEntity.ok(servicioProd.getProducto(prodId));
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.noContent().build();
		}
	}*/
	
}