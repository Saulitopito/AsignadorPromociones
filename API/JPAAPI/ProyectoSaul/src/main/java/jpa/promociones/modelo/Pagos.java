package jpa.promociones.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "pagos")
public class Pagos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_pagos")
	@SequenceGenerator(name = "sec_pagos", sequenceName = "sec_pagos", allocationSize = 1, initialValue = 1)
	private Integer id;
	
	private Date fecha;
	private Double valor;
	private Integer cliente_id;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id", insertable = false, updatable = false)
	private Clientes clientes;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Integer getCliente_id() {
		return cliente_id;
	}
	public void setCliente_id(Integer cliente_id) {
		this.cliente_id = cliente_id;
	}
	
	
	
}
