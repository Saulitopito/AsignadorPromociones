package jpa.promociones.modelo;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "promo_asigna")
public class PromoAsigna {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_promo_asigna")
	@SequenceGenerator(name = "sec_promo_asigna", sequenceName = "sec_promo_asigna", allocationSize = 1, initialValue = 1)
	private Integer id;
	
	private Integer cliente_id;
	private Integer promo_id;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id", insertable = false, updatable = false)
	private Clientes cliente;
	
	@ManyToOne
	@JoinColumn(name = "promo_id", insertable = false, updatable = false)
	private Promociones promocion;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCliente_id() {
		return cliente_id;
	}
	public void setCliente_id(Integer cliente_id) {
		this.cliente_id = cliente_id;
	}
	public Integer getPromo_id() {
		return promo_id;
	}
	public void setPromo_id(Integer promo_id) {
		this.promo_id = promo_id;
	}
	
	
}
