package jpa.promociones.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "clientes")
public class Clientes implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_cliente")
	@SequenceGenerator(name = "sec_cliente", sequenceName = "sec_cliente", allocationSize = 1, initialValue = 1)
	private Integer id;
	
	private String nombre;
	private String direccion;
	private Long telefono;
	private Integer mora;
	private Double promedio;
	private Integer ciudad_id;
	private Integer plan_id;
	private Integer actividad_id;
	private Integer calificacion_id;
	private Integer promo_id;
	
	@OneToMany(mappedBy = "cliente_id")
	private List<Pagos> pagos;
	
	@ManyToOne
	@JoinColumn(name = "actividad_id", insertable = false, updatable = false)
	private ActividadEco actividadEco;
	
	@ManyToOne
	@JoinColumn(name = "calificacion_id", insertable = false, updatable = false)
	private Calificacion calificacion;
	
	@ManyToOne
	@JoinColumn(name = "ciudad_id", insertable = false, updatable = false)
	private Ciudades ciudad;
	
	@ManyToOne
	@JoinColumn(name = "plan_id", insertable = false, updatable = false)
	private PlanComercial plan;
	
	@ManyToOne
	@JoinColumn(name = "promo_id", insertable = false, updatable = false)
	private Promociones promocion;
	
	@OneToMany(mappedBy = "cliente_id")
	private List<RegistroAsignaciones> asignaciones;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente_id")
	private List<ProdCliente> prodClientes;
	
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
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Long getTelefono() {
		return telefono;
	}
	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}
	public Integer getMora() {
		return mora;
	}
	public void setMora(Integer mora) {
		this.mora = mora;
	}
	public Double getPromedio() {
		return promedio;
	}
	public void setPromedio(Double promedio) {
		this.promedio = promedio;
	}
	public Integer getCiudad_id() {
		return ciudad_id;
	}
	public void setCiudad_id(Integer ciudad_id) {
		this.ciudad_id = ciudad_id;
	}
	public Integer getPlan_id() {
		return plan_id;
	}
	public void setPlan_id(Integer plan_id) {
		this.plan_id = plan_id;
	}
	public Integer getActividad_id() {
		return actividad_id;
	}
	public void setActividad_id(Integer actividad_id) {
		this.actividad_id = actividad_id;
	}
	public Integer getCalificacion_id() {
		return calificacion_id;
	}
	public void setCalificacion_id(Integer calificacion_id) {
		this.calificacion_id = calificacion_id;
	}
	/*
	public ActividadEco getActividadEco() {
		return actividadEco;
	}
	public void setActividadEco(ActividadEco actividadEco) {
		this.actividadEco = actividadEco;
	}
	public Calificacion getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(Calificacion calificacion) {
		this.calificacion = calificacion;
	}
	public Ciudades getCiudad() {
		return ciudad;
	}
	public void setCiudad(Ciudades ciudad) {
		this.ciudad = ciudad;
	}
	public PlanComercial getPlan() {
		return plan;
	}
	public void setPlan(PlanComercial plan) {
		this.plan = plan;
	}
	public Integer getProducto_id() {
		return producto_id;
	}
	public void setProducto_id(Integer producto_id) {
		this.producto_id = producto_id;
	}*/
	public Integer getPromo_id() {
		return promo_id;
	}
	public void setPromo_id(Integer promo_id) {
		this.promo_id = promo_id;
	}
	
	
	
}
