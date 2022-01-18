package jpa.promociones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import jpa.promociones.modelo.ActividadEco;

public interface ActividadEcoRepository extends JpaRepository<ActividadEco, Integer>{
	
	/**
	 * actividadesPromocion: conformación del DTO de promoción, pasando sus actividades económicas
	 * 					 	 relacionadas  
	 * @param promoId
	 * @return - Todas las actividades económicas asociadas a una promoción, según el id de la
	 * 			 promoción
	 */
	@Transactional
	@Query(value = "SELECT /*+ LEADING(actividad_eco) INDEX(promo_actividad, promo_act) INDEX(actividad_eco, actividad) */ DISTINCT actividad_eco.ID, actividad_eco.NOMBRE, actividad_eco.NUM_MAX FROM ACTIVIDAD_ECO JOIN PROMO_ACTIVIDAD ON actividad_eco.ID = promo_actividad.ACTIVIDAD_ID JOIN PROMOCIONES ON PROMO_ACTIVIDAD.PROMO_ID = promociones.ID WHERE promociones.ID = ?", nativeQuery = true)
	List<ActividadEco> actividadesPromocion(Integer promoId);
	
	/**
	 * getActividadId: conformación de la entidad promoción que será creada o actualizada en BD, 
	 * 				   permitiendo conectar dicha promoción con el id de la actividad a la que 
	 * 				   corresponde el nombre recibido desde el front
	 * @param nombre
	 * @return - Id de una actividad económica, según su nombre
	 */
	@Transactional
	@Query(value = "SELECT /*+ ALL_ROWS INDEX(actividad_eco, nombre_act) */ id FROM actividad_eco WHERE nombre = ?", nativeQuery = true)
	Integer getActividadId(String nombre);
}
