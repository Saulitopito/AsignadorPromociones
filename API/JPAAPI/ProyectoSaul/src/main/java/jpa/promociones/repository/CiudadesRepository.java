package jpa.promociones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import jpa.promociones.modelo.Ciudades;

public interface CiudadesRepository extends JpaRepository<Ciudades, Integer>{
	
	/**
	 * ciudadesPromocion: Permite la construcción del DTO de promoción, indicándo las ciudades 
	 * 					  relacionadas con dicha promoción 
	 * @param promoId
	 * @return - Lista de ciudades asociadas a una promoción, según el id de la promoción
	 */
	@Transactional
	@Query(value = "SELECT DISTINCT /*+ LEADING(ciudades) INDEX(promo_ciudad, promo_ciudad) INDEX(ciudades, ciudad) */ ciudades.ID, ciudades.NOMBRE FROM CIUDADES JOIN PROMO_CIUDAD ON ciudades.ID = promo_ciudad.CIUDAD_ID JOIN PROMOCIONES ON PROMO_CIUDAD.PROMO_ID = promociones.ID WHERE promociones.ID = ?", nativeQuery = true)
	List<Ciudades> ciudadesPromocion(Integer promoId);
	
	/**
	 * ciudadesOrdenadas: obtiene el listado en orden alfabético para ser mostrado en el front en
	 * 					  los formularios de selección de ciudad, para facilitar su ubicación 
	 * @return - Lista de las ciudades ordenadas en orden alfabético
	 */
	@Transactional
	@Query(value = "SELECT /*+ ALL_ROWS INDEX(ciudades, ciudad) */ DISTINCT id, nombre FROM CIUDADES ORDER BY NOMBRE", nativeQuery = true)
	List<Ciudades> ciudadesOrdenadas();
	
	/**
	 * getCiudadId: conformación de la entidad promoción que será creada o actualizada en BD, 
	 * 				permitiendo identificar la relación entre el id de la ciudad y la promoción 
	 * 				en cuestión, según la información recibida desde el front 
	 * @param nombre
	 * @return - Id de una ciudad, según su nombre
	 */
	@Transactional
	@Query(value = "SELECT /*+ ALL_ROWS INDEX(ciudades, nombre_ciud) */ id FROM ciudades WHERE nombre = ?", nativeQuery = true)
	Integer getCiudadId(String nombre);
	
}
