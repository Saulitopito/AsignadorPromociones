package jpa.promociones.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "promociones")
public class Promociones implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_promo")
	@SequenceGenerator(name = "sec_promo", sequenceName = "sec_promo", allocationSize = 1, initialValue = 1)
	private Integer id;
	
	private String nombre;
	private Date fecha_inicio;
	private Date fecha_fin;
	private Double descuento;
	private Double min_val;
	private Integer estado;
	private Date fecha_inactiva;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "promo_id")
	private List<PromoActividad> promoActividad;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "promo_id")
	private List<PromoCalificacion> promoCalificacion;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "promo_id")
	private List<PromoPlan> promoPlan;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "promo_id")
	private List<PromoCiudad> promoCiudad;
	
	@OneToMany(mappedBy = "promo_id")
	private List<RegistroAsignaciones> asignaciones;
	
	@OneToMany(mappedBy = "promo_id")
	private List<Clientes> clientes;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public Date getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	public Double getDescuento() {
		return descuento;
	}
	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}
	public Double getMin_val() {
		return min_val;
	}
	public void setMin_val(Double min_val) {
		this.min_val = min_val;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	public Date getFecha_inactiva() {
		return fecha_inactiva;
	}
	public void setFecha_inactiva(Date fecha_inactiva) {
		this.fecha_inactiva = fecha_inactiva;
	}
	
	
	
}
