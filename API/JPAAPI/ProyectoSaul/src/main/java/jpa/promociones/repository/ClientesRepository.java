package jpa.promociones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import jpa.promociones.modelo.Clientes;

public interface ClientesRepository extends JpaRepository<Clientes, Integer>{
	
	/**
	 * clientesXPromo: identifica y muestra los clientes que cuentan con una promoción asignada
	 * @param promoId
	 * @return - Lista de los clientes que cuentan con una promoción asignada, según el id de la 
	 * 			 promoción en cuestión
	 */
	@Transactional
	@Query(value = "SELECT cl FROM Clientes cl JOIN Promociones pr ON cl.promo_id = pr.id ORDER BY pr.id ASC")
	List<Clientes> clientesXPromo();

}
