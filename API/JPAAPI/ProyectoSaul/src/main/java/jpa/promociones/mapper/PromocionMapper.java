package jpa.promociones.mapper;

import java.util.List;

import org.mapstruct.*;

import jpa.promociones.DTO.PromocionDTO;
import jpa.promociones.modelo.Promociones;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PromocionMapper {
	
	@Mappings({
		@Mapping(source = "id", target = "idDTO"),
		@Mapping(source = "nombre", target = "nombreDTO"),
		@Mapping(source = "fecha_inicio", target = "fecha_inicioDTO"),
		@Mapping(source = "fecha_fin", target = "fecha_finDTO"),
		@Mapping(source = "descuento", target = "descuentoDTO"),
		@Mapping(source = "min_val", target = "min_valDTO"),
		@Mapping(source = "actividad", target = "actividadDTO"),
		@Mapping(source = "plan", target = "planDTO"),
		@Mapping(source = "calificacion", target = "calificacionDTO"),
		@Mapping(source = "ciudad", target = "ciudadDTO")
	})
	PromocionDTO toPromocionDTO(Promociones promocion);
	
	@Mappings({
		@Mapping(source = "idDTO", target = "id"),
		@Mapping(source = "nombreDTO", target = "nombre"),
		@Mapping(source = "fecha_inicioDTO", target = "fecha_inicio"),
		@Mapping(source = "fecha_finDTO", target = "fecha_fin"),
		@Mapping(source = "descuentoDTO", target = "descuento"),
		@Mapping(source = "min_valDTO", target = "min_val"),
		@Mapping(source = "actividadDTO", target = "actividad"),
		@Mapping(source = "planDTO", target = "plan"),
		@Mapping(source = "calificacionDTO", target = "calificacion"),
		@Mapping(source = "ciudadDTO", target = "ciudad")
	})
	Promociones toEntity(PromocionDTO promocionDTO);
	
	List<PromocionDTO> entityListToDtoList(List<Promociones> listaPromociones);
	
	List<Promociones> dtoListToEntityList(List<PromocionDTO> listaPromocionDTO);
	
}