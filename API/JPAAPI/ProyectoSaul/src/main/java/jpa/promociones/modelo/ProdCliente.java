package jpa.promociones.modelo;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "prod_cliente")
public class ProdCliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_prod_cliente")
	@SequenceGenerator(name = "sec_prod_cliente", sequenceName = "sec_prod_cliente", allocationSize = 1, initialValue = 1)
	private Integer id;
	
	private Double valor_ajustado;
	private Integer producto_id;
	private Integer cliente_id;
	
	@ManyToOne
	@JoinColumn(name = "producto_id", insertable = false, updatable = false)
	private Productos producto;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id", insertable = false, updatable = false)
	private Clientes cliente;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getValor_ajustado() {
		return valor_ajustado;
	}
	public void setValor_ajustado(Double valor_ajustado) {
		this.valor_ajustado = valor_ajustado;
	}
	public Integer getProducto_id() {
		return producto_id;
	}
	public void setProducto_id(Integer producto_id) {
		this.producto_id = producto_id;
	}
	public Integer getCliente_id() {
		return cliente_id;
	}
	public void setCliente_id(Integer cliente_id) {
		this.cliente_id = cliente_id;
	}
	
	

}
