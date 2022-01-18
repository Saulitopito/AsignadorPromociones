package jpa.promociones.modelo;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "promo_actividad")
public class PromoActividad implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_promo_actividad")
	@SequenceGenerator(name = "sec_promo_actividad", sequenceName = "sec_promo_actividad", allocationSize = 1, initialValue = 1)
	private Integer id;
	
	private Integer promo_id;
	private Integer actividad_id;
	
	@ManyToOne
	@JoinColumn(name = "actividad_id", insertable = false, updatable = false)
	private ActividadEco actividadEco;
	
	@ManyToOne
	@JoinColumn(name = "promo_id", insertable = false, updatable = false)
	private Promociones promocion;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPromo_id() {
		return promo_id;
	}
	public void setPromo_id(Integer promo_id) {
		this.promo_id = promo_id;
	}
	public Integer getActividad_id() {
		return actividad_id;
	}
	public void setActividad_id(Integer actividad_id) {
		this.actividad_id = actividad_id;
	}
	
	
	
}
