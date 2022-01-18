package jpa.promociones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import jpa.promociones.modelo.Calificacion;

public interface CalificacionRepository extends JpaRepository<Calificacion, Integer>{
	
	/**
	 * calificacionesPromocion: construcción DTO de promoción, proporcionando las calificaciones 
	 * 							realicionadas a dicha promoción 
	 * @param promoId
	 * @return - Lista de calificaciones asociadas a una promoción, según el id de la promoción
	 */
	@Transactional
	@Query(value = "SELECT DISTINCT /*+ LEADING(calificacion) INDEX(promo_calificacion, promo_cal) INDEX(calificacion, calificacion) */ calificacion.ID, calificacion.NOMBRE FROM CALIFICACION JOIN PROMO_CALIFICACION ON calificacion.ID = promo_calificacion.CALIFICACION_ID JOIN PROMOCIONES ON PROMO_CALIFICACION.PROMO_ID = promociones.ID WHERE promociones.ID = ?", nativeQuery = true)
	List<Calificacion> calificacionesPromocion(Integer promoId);
	
	/**
	 * getCalificacionId: conformación de la entidad promoción que será creada o actualizada, 
	 * 					  identificando la relación entre el id de la calificación y la promoción 
	 * 					  en cuestión, según el nombre de calificación recibida desde el front 
	 * @param nombre
	 * @return - Id de una calificación, según su nombre
	 */
	@Transactional
	@Query(value = "SELECT /*+ ALL_ROWS INDEX(calificacion, nombre_cal) */ id FROM calificacion WHERE nombre = ?", nativeQuery = true)
	Integer getCalificacionId(String nombre);
	
}
