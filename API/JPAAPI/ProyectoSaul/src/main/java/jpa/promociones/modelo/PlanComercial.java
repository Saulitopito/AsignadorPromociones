package jpa.promociones.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "plan_comercial")
public class PlanComercial implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_plan")
	@SequenceGenerator(name = "sec_plan", sequenceName = "sec_plan", allocationSize = 1, initialValue = 1)
	private Integer id;
	
	private String nombre;
	
	@OneToMany(mappedBy = "plan_id")
	private List<Clientes> clientes;
	
	@OneToMany(mappedBy = "plan_id")
	private List<PromoPlan> promoPlan;

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
