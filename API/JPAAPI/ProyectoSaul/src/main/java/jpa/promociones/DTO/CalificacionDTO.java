package jpa.promociones.DTO;

import java.io.Serializable;

public class CalificacionDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer idDTO;
	private String nombreDTO;
	
	public Integer getIdDTO() {
		return idDTO;
	}
	public void setIdDTO(Integer idDTO) {
		this.idDTO = idDTO;
	}
	public String getNombreDTO() {
		return nombreDTO;
	}
	public void setNombreDTO(String nombreDTO) {
		this.nombreDTO = nombreDTO;
	}
	
	

}
