package jpa.promociones.mapper;

import java.util.ArrayList;
import java.util.List;

import jpa.promociones.DTO.ClientePromoDTO;
import jpa.promociones.modelo.Clientes;

public class ClientePromoMapper {
	
	public static ClientePromoDTO toDTO(Clientes cliente) {
		
		ClientePromoDTO clientePromoDTO = new ClientePromoDTO();
		
		clientePromoDTO.setNombreDTO(cliente.getNombre());
				
		return clientePromoDTO;
	}
	
	public static List<ClientePromoDTO> entityListToDtoList(List<Clientes> listaClientes){
		
		List<ClientePromoDTO> listaClientesPromoDTO = new ArrayList<>();
		
		for(Clientes ele : listaClientes) {
			listaClientesPromoDTO.add(ClientePromoMapper.toDTO(ele));
		}
		
		return listaClientesPromoDTO;
	}

}
