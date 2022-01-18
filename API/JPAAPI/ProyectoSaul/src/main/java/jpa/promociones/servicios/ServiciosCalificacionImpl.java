package jpa.promociones.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jpa.promociones.DTO.CalificacionDTO;
import jpa.promociones.mapper.CalificacionMapper;
import jpa.promociones.modelo.Calificacion;
import jpa.promociones.repository.CalificacionRepository;

@Service
public class ServiciosCalificacionImpl implements ServiciosCalificacion {
	
	@Autowired
	private CalificacionRepository calificaRepo;
	
	/**
	 * getCalificaciones
	 * @return - Lista de las calificaciones
	 */
	@Override
	public List<CalificacionDTO> getCalificaciones() {
		List<CalificacionDTO> listaCalificacionesDTO = CalificacionMapper.entityListToDtoList(this.calificaRepo.findAll()); 
		return listaCalificacionesDTO;
	}
	
	/**
	 * getCalificacion
	 * @param calificacionId
	 * @return - Una calificación según su id
	 */
	@Override
	public CalificacionDTO getCalificacion(Integer calificacionId) {
		Calificacion calificacion = this.calificaRepo.findById(calificacionId).get();
		CalificacionDTO calificacionDTO = CalificacionMapper.toDTO(calificacion);
		return calificacionDTO;
	}

}
