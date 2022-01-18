package jpa.promociones.DTO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PromocionDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer idDTO;
	private String nombreDTO;
	private Date fecha_inicioDTO;
	private Date fecha_finDTO;
	private Double descuentoDTO;
	private Double min_valDTO;
	private List<ActividadDTO> actividadDTO;
	private List<CalificacionDTO> calificacionDTO;
	private List<PlanDTO> planDTO;
	private List<CiudadDTO> ciudadDTO;
	
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
	public Date getFecha_inicioDTO() {
		return fecha_inicioDTO;
	}
	public void setFecha_inicioDTO(Date fecha_inicioDTO) {
		this.fecha_inicioDTO = fecha_inicioDTO;
	}
	public Date getFecha_finDTO() {
		return fecha_finDTO;
	}
	public void setFecha_finDTO(Date fecha_finDTO) {
		this.fecha_finDTO = fecha_finDTO;
	}
	public Double getDescuentoDTO() {
		return descuentoDTO;
	}
	public void setDescuentoDTO(Double descuentoDTO) {
		this.descuentoDTO = descuentoDTO;
	}
	public Double getMin_valDTO() {
		return min_valDTO;
	}
	public void setMin_valDTO(Double min_valDTO) {
		this.min_valDTO = min_valDTO;
	}
	/*public Integer getActividadDTO() {
		return actividadDTO;
	}
	public void setActividadDTO(Integer actividadDTO) {
		this.actividadDTO = actividadDTO;
	}
	public Integer getCalificacionDTO() {
		return calificacionDTO;
	}
	public void setCalificacionDTO(Integer calificacionDTO) {
		this.calificacionDTO = calificacionDTO;
	}
	public Integer getPlanDTO() {
		return planDTO;
	}
	public void setPlanDTO(Integer planDTO) {
		this.planDTO = planDTO;
	}
	public Integer getCiudadDTO() {
		return ciudadDTO;
	}
	public void setCiudadDTO(Integer ciudadDTO) {
		this.ciudadDTO = ciudadDTO;
	}*/
	public List<ActividadDTO> getActividadDTO() {
		return actividadDTO;
	}
	public void setActividadDTO(List<ActividadDTO> actividadDTO) {
		this.actividadDTO = actividadDTO;
	}
	public List<CalificacionDTO> getCalificacionDTO() {
		return calificacionDTO;
	}
	public void setCalificacionDTO(List<CalificacionDTO> calificacionDTO) {
		this.calificacionDTO = calificacionDTO;
	}
	public List<PlanDTO> getPlanDTO() {
		return planDTO;
	}
	public void setPlanDTO(List<PlanDTO> planDTO) {
		this.planDTO = planDTO;
	}
	public List<CiudadDTO> getCiudadDTO() {
		return ciudadDTO;
	}
	public void setCiudadDTO(List<CiudadDTO> ciudadDTO) {
		this.ciudadDTO = ciudadDTO;
	}

	
	
	
	
}