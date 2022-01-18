package jpa.promociones.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jpa.promociones.DTO.PromocionDTO;
import jpa.promociones.JDBC.JDBCProcedimiento;
import jpa.promociones.mapper.ActividadMapper;
import jpa.promociones.mapper.CalificacionMapper;
import jpa.promociones.mapper.CiudadMapper;
import jpa.promociones.mapper.PlanMapper;
import jpa.promociones.mapper.PromocionesMapper;
import jpa.promociones.modelo.PromoActividad;
import jpa.promociones.modelo.PromoCalificacion;
import jpa.promociones.modelo.PromoCiudad;
import jpa.promociones.modelo.PromoPlan;
import jpa.promociones.modelo.Promociones;
import jpa.promociones.repository.ActividadEcoRepository;
import jpa.promociones.repository.CalificacionRepository;
import jpa.promociones.repository.CiudadesRepository;
import jpa.promociones.repository.PlanComercialRepository;
import jpa.promociones.repository.PromoActividadRepository;
import jpa.promociones.repository.PromoCalificacionRepository;
import jpa.promociones.repository.PromoCiudadRepository;
import jpa.promociones.repository.PromoPlanRepository;
import jpa.promociones.repository.PromocionesRepository;

@Service
public class ServiciosPromocionesImpl implements ServiciosPromociones{
	
	@Autowired
	private PromocionesRepository promoRepo;
	
	@Autowired
	private ActividadEcoRepository actividadRepo;
	
	@Autowired
	private PlanComercialRepository planRepo;
	
	@Autowired
	private CiudadesRepository ciudadRepo;
	
	@Autowired
	private CalificacionRepository calificacionRepo;
	
	@Autowired
	private PromoActividadRepository promoActRepo;
	
	@Autowired
	private PromoPlanRepository promoPlanRepo;
	
	@Autowired
	private PromoCiudadRepository promoCiudadRepo;
	
	@Autowired
	private PromoCalificacionRepository promoCalRepo;
	
	/**
	 * getPromociones
	 * @return - Lista de promociones
	 */
	@Override
	public List<PromocionDTO> getPromociones() {
		List<Promociones> listaPromociones = this.promoRepo.listarPromociones();
		List<PromocionDTO> listaPromocionesDTO = PromocionesMapper.entityListToDtoList(listaPromociones);
		for(int i=0; i<listaPromociones.size(); i++) {
			listaPromocionesDTO.get(i).setActividadDTO(ActividadMapper.entityListToDtoList(actividadRepo.actividadesPromocion(listaPromociones.get(i).getId())));
			listaPromocionesDTO.get(i).setCiudadDTO(CiudadMapper.entityListToDtoList(ciudadRepo.ciudadesPromocion(listaPromociones.get(i).getId())));
			listaPromocionesDTO.get(i).setPlanDTO(PlanMapper.entityListToDtoList(planRepo.planesPromocion(listaPromociones.get(i).getId())));
			listaPromocionesDTO.get(i).setCalificacionDTO(CalificacionMapper.entityListToDtoList(calificacionRepo.calificacionesPromocion(listaPromociones.get(i).getId())));
		}
		return listaPromocionesDTO;
	}
	
	/**
	 * getPromocion
	 * @param promocionId
	 * @return - Una promoción según su id
	 */
	@Override
	public PromocionDTO getPromocion(Integer promocionId) {
		Promociones promocion = this.promoRepo.findById(promocionId).get();
		PromocionDTO promocionDTO = PromocionesMapper.toDTO(promocion);
		promocionDTO.setActividadDTO(ActividadMapper.entityListToDtoList((actividadRepo.actividadesPromocion(promocionId))));
		promocionDTO.setPlanDTO(PlanMapper.entityListToDtoList((planRepo.planesPromocion(promocionId))));
		promocionDTO.setCiudadDTO(CiudadMapper.entityListToDtoList((ciudadRepo.ciudadesPromocion(promocionId))));
		promocionDTO.setCalificacionDTO(CalificacionMapper.entityListToDtoList((calificacionRepo.calificacionesPromocion(promocionId))));
		return promocionDTO;
	}
	
