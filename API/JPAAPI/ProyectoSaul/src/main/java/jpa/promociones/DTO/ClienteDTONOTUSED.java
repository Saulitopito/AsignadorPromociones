package jpa.promociones.DTO;

import java.io.Serializable;

public class ClienteDTONOTUSED implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer idDTO;
	private String nombreDTO;
	private String direccionDTO;
	private Long telefonoDTO;
	private String moraDTO;
	private Double promedioDTO;
	private CiudadDTO ciudadDTO;
	private PlanDTO planDTO;
	private ActividadDTO actividadDTO;
	private CalificacionDTO calificacionDTO;
	//private ProductoDTO productoDTO;
	private PromocionDTO promoDTO;
	
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
	public String getDireccionDTO() {
		return direccionDTO;
	}
	public void setDireccionDTO(String direccionDTO) {
		this.direccionDTO = direccionDTO;
	}
	public Long getTelefonoDTO() {
		return telefonoDTO;
	}
	public void setTelefonoDTO(Long telefonoDTO) {
		this.telefonoDTO = telefonoDTO;
	}
	/*public Integer getMoraDTO() {
		return moraDTO;
	}
	public void setMoraDTO(Integer moraDTO) {
		this.moraDTO = moraDTO;
	}*/
	
	public Double getPromedioDTO() {
		return promedioDTO;
	}
		public void setPromedioDTO(Double promedioDTO) {
		this.promedioDTO = promedioDTO;
	}
	public String getMoraDTO() {
		return moraDTO;
	}
	public void setMoraDTO(String moraDTO) {
		this.moraDTO = moraDTO;
	}
	/*public Integer getCiudadDTO() {
		return ciudadDTO;
	}
	public void setCiudadDTO(Integer ciudadDTO) {
		this.ciudadDTO = ciudadDTO;
	}
	public Integer getPlanDTO() {
		return planDTO;
	}
	public void setPlanDTO(Integer planDTO) {
		this.planDTO = planDTO;
	}
	public Integer getActividadDTO() {
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
	/*public Integer getPromocionDTO() {
		return promocionDTO;
	}
	public void setPromocionDTO(Integer promocionDTO) {
		this.promocionDTO = promocionDTO;
	}*/
	public CiudadDTO getCiudadDTO() {
		return ciudadDTO;
	}
	public void setCiudadDTO(CiudadDTO ciudadDTO) {
		this.ciudadDTO = ciudadDTO;
	}
	public PlanDTO getPlanDTO() {
		return planDTO;
	}
	public void setPlanDTO(PlanDTO planDTO) {
		this.planDTO = planDTO;
	}
	public ActividadDTO getActividadDTO() {
		return actividadDTO;
	}
	public void setActividadDTO(ActividadDTO actividadDTO) {
		this.actividadDTO = actividadDTO;
	}
	public CalificacionDTO getCalificacionDTO() {
		return calificacionDTO;
	}
	public void setCalificacionDTO(CalificacionDTO calificacionDTO) {
		this.calificacionDTO = calificacionDTO;
	}
	/*public ProductoDTO getProductoDTO() {
		return productoDTO;
	}
	public void setProductoDTO(ProductoDTO productoDTO) {
		this.productoDTO = productoDTO;
	}*/
	public PromocionDTO getPromoDTO() {
		return promoDTO;
	}
	public void setPromoDTO(PromocionDTO promoDTO) {
		this.promoDTO = promoDTO;
	}
	
	
	
	
}
