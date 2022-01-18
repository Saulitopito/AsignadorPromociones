package jpa.promociones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import jpa.promociones.modelo.PromoCiudad;

public interface PromoCiudadRepository extends JpaRepository<PromoCiudad, Integer>{
	
	/**
	 * quitarCiudades: elimina las relaciones entre una promoci�n y sus ciudades asociadas, 
	 * 				   seg�n el id de la promoci�n, con el fin de actualizar dichas relaciones
	 * @param promoId
	 */
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM PromoCiudad pc WHERE pc.promo_id = :promoId")
	void quitarCiudades(@Param("promoId") Integer promoId);

}
