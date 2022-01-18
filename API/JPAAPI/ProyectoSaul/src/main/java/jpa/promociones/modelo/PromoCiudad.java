package jpa.promociones.modelo;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "promo_ciudad")
public class PromoCiudad implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_promo_ciudad")
	@SequenceGenerator(name = "sec_promo_ciudad", sequenceName = "sec_promo_ciudad", allocationSize = 1, initialValue = 1)
	private Integer id;
	
	private Integer promo_id;
	private Integer ciudad_id;
	
	@ManyToOne
	@JoinColumn(name = "ciudad_id", insertable = false, updatable = false)
	private Ciudades ciudad;
	
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

	public Integer getCiudad_id() {
		return ciudad_id;
	}

	public void setCiudad_id(Integer ciudad_id) {
		this.ciudad_id = ciudad_id;
	}
	
	

}
