package jpa.promociones.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jpa.promociones.DTO.ActividadDTO;
import jpa.promociones.mapper.ActividadMapper;
import jpa.promociones.modelo.ActividadEco;
import jpa.promociones.repository.ActividadEcoRepository;

@Service
public class ServiciosActividadImpl implements ServiciosActividad {
	
	@Autowired
	private ActividadEcoRepository actividadRepo;
	
	/**
	 * getActividades
	 * @return - Lista de las actividades económicas
	 */
	@Override
	public List<ActividadDTO> getActividades() {
		List<ActividadDTO> listaActividadesDTO = ActividadMapper.entityListToDtoList(this.actividadRepo.findAll()); 
		return listaActividadesDTO;
	}
	
	/**
	 * getActividad
	 * @param actividadId
	 * @return - Una actividad económica según su id
	 */
	@Override
	public ActividadDTO getActividad(Integer actividadId) {
		ActividadEco actividad = this.actividadRepo.findById(actividadId).get();
		ActividadDTO actividadDTO = ActividadMapper.toDTO(actividad);
		return actividadDTO;
	}

}
