package jpa.promociones.servicios;

import java.util.List;

import jpa.promociones.DTO.PromocionDTO;

public interface ServiciosPromociones {
	
	public List<PromocionDTO> getPromociones();
	
	public PromocionDTO getPromocion(Integer promocionId);
	
	public PromocionDTO crearPromocion(PromocionDTO promocionDTO);
	
	public PromocionDTO actualizarPromocion(Integer id, PromocionDTO promocionDTO);
	
	public void inhabilitarPromocion(Integer id);
	
	public void asignarPromociones();
	
	public void quitarPromociones();
	
}