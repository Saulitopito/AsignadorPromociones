package jpa.promociones.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jpa.promociones.DTO.PlanDTO;
import jpa.promociones.mapper.PlanMapper;
import jpa.promociones.modelo.PlanComercial;
import jpa.promociones.repository.PlanComercialRepository;

@Service
public class ServiciosPlanImpl implements ServiciosPlan {
	
	@Autowired
	private PlanComercialRepository planRepo;
	
	/**
	 * getPlanes
	 * @return - Lista de planes comerciales
	 */
	@Override
	public List<PlanDTO> getPlanes() {
		List<PlanDTO> listaPlanesDTO = PlanMapper.entityListToDtoList(this.planRepo.findAll()); 
		return listaPlanesDTO;
	}
	
	/**
	 * getPlan
	 * @param planId
	 * @return - Un plan según su id
	 */
	@Override
	public PlanDTO getPlan(Integer planId) {
		PlanComercial plan = this.planRepo.findById(planId).get();
		PlanDTO planDTO = PlanMapper.toDTO(plan);
		return planDTO;
	}

}
