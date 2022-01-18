package jpa.promociones.mapper;

import java.util.ArrayList;
import java.util.List;

import jpa.promociones.DTO.PromocionDTO;
import jpa.promociones.modelo.Promociones;

public class PromocionesMapper {
	
	public static Promociones toEntity(PromocionDTO promocionDTO) {
		
		Promociones promocion = new Promociones();
		
		promocion.setId(promocionDTO.getIdDTO());
		promocion.setNombre(promocionDTO.getNombreDTO());
		promocion.setFecha_inicio(promocionDTO.getFecha_inicioDTO());
		promocion.setFecha_fin(promocionDTO.getFecha_finDTO());
		promocion.setDescuento(promocionDTO.getDescuentoDTO());
		promocion.setMin_val(promocionDTO.getMin_valDTO());
		promocion.setEstado(1);
		
		return promocion;
	}
	
	public static PromocionDTO toDTO(Promociones promocion) {
		
		PromocionDTO promocionDTO = new PromocionDTO();
		
		promocionDTO.setIdDTO(promocion.getId());
		promocionDTO.setNombreDTO(promocion.getNombre());
		promocionDTO.setFecha_inicioDTO(promocion.getFecha_inicio());
		promocionDTO.setFecha_finDTO(promocion.getFecha_fin());
		promocionDTO.setDescuentoDTO(promocion.getDescuento());
		promocionDTO.setMin_valDTO(promocion.getMin_val());
		
		return promocionDTO;
	}
	
	public static List<PromocionDTO> entityListToDtoList(List<Promociones> listaPromociones){
		
		List<PromocionDTO> listaPromocionesDTO = new ArrayList<>();
		
		for(Promociones ele : listaPromociones) {
			listaPromocionesDTO.add(PromocionesMapper.toDTO(ele));
		}
		
		return listaPromocionesDTO;
	}
	
	public static List<Promociones> dtoListToEntityList(List<PromocionDTO> listaPromocionDTO){
		
		List<Promociones> listaPromociones = new ArrayList<>();
		
		for(PromocionDTO ele : listaPromocionDTO) {
			listaPromociones.add(PromocionesMapper.toEntity(ele));
		}
		
		return listaPromociones;
	}

}
