package jpa.promociones.servicios;

import java.util.List;

import jpa.promociones.DTO.CiudadDTO;

public interface ServiciosCiudad {
	
	public List<CiudadDTO> getCiudades();
	
	public CiudadDTO getCiudad(Integer ciudadId);
	
}