package jpa.promociones.servicios;

import java.util.List;

import jpa.promociones.DTO.PlanDTO;

public interface ServiciosPlan {
	
	public List<PlanDTO> getPlanes();
	
	public PlanDTO getPlan(Integer planId);
	
}