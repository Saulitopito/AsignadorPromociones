package jpa.promociones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import jpa.promociones.modelo.Promociones;

public interface PromocionesRepository extends JpaRepository<Promociones, Integer>{
	
	/**
	 * idPromo: permite la asignación de ciudades, actividades económicas, planes comerciales y 
	 * 			calificaciones a la última promoción creada 
	 * @return - Id de la última promoción creada
	 */
	@Transactional
	@Query(value = "SELECT /*+ ROW_ID(promociones) */ ID FROM PROMOCIONES ORDER BY ID DESC FETCH FIRST 1 ROWS ONLY", nativeQuery = true)
	Integer idPromo();
	
	/**
	 * listarPromociones: lista y permite mostrar las promociones en la App
	 * @return - Lista de promociones existentes en BD, ordenadas según su id
	 */
	@Transactional
	@Query(value = "SELECT /*+ INDEX(promociones, estado) */ * FROM PROMOCIONES WHERE estado = 1 ORDER BY ID", nativeQuery = true)
	List<Promociones> listarPromociones();
	
	/**
	 * inhabilitarPromocion: inhabilita una promoción, según su id, pasando su estado de 
	 * 						 activa (1) a inactiva (0), y registra la fecha y hora en la que se
	 * 						 hizo el cambio
	 * @param promoId
	 */
	@Transactional
	@Modifying
	@Query(value = "UPDATE PROMOCIONES SET estado = 0, fecha_inactiva = (SELECT CURRENT_TIMESTAMP FROM DUAL) WHERE id = ?", nativeQuery = true)
	void inhabilitarPromocion(Integer promoId);
	
}
