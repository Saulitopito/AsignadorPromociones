package jpa.promociones.mapper;

import java.util.List;
import java.util.Optional;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import jpa.promociones.DTO.ClienteDTO;
import jpa.promociones.modelo.Clientes;

//@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClienteMapperNOTUSED {
	
	//ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);
	
	/*@Mappings({
		@Mapping(source = "id", target = "idDTO"),
		@Mapping(source = "nombre", target = "nombreDTO"),
		@Mapping(source = "direccion", target = "direccionDTO"),
		@Mapping(source = "telefono", target = "telefonoDTO"),
		@Mapping(source = "mora", target = "moraDTO"),
		@Mapping(source = "promedio", target = "promedioDTO"),
		@Mapping(source = "ciudad", target = "ciudadDTO"),
		@Mapping(source = "plan", target = "planDTO"),
		@Mapping(source = "actividad", target = "actividadDTO"),
		@Mapping(source = "calificacion", target = "calificacionDTO"),
		@Mapping(source = "promocion", target = "promocionDTO")
	})
	ClienteDTO toClienteDTO(Optional<Clientes> optional);*/
	
	/*@Mappings({
		@Mapping(source = "idDTO", target = "id"),
		@Mapping(source = "nombreDTO", target = "nombre"),
		@Mapping(source = "direccionDTO", target = "direccion"),
		@Mapping(source = "telefonoDTO", target = "telefono"),
		@Mapping(source = "moraDTO", target = "mora"),
		@Mapping(source = "promedioDTO", target = "promedio"),
		@Mapping(source = "ciudadDTO", target = "ciudad"),
		@Mapping(source = "planDTO", target = "plan"),
		@Mapping(source = "actividadDTO", target = "actividad"),
		@Mapping(source = "calificacionDTO", target = "calificacion"),
		@Mapping(source = "promocionDTO", target = "promocion")
	})
	Clientes toEntity(ClienteDTO clienteDTO);*/
	
	List<ClienteDTO> entityListToDtoList(List<Clientes> listaClientes);
	
	List<Clientes> dtoListToEntityList(List<ClienteDTO> listaClienteDTO);

}
