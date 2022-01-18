package jpa.promociones.modelo;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "promo_calificacion")
public class PromoCalificacion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_promo_calificacion")
	@SequenceGenerator(name = "sec_promo_calificacion", sequenceName = "sec_promo_calificacion", allocationSize = 1, initialValue = 1)
	private Integer id;
	
	private Integer promo_id;
	private Integer calificacion_id;
	
	@ManyToOne
	@JoinColumn(name = "calificacion_id", insertable = false, updatable = false)
	private Calificacion calificacion;
	
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
	public Integer getCalificacion_id() {
		return calificacion_id;
	}
	public void setCalificacion_id(Integer calificacion_id) {
		this.calificacion_id = calificacion_id;
	}
	
	
	
	
}
