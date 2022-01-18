package jpa.promociones.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "ciudades")
public class Ciudades implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_ciudades")
	@SequenceGenerator(name = "sec_ciudades", sequenceName = "sec_ciudades", allocationSize = 1, initialValue = 1)
	private Integer id;
	
	private String nombre;
	
	@OneToMany(mappedBy = "ciudad_id")
	private List<Clientes> clientes;
	
	@OneToMany(mappedBy = "ciudad_id")
	private List<PromoCiudad> promoCiudad;

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
