package jpa.promociones.DTO;

import java.io.Serializable;

public class ClientePromoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nombrePromoDTO;
	private String nombreDTO;
	private CiudadDTO ciudadDTO;
	private ActividadDTO actividadDTO;
	private Double porcentajeDTO;
	private Double valorDTO;
	private Double valorRealDTO;
	
	public String getNombreDTO() {
		return nombreDTO;
	}
	public void setNombreDTO(String nombreDTO) {
		this.nombreDTO = nombreDTO;
	}
	public CiudadDTO getCiudadDTO() {
		return ciudadDTO;
	}
	public void setCiudadDTO(CiudadDTO ciudadDTO) {
		this.ciudadDTO = ciudadDTO;
	}
	public ActividadDTO getActividadDTO() {
		return actividadDTO;
	}
	public void setActividadDTO(ActividadDTO actividadDTO) {
		this.actividadDTO = actividadDTO;
	}
	public Double getPorcentajeDTO() {
		return porcentajeDTO;
	}
	public void setPorcentajeDTO(Double porcentajeDTO) {
		this.porcentajeDTO = porcentajeDTO;
	}
	public Double getValorDTO() {
		return valorDTO;
	}
	public void setValorDTO(Double valorDTO) {
		this.valorDTO = valorDTO;
	}
	public Double getValorRealDTO() {
		return valorRealDTO;
	}
	public void setValorRealDTO(Double valorRealDTO) {
		this.valorRealDTO = valorRealDTO;
	}
	public String getNombrePromoDTO() {
		return nombrePromoDTO;
	}
	public void setNombrePromoDTO(String nombrePromoDTO) {
		this.nombrePromoDTO = nombrePromoDTO;
	}
	
	

}
