package jpa.promociones.DTO;

import java.io.Serializable;
import java.util.Date;

public class RegistroAsignacionDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer idDTO;
	private Date fechaDTO;
	private ClienteDTONOTUSED clienteDTO;
	private PromocionDTO promocionDTO;
		
	public Integer getIdDTO() {
		return idDTO;
	}
	public void setIdDTO(Integer idDTO) {
		this.idDTO = idDTO;
	}
	public Date getFechaDTO() {
		return fechaDTO;
	}
	public void setFechaDTO(Date fechaDTO) {
		this.fechaDTO = fechaDTO;
	}
	public ClienteDTONOTUSED getClienteDTO() {
		return clienteDTO;
	}
	public void setClienteDTO(ClienteDTONOTUSED clienteDTO) {
		this.clienteDTO = clienteDTO;
	}
	public PromocionDTO getPromocionDTO() {
		return promocionDTO;
	}
	public void setPromocionDTO(PromocionDTO promocionDTO) {
		this.promocionDTO = promocionDTO;
	}
	
	
	

}
