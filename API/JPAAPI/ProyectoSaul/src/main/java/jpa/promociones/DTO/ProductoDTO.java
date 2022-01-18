package jpa.promociones.DTO;

import java.io.Serializable;

public class ProductoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer idDTO;
	private String nombreDTO;
	private Double valorDTO;
	
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
	public Double getValorDTO() {
		return valorDTO;
	}
	public void setValorDTO(Double valorDTO) {
		this.valorDTO = valorDTO;
	}
	
	
	

}
