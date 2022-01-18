package jpa.promociones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import jpa.promociones.modelo.PromoActividad;

public interface PromoActividadRepository extends JpaRepository<PromoActividad, Integer> {
	
	/**
	 * quitarActividades: elimina todas las relaciones existentes entre una promoción y las 
	 * 					  actividades comerciales asociadas a esta, según el id de la promoción,
	 * 					  con el fin de actualizar dichas relaciones
	 * @param promoId
	 */
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM PromoActividad pa WHERE pa.promo_id = :promoId")
	void quitarActividades(@Param("promoId") Integer promoId);

}
