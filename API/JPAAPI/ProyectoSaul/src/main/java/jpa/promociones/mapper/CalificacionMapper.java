package jpa.promociones.mapper;

import java.util.ArrayList;
import java.util.List;

import jpa.promociones.DTO.CalificacionDTO;
import jpa.promociones.modelo.Calificacion;

public class CalificacionMapper {

	public static Calificacion toEntity(CalificacionDTO calificacionDTO) {
		
		Calificacion calificacion = new Calificacion();
		
		calificacion.setId(calificacionDTO.getIdDTO());
		calificacion.setNombre(calificacionDTO.getNombreDTO());
				
		return calificacion;
		
	}
	
	public static CalificacionDTO toDTO(Calificacion calificacion) {
		
		CalificacionDTO calificacionDTO = new CalificacionDTO();
		
		calificacionDTO.setIdDTO(calificacion.getId());
		calificacionDTO.setNombreDTO(calificacion.getNombre());
				
		return calificacionDTO;
		
	}
	
	public static List<CalificacionDTO> entityListToDtoList(List<Calificacion> listaCalificaciones){
		
		List<CalificacionDTO> listaCalificacionesDTO = new ArrayList<>();
		
		for(Calificacion ele : listaCalificaciones) {
			listaCalificacionesDTO.add(CalificacionMapper.toDTO(ele));
		}
		
		return listaCalificacionesDTO;
	}
	
	public static List<Calificacion> dtoListToEntityList(List<CalificacionDTO> listaCalificacionesDTO){
		
		List<Calificacion> listaCalificaciones = new ArrayList<>();
		
		for(CalificacionDTO ele : listaCalificacionesDTO) {
			listaCalificaciones.add(CalificacionMapper.toEntity(ele));
		}
		
		return listaCalificaciones;
	}
	
}