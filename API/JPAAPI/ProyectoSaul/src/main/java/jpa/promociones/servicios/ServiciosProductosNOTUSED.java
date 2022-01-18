package jpa.promociones.servicios;

import java.util.List;

import jpa.promociones.DTO.ProductoDTO;

public interface ServiciosProductosNOTUSED {
	
	public List<ProductoDTO> getProductos();
	
	public ProductoDTO getProducto(Integer productoId);
	
}