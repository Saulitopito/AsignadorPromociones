package jpa.promociones.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "registro_asignaciones")
public class RegistroAsignaciones implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_asigna")
	@SequenceGenerator(name = "sec_asigna", sequenceName = "sec_asigna", allocationSize = 1, initialValue = 1)
	private Integer id;
	
	private Date fecha;
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
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
}
