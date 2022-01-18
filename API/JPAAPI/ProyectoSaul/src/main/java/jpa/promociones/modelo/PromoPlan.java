package jpa.promociones.modelo;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "promo_plan")
public class PromoPlan implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_promo_plan")
	@SequenceGenerator(name = "sec_promo_plan", sequenceName = "sec_promo_plan", allocationSize = 1, initialValue = 1)
	private Integer id;
	
	private Integer promo_id;
	private Integer plan_id;
	
	@ManyToOne
	@JoinColumn(name = "plan_id", insertable = false, updatable = false)
	private PlanComercial plan;
	
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

	public Integer getPlan_id() {
		return plan_id;
	}

	public void setPlan_id(Integer plan_id) {
		this.plan_id = plan_id;
	}
	
	

}
