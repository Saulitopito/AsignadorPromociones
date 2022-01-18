package jpa.promociones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import jpa.promociones.modelo.PlanComercial;

public interface PlanComercialRepository extends JpaRepository<PlanComercial, Integer>{

	/**
	 * planesPromocion: conformaci�n del DTO promoci�n, indic�ndo cu�les son los planes 
	 * 					comerciales asociados a dicha promoci�n
	 * @param promoId
	 * @return - Lista de planes comerciales asociados a una promoci�n, seg�n el id de la promoci�n
	 */
	@Transactional
	@Query(value = "SELECT /*+ LEADING(plan_comercial) INDEX(promo_plan, promo_plan) INDEX(plan_comercial, plan) */ DISTINCT plan_comercial.ID, plan_comercial.NOMBRE FROM PLAN_COMERCIAL JOIN PROMO_PLAN ON plan_comercial.ID = promo_plan.PLAN_ID JOIN PROMOCIONES ON PROMO_PLAN.PROMO_ID = promociones.ID WHERE promociones.ID = ?", nativeQuery = true)
	List<PlanComercial> planesPromocion(Integer promoId);
	
	/**
	 * getPlan: conformaci�n de la entidad promoci�n que ser� creada o actualizada, permitiendo 
	 * 			identificar la relaci�n del id del plan comercial con la promoci�n en cuesti�n 
	 * 			obtenida desde el front
	 * @param nombre
	 * @return - Id de un plan comercial, seg�n su nombre
	 */
	@Transactional
	@Query(value = "SELECT /*+ ALL_ROWS INDEX(plan_comercial, nombre_plan) */ id FROM plan_comercial WHERE nombre = ?", nativeQuery = true)
	Integer getPlanId(String nombre);
	
}
