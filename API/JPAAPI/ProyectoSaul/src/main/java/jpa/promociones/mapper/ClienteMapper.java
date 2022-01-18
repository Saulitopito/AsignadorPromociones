package jpa.promociones.mapper;

import java.util.ArrayList;
import java.util.List;

import jpa.promociones.DTO.ClienteDTONOTUSED;
import jpa.promociones.modelo.Clientes;

public class ClienteMapper {
	
	public static Clientes toEntity(ClienteDTONOTUSED clienteDTO) {
		
		Clientes cliente = new Clientes();
		
		cliente.setId(clienteDTO.getIdDTO());
		cliente.setNombre(clienteDTO.getNombreDTO());
		cliente.setDireccion(clienteDTO.getDireccionDTO());
		cliente.setTelefono(clienteDTO.getTelefonoDTO());
		if (clienteDTO.getMoraDTO()=="Sí") {
			cliente.setMora(1);
		}
		else {
			cliente.setMora(0);
		}
		cliente.setPromedio(clienteDTO.getPromedioDTO());
		cliente.setCiudad_id(clienteDTO.getCiudadDTO().getIdDTO());
		cliente.setPlan_id(clienteDTO.getPlanDTO().getIdDTO());
		cliente.setActividad_id(clienteDTO.getActividadDTO().getIdDTO());
		cliente.setCalificacion_id(clienteDTO.getCalificacionDTO().getIdDTO());
		cliente.setPromo_id(clienteDTO.getPromoDTO().getIdDTO());

		return cliente;
	}
	
	public static ClienteDTONOTUSED toDTO(Clientes cliente) {
		
		ClienteDTONOTUSED clienteDTO = new ClienteDTONOTUSED();
		
		clienteDTO.setIdDTO(cliente.getId());
		clienteDTO.setNombreDTO(cliente.getNombre());
		clienteDTO.setDireccionDTO(cliente.getDireccion());
		clienteDTO.setTelefonoDTO(cliente.getTelefono());
		if (cliente.getMora()==1) {
			clienteDTO.setMoraDTO("Sí");
		}
		else {
			clienteDTO.setMoraDTO("No");
		}
		clienteDTO.setPromedioDTO(cliente.getPromedio());
		/*clienteDTO.setCiudadDTO(CiudadMapper.toDTO(ciudadRepo.findById(cliente.getCiudad_id()).get()));
		clienteDTO.setPlanDTO(PlanMapper.toDTO(planRepo.findById(cliente.getPlan_id()).get()));
		clienteDTO.setActividadDTO(ActividadMapper.toDTO(actividadRepo.findById(cliente.getActividad_id()).get()));
		clienteDTO.setCalificacionDTO(CalificacionMapper.toDTO(calificacionRepo.findById(cliente.getCalificacion_id()).get()));*/

		return clienteDTO;
	}
	
	public static List<ClienteDTONOTUSED> entityListToDtoList(List<Clientes> listaClientes){
		
		List<ClienteDTONOTUSED> listaClientesDTO = new ArrayList<>();
		
		for(Clientes ele : listaClientes) {
			listaClientesDTO.add(ClienteMapper.toDTO(ele));
		}
		
		return listaClientesDTO;
	}
	
	public static List<Clientes> dtoListToEntityList(List<ClienteDTONOTUSED> listaClienteDTO){
		
		List<Clientes> listaClientes = new ArrayList<>();
		
		for(ClienteDTONOTUSED ele : listaClienteDTO) {
			listaClientes.add(ClienteMapper.toEntity(ele));
		}
		
		return listaClientes;
	}

}
