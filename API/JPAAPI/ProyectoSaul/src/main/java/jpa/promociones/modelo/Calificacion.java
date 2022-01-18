package jpa.promociones.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "calificacion")
public class Calificacion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_calificacion")
	@SequenceGenerator(name = "sec_calificacion", sequenceName = "sec_calificacion", allocationSize = 1, initialValue = 1)
	private Integer id;
	
	private String nombre;
	
	@OneToMany(mappedBy = "calificacion_id")
	private List<Clientes> clientes;
	
	@OneToMany(mappedBy = "calificacion_id")
	private List<PromoCalificacion> promoCalificacion;

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
	
	
	
}
