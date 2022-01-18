package jpa.promociones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import jpa.promociones.modelo.Calificacion;

public interface CalificacionRepository extends JpaRepository<Calificacion, Integer>{
	
	/**
	 * calificacionesPromocion: construcci�n DTO de promoci�n, proporcionando las calificaciones 
	 * 							realicionadas a dicha promoci�n 
	 * @param promoId
	 * @return - Lista de calificaciones asociadas a una promoci�n, seg�n el id de la promoci�n
	 */
	@Transactional
	@Query(value = "SELECT DISTINCT /*+ LEADING(calificacion) INDEX(promo_calificacion, promo_cal) INDEX(calificacion, calificacion) */ calificacion.ID, calificacion.NOMBRE FROM CALIFICACION JOIN PROMO_CALIFICACION ON calificacion.ID = promo_calificacion.CALIFICACION_ID JOIN PROMOCIONES ON PROMO_CALIFICACION.PROMO_ID = promociones.ID WHERE promociones.ID = ?", nativeQuery = true)
	List<Calificacion> calificacionesPromocion(Integer promoId);
	
	/**
	 * getCalificacionId: conformaci�n de la entidad promoci�n que ser� creada o actualizada, 
	 * 					  identificando la relaci�n entre el id de la calificaci�n y la promoci�n 
	 * 					  en cuesti�n, seg�n el nombre de calificaci�n recibida desde el front 
	 * @param nombre
	 * @return - Id de una calificaci�n, seg�n su nombre
	 */
	@Transactional
	@Query(value = "SELECT /*+ ALL_ROWS INDEX(calificacion, nombre_cal) */ id FROM calificacion WHERE nombre = ?", nativeQuery = true)
	Integer getCalificacionId(String nombre);
	
}
