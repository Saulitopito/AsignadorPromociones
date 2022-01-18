package jpa.promociones.mapper;

import java.util.ArrayList;
import java.util.List;

import jpa.promociones.DTO.ActividadDTO;
import jpa.promociones.modelo.ActividadEco;

public class ActividadMapper {

	public static ActividadEco toEntity(ActividadDTO actividadDTO) {
		
		ActividadEco actividad = new ActividadEco();
		
		actividad.setId(actividadDTO.getIdDTO());
		actividad.setNombre(actividadDTO.getNombreDTO());
				
		return actividad;
		
	}
	
	public static ActividadDTO toDTO(ActividadEco actividad) {
		
		ActividadDTO actividadDTO = new ActividadDTO();
		
		actividadDTO.setIdDTO(actividad.getId());
		actividadDTO.setNombreDTO(actividad.getNombre());
				
		return actividadDTO;
		
	}
	
	public static List<ActividadDTO> entityListToDtoList(List<ActividadEco> listaActividades){
		
		List<ActividadDTO> listaActividadesDTO = new ArrayList<>();
		
		for(ActividadEco ele : listaActividades) {
			listaActividadesDTO.add(ActividadMapper.toDTO(ele));
		}
		
		return listaActividadesDTO;
	}
	
	public static List<ActividadEco> dtoListToEntityList(List<ActividadDTO> listaActividadesDTO){
		
		List<ActividadEco> listaActividades = new ArrayList<>();
		
		for(ActividadDTO ele : listaActividadesDTO) {
			listaActividades.add(ActividadMapper.toEntity(ele));
		}
		
		return listaActividades;
	}
	
}