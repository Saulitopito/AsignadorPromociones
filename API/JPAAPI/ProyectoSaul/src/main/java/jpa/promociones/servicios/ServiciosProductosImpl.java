package jpa.promociones.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jpa.promociones.DTO.ProductoDTO;
import jpa.promociones.mapper.ProductoMapper;
import jpa.promociones.modelo.Productos;
import jpa.promociones.repository.ProductosRepository;

@Service
public class ServiciosProductosImpl implements ServiciosProductos {
	
	@Autowired
	private ProductosRepository prodRepo;
	
	
	@Override
	public List<ProductoDTO> getProductos() {
		List<ProductoDTO> listaProductosDTO = ProductoMapper.entityListToDtoList(this.prodRepo.findAll()); 
		return listaProductosDTO;
	}
	
	@Override
	public ProductoDTO getProducto(Integer prodId) {
		Productos producto = this.prodRepo.findById(prodId).get();
		ProductoDTO productoDTO = ProductoMapper.toDTO(producto);
		return productoDTO;
	}

}
