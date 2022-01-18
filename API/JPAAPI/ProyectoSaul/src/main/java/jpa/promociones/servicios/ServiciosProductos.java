package jpa.promociones.servicios;

import java.util.List;
import java.util.Optional;

import jpa.promociones.DTO.ProductoDTO;

public interface ServiciosProductos {
	
	public List<ProductoDTO> getProductos();
	
	public ProductoDTO getProducto(Integer productoId);
	
}