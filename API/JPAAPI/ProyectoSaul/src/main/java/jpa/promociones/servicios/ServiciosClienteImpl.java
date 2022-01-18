package jpa.promociones.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jpa.promociones.DTO.ClientePromoDTO;
import jpa.promociones.mapper.ActividadMapper;
import jpa.promociones.mapper.CiudadMapper;
import jpa.promociones.mapper.ClientePromoMapper;
import jpa.promociones.mapper.PromocionesMapper;
import jpa.promociones.modelo.Clientes;
import jpa.promociones.repository.ActividadEcoRepository;
import jpa.promociones.repository.CiudadesRepository;
import jpa.promociones.repository.ClientesRepository;
import jpa.promociones.repository.ProdClienteRepository;
import jpa.promociones.repository.ProductosRepository;
import jpa.promociones.repository.PromocionesRepository;

@Service
public class ServiciosClienteImpl implements ServiciosCliente {
	
	@Autowired
	private ClientesRepository clientesRepo;
	
	@Autowired
	private ActividadEcoRepository actividadRepo;
		
	@Autowired
	private CiudadesRepository ciudadRepo;
		
	@Autowired
	private PromocionesRepository promoRepo;
	
	@Autowired
	private ProdClienteRepository prodClienteRepo;
	
	@Autowired
	private ProductosRepository prodRepo;
	
	/**
	 * getClientesPromo
	 * @param promoId
	 * @return - Lista de los clientes asociados a una promoción en particular, según el id de 
	 * 			 la promoción
	 */
	@Override
	public List<ClientePromoDTO> getClientesPromo(){
		List<Clientes> clientes = clientesRepo.clientesXPromo();
		List<ClientePromoDTO> clientesPromo = ClientePromoMapper.entityListToDtoList(clientes);
		for (int i=0; i<clientesPromo.size(); i++) {
			clientesPromo.get(i).setNombrePromoDTO(promoRepo.findById(clientes.get(i).getPromo_id()).get().getNombre());
			clientesPromo.get(i).setActividadDTO(ActividadMapper.toDTO(actividadRepo.findById(clientes.get(i).getActividad_id()).get()));
			clientesPromo.get(i).setCiudadDTO(CiudadMapper.toDTO(ciudadRepo.findById(clientes.get(i).getCiudad_id()).get()));
			clientesPromo.get(i).setPorcentajeDTO(PromocionesMapper.toDTO(promoRepo.findById(clientes.get(i).getPromo_id()).get()).getDescuentoDTO());
			clientesPromo.get(i).setValorDTO(prodRepo.findById(prodClienteRepo.productoCliente(clientes.get(i).getId()).getProducto_id()).get().getValor());
			clientesPromo.get(i).setValorRealDTO(prodClienteRepo.productoCliente(clientes.get(i).getId()).getValor_ajustado());
		}
		return clientesPromo;
	}

}
