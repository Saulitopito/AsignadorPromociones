package jpa.promociones.servicios;

import java.util.List;

import jpa.promociones.DTO.CalificacionDTO;

public interface ServiciosCalificacion {
	
	public List<CalificacionDTO> getCalificaciones();
	
	public CalificacionDTO getCalificacion(Integer calificacionId);
	
}