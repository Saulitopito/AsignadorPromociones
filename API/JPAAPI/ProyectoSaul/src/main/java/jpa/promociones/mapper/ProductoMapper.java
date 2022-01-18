package jpa.promociones.mapper;

import java.util.ArrayList;
import java.util.List;

import jpa.promociones.DTO.ProductoDTO;
import jpa.promociones.modelo.Productos;

public class ProductoMapper {

	public static Productos toEntity(ProductoDTO productoDTO) {
		
		Productos producto = new Productos();
		
		producto.setId(productoDTO.getIdDTO());
		producto.setNombre(productoDTO.getNombreDTO());
		producto.setValor(productoDTO.getValorDTO());
				
		return producto;
		
	}
	
	public static ProductoDTO toDTO(Productos producto) {
		
		ProductoDTO productoDTO = new ProductoDTO();
		
		productoDTO.setIdDTO(producto.getId());
		productoDTO.setNombreDTO(producto.getNombre());
		productoDTO.setValorDTO(producto.getValor());
				
		return productoDTO;
		
	}
	
	public static List<ProductoDTO> entityListToDtoList(List<Productos> listaProductos){
		
		List<ProductoDTO> listaProductosDTO = new ArrayList<>();
		
		for(Productos ele : listaProductos) {
			listaProductosDTO.add(ProductoMapper.toDTO(ele));
		}
		
		return listaProductosDTO;
	}
	
	public static List<Productos> dtoListToEntityList(List<ProductoDTO> listaProductosDTO){
		
		List<Productos> listaProductos = new ArrayList<>();
		
		for(ProductoDTO ele : listaProductosDTO) {
			listaProductos.add(ProductoMapper.toEntity(ele));
		}
		
		return listaProductos;
	}
	
}