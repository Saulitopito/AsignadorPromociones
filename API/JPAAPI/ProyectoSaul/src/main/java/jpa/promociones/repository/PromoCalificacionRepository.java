package jpa.promociones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import jpa.promociones.modelo.PromoCalificacion;

public interface PromoCalificacionRepository extends JpaRepository<PromoCalificacion, Integer>{
	
	/**
	 * quitarCalificaciones: elimina las relaciones entre una promoci�n y sus calificaciones 
	 * 						 asociadas, seg�n el id de la promoci�n, con el fin de actualizar
	 * 						 dichas relaciones
	 * @param promoId
	 */
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM PromoCalificacion pc WHERE pc.promo_id = :promoId")
	void quitarCalificaciones(@Param("promoId") Integer promoId);

}
