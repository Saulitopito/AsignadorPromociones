package jpa.promociones.servicios;

import java.util.List;

import jpa.promociones.DTO.ActividadDTO;

public interface ServiciosActividad {
	
	public List<ActividadDTO> getActividades();
	
	public ActividadDTO getActividad(Integer actividadId);
	
}