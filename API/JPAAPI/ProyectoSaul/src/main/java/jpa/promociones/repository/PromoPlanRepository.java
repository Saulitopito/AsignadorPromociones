package jpa.promociones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import jpa.promociones.modelo.PromoPlan;

public interface PromoPlanRepository extends JpaRepository<PromoPlan, Integer>{
	
	/**
	 * quitarPlanes: elimina las relaciones entre una promoción y sus panes comeriales asociados, 
	 * 				 según el id de la promoción, con el fin de actualizar dichas relaciones
	 * @param promoId
	 */
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM PromoPlan pp WHERE pp.promo_id = :promoId")
	void quitarPlanes(@Param("promoId") Integer promoId);

}
