package jpa.promociones.mapper;

import java.util.ArrayList;
import java.util.List;

import jpa.promociones.DTO.CiudadDTO;
import jpa.promociones.modelo.Ciudades;

public class CiudadMapper {

	public static Ciudades toEntity(CiudadDTO ciudadDTO) {
		
		Ciudades ciudad = new Ciudades();
		
		ciudad.setId(ciudadDTO.getIdDTO());
		ciudad.setNombre(ciudadDTO.getNombreDTO());
				
		return ciudad;
		
	}
	
	public static CiudadDTO toDTO(Ciudades ciudad) {
		
		CiudadDTO ciudadDTO = new CiudadDTO();
		
		ciudadDTO.setIdDTO(ciudad.getId());
		ciudadDTO.setNombreDTO(ciudad.getNombre());
				
		return ciudadDTO;
		
	}
	
	public static List<CiudadDTO> entityListToDtoList(List<Ciudades> listaCiudades){
		
		List<CiudadDTO> listaCiudadesDTO = new ArrayList<>();
		
		for(Ciudades ele : listaCiudades) {
			listaCiudadesDTO.add(CiudadMapper.toDTO(ele));
		}
		
		return listaCiudadesDTO;
	}
	
	public static List<Ciudades> dtoListToEntityList(List<CiudadDTO> listaCiudadesDTO){
		
		List<Ciudades> listaCiudades = new ArrayList<>();
		
		for(CiudadDTO ele : listaCiudadesDTO) {
			listaCiudades.add(CiudadMapper.toEntity(ele));
		}
		
		return listaCiudades;
	}
	
}