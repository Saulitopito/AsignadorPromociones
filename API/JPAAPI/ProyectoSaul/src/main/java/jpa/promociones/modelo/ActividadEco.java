package jpa.promociones.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "actividad_eco")
public class ActividadEco implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_actividad")
	@SequenceGenerator(name = "sec_actividad", sequenceName = "sec_actividad", allocationSize = 1, initialValue = 1)
	private Integer id;
	
	private String nombre;
	private Integer num_max;
	
	@OneToMany(mappedBy = "actividad_id")
	private List<Clientes> clientes;
	
	@OneToMany(mappedBy = "actividad_id")
	private List<PromoActividad> promoActividad;

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

	public Integer getNum_max() {
		return num_max;
	}

	public void setNum_max(Integer num_max) {
		this.num_max = num_max;
	}
	
	
	
}
