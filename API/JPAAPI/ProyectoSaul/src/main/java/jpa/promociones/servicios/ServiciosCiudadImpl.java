package jpa.promociones.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jpa.promociones.DTO.CiudadDTO;
import jpa.promociones.mapper.CiudadMapper;
import jpa.promociones.modelo.Ciudades;
import jpa.promociones.repository.CiudadesRepository;

@Service
public class ServiciosCiudadImpl implements ServiciosCiudad {
	
	@Autowired
	private CiudadesRepository ciudadRepo;
	
	/**
	 * getCiudades
	 * @return - Lista de las ciudades
	 */
	@Override
	public List<CiudadDTO> getCiudades() {
		List<CiudadDTO> listaCiudadesDTO = CiudadMapper.entityListToDtoList(this.ciudadRepo.ciudadesOrdenadas()); 
		return listaCiudadesDTO;
	}
	
	/**
	 * getCiudad
	 * @param ciudadId
	 * @return - Una ciudad según su id
	 */
	@Override
	public CiudadDTO getCiudad(Integer ciudadId) {
		Ciudades ciudad = this.ciudadRepo.findById(ciudadId).get();
		CiudadDTO ciudadDTO = CiudadMapper.toDTO(ciudad);
		return ciudadDTO;
	}

}
