package jpa.promociones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import jpa.promociones.modelo.PlanComercial;

public interface PlanComercialRepository extends JpaRepository<PlanComercial, Integer>{

	/**
	 * planesPromocion: conformación del DTO promoción, indicándo cuáles son los planes 
	 * 					comerciales asociados a dicha promoción
	 * @param promoId
	 * @return - Lista de planes comerciales asociados a una promoción, según el id de la promoción
	 */
	@Transactional
	@Query(value = "SELECT /*+ LEADING(plan_comercial) INDEX(promo_plan, promo_plan) INDEX(plan_comercial, plan) */ DISTINCT plan_comercial.ID, plan_comercial.NOMBRE FROM PLAN_COMERCIAL JOIN PROMO_PLAN ON plan_comercial.ID = promo_plan.PLAN_ID JOIN PROMOCIONES ON PROMO_PLAN.PROMO_ID = promociones.ID WHERE promociones.ID = ?", nativeQuery = true)
	List<PlanComercial> planesPromocion(Integer promoId);
	
	/**
	 * getPlan: conformación de la entidad promoción que será creada o actualizada, permitiendo 
	 * 			identificar la relación del id del plan comercial con la promoción en cuestión 
	 * 			obtenida desde el front
	 * @param nombre
	 * @return - Id de un plan comercial, según su nombre
	 */
	@Transactional
	@Query(value = "SELECT /*+ ALL_ROWS INDEX(plan_comercial, nombre_plan) */ id FROM plan_comercial WHERE nombre = ?", nativeQuery = true)
	Integer getPlanId(String nombre);
	
}
