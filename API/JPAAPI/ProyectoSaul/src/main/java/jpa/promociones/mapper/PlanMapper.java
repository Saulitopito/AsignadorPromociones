package jpa.promociones.mapper;

import java.util.ArrayList;
import java.util.List;

import jpa.promociones.DTO.PlanDTO;
import jpa.promociones.modelo.PlanComercial;

public class PlanMapper {

	public static PlanComercial toEntity(PlanDTO planDTO) {
		
		PlanComercial plan = new PlanComercial();
		
		plan.setId(planDTO.getIdDTO());
		plan.setNombre(planDTO.getNombreDTO());
				
		return plan;
		
	}
	
	public static PlanDTO toDTO(PlanComercial plan) {
		
		PlanDTO planDTO = new PlanDTO();
		
		planDTO.setIdDTO(plan.getId());
		planDTO.setNombreDTO(plan.getNombre());
				
		return planDTO;
		
	}
	
	public static List<PlanDTO> entityListToDtoList(List<PlanComercial> listaPlanes){
		
		List<PlanDTO> listaPlanesDTO = new ArrayList<>();
		
		for(PlanComercial ele : listaPlanes) {
			listaPlanesDTO.add(PlanMapper.toDTO(ele));
		}
		
		return listaPlanesDTO;
	}
	
	public static List<PlanComercial> dtoListToEntityList(List<PlanDTO> listaPlanesDTO){
		
		List<PlanComercial> listaPlanes = new ArrayList<>();
		
		for(PlanDTO ele : listaPlanesDTO) {
			listaPlanes.add(PlanMapper.toEntity(ele));
		}
		
		return listaPlanes;
	}
	
}
