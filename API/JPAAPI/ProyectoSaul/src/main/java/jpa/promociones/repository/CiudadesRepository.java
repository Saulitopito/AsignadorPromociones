package jpa.promociones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import jpa.promociones.modelo.Ciudades;

public interface CiudadesRepository extends JpaRepository<Ciudades, Integer>{
	
	/**
	 * ciudadesPromocion: Permite la construcci�n del DTO de promoci�n, indic�ndo las ciudades 
	 * 					  relacionadas con dicha promoci�n 
	 * @param promoId
	 * @return - Lista de ciudades asociadas a una promoci�n, seg�n el id de la promoci�n
	 */
	@Transactional
	@Query(value = "SELECT DISTINCT /*+ LEADING(ciudades) INDEX(promo_ciudad, promo_ciudad) INDEX(ciudades, ciudad) */ ciudades.ID, ciudades.NOMBRE FROM CIUDADES JOIN PROMO_CIUDAD ON ciudades.ID = promo_ciudad.CIUDAD_ID JOIN PROMOCIONES ON PROMO_CIUDAD.PROMO_ID = promociones.ID WHERE promociones.ID = ?", nativeQuery = true)
	List<Ciudades> ciudadesPromocion(Integer promoId);
	
	/**
	 * ciudadesOrdenadas: obtiene el listado en orden alfab�tico para ser mostrado en el front en
	 * 					  los formularios de selecci�n de ciudad, para facilitar su ubicaci�n 
	 * @return - Lista de las ciudades ordenadas en orden alfab�tico
	 */
	@Transactional
	@Query(value = "SELECT /*+ ALL_ROWS INDEX(ciudades, ciudad) */ DISTINCT id, nombre FROM CIUDADES ORDER BY NOMBRE", nativeQuery = true)
	List<Ciudades> ciudadesOrdenadas();
	
	/**
	 * getCiudadId: conformaci�n de la entidad promoci�n que ser� creada o actualizada en BD, 
	 * 				permitiendo identificar la relaci�n entre el id de la ciudad y la promoci�n 
	 * 				en cuesti�n, seg�n la informaci�n recibida desde el front 
	 * @param nombre
	 * @return - Id de una ciudad, seg�n su nombre
	 */
	@Transactional
	@Query(value = "SELECT /*+ ALL_ROWS INDEX(ciudades, nombre_ciud) */ id FROM ciudades WHERE nombre = ?", nativeQuery = true)
	Integer getCiudadId(String nombre);
	
}