	/**
	 * crearPromocion: Después de creada la promoción, se agregan las relaciones de dicha 
	 * 				   promoción con las ciudades, planes comerciales, actividades económicas y 
	 * 				   calificaciones, una a una
	 * @param promocionDTO
	 * @return - Una promoción creada en base de datos 
	 */
	@Override
	public PromocionDTO crearPromocion(PromocionDTO promocionDTO) {
		Promociones promocion = PromocionesMapper.toEntity(promocionDTO);
		this.promoRepo.save(promocion);
		Integer idPromo = promoRepo.idPromo();
		for (int i=0; i<promocionDTO.getActividadDTO().size(); i++) {
			PromoActividad promoAct = new PromoActividad();
			promoAct.setPromo_id(idPromo);
			promoAct.setActividad_id(actividadRepo.getActividadId(promocionDTO.getActividadDTO().get(i).getNombreDTO()));
			promoActRepo.save(promoAct);
		}
		for (int i=0; i<promocionDTO.getPlanDTO().size(); i++) {
			PromoPlan promoPlan = new PromoPlan();
			promoPlan.setPromo_id(idPromo);
			promoPlan.setPlan_id(planRepo.getPlanId(promocionDTO.getPlanDTO().get(i).getNombreDTO()));
			promoPlanRepo.save(promoPlan);
		}
		for (int i=0; i<promocionDTO.getCiudadDTO().size(); i++) {
			PromoCiudad promoCiudad = new PromoCiudad();
			promoCiudad.setPromo_id(idPromo);
			promoCiudad.setCiudad_id(ciudadRepo.getCiudadId(promocionDTO.getCiudadDTO().get(i).getNombreDTO()));
			promoCiudadRepo.save(promoCiudad);
		}
		for (int i=0; i<promocionDTO.getCalificacionDTO().size(); i++) {
			PromoCalificacion promoCal = new PromoCalificacion();
			promoCal.setPromo_id(idPromo);
			promoCal.setCalificacion_id(calificacionRepo.getCalificacionId(promocionDTO.getCalificacionDTO().get(i).getNombreDTO()));
			promoCalRepo.save(promoCal);
		}
		return PromocionesMapper.toDTO(this.promoRepo.save(promocion));
	}
	
	/**
	 * actualizarPromocion: Acá se eliminan las relaciones anteriores y se agregan las nuevas 
	 * 						relaciones de dicha promoción con las ciudades, planes comerciales, 
	 * 						actividades económicas y calificaciones, una a una
	 * @param id, promocionDTO
	 * @return - Una promoción actualizada identificada con el id recibido, haciendo uso de la 
	 * 			 promoción DTO que viene del front como cuerpo
	 */
	@Override
	public PromocionDTO actualizarPromocion(Integer id, PromocionDTO promocionDTO) {
		promocionDTO.setIdDTO(id);
		Promociones promocion = PromocionesMapper.toEntity(promocionDTO);
		promoActRepo.quitarActividades(id);
		for (int i=0; i<promocionDTO.getActividadDTO().size(); i++) {
			PromoActividad promoAct = new PromoActividad();
			promoAct.setPromo_id(id);
			promoAct.setActividad_id(actividadRepo.getActividadId(promocionDTO.getActividadDTO().get(i).getNombreDTO()));
			promoActRepo.save(promoAct);
		}
		promoPlanRepo.quitarPlanes(id);
		for (int i=0; i<promocionDTO.getPlanDTO().size(); i++) {
			PromoPlan promoPlan = new PromoPlan();
			promoPlan.setPromo_id(id);
			promoPlan.setPlan_id(planRepo.getPlanId(promocionDTO.getPlanDTO().get(i).getNombreDTO()));
			promoPlanRepo.save(promoPlan);
		}
		promoCiudadRepo.quitarCiudades(id);
		for (int i=0; i<promocionDTO.getCiudadDTO().size(); i++) {
			PromoCiudad promoCiudad = new PromoCiudad();
			promoCiudad.setPromo_id(id);
			promoCiudad.setCiudad_id(ciudadRepo.getCiudadId(promocionDTO.getCiudadDTO().get(i).getNombreDTO()));
			promoCiudadRepo.save(promoCiudad);
		}
		promoCalRepo.quitarCalificaciones(id);
		for (int i=0; i<promocionDTO.getCalificacionDTO().size(); i++) {
			PromoCalificacion promoCal = new PromoCalificacion();
			promoCal.setPromo_id(id);
			promoCal.setCalificacion_id(calificacionRepo.getCalificacionId(promocionDTO.getCalificacionDTO().get(i).getNombreDTO()));
			promoCalRepo.save(promoCal);
		}
		return PromocionesMapper.toDTO(this.promoRepo.save(promocion));
	}
	
	/**
	 * inhabilitarPromocion: cambia el etado de una promoción de activo (1) a inhabilitado(0)
	 * @param id
	 * @return - Una promoción actualizada
	 */
	@Override
	public void inhabilitarPromocion(Integer id) {
		this.promoRepo.inhabilitarPromocion(id);
	}
	
	/**
	 * asignarPromociones: Método que realiza la asignación de promociones, según procidimiento 
	 * 					   definido en PL/SQL en la base de datos
	 */
	@Override
	public void asignarPromociones() {
		JDBCProcedimiento.asignarPromociones();
	}
	
	/**
	 * quitarPromociones: Método que quita las promociones asignadas a todos los clientes
	 */
	@Override
	public void quitarPromociones() {
		JDBCProcedimiento.quitarPromociones();
	}

}
