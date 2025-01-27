package com.MC_ESTRATEGIA_EST_ORG_DEPARTAMENTO.backend.Service;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.MC_ESTRATEGIA_EST_ORG_DEPARTAMENTO.backend.Client.*;
import com.MC_ESTRATEGIA_EST_ORG_DEPARTAMENTO.backend.DTO.BscCuentasDepartamentoPresupuestoDTO;
import com.MC_ESTRATEGIA_EST_ORG_DEPARTAMENTO.backend.DTO.BscObjetivoDTO;
import com.MC_ESTRATEGIA_EST_ORG_DEPARTAMENTO.backend.DTO.BscTipoProyectoDTO;
import com.MC_ESTRATEGIA_EST_ORG_DEPARTAMENTO.backend.DTO.Estrategia_org_departamentoDTO;
import com.MC_ESTRATEGIA_EST_ORG_DEPARTAMENTO.backend.Entity.Estrategia_org_departamentoEntity;
import com.MC_ESTRATEGIA_EST_ORG_DEPARTAMENTO.backend.Repository.Estrategia_org_departamentoRepository;
import com.MC_ESTRATEGIA_EST_ORG_DEPARTAMENTO.backend.Response.BscCuentasDepartamentoPresupuestoResponse;
import com.MC_ESTRATEGIA_EST_ORG_DEPARTAMENTO.backend.Response.BscObjetivoResponse;
import com.MC_ESTRATEGIA_EST_ORG_DEPARTAMENTO.backend.Response.BscTipoProyectoResponse;

@Service
public class Estrategia_org_departamentoServiceImpl implements IEstrategia_org_departamentoService {
	
	@Autowired
	private Estrategia_org_departamentoRepository estrategiaOrgDepartamentoRepository;
	
	
	@Override
	public List<Estrategia_org_departamentoDTO> findAll() {
		List<Estrategia_org_departamentoEntity> entityList = (List<Estrategia_org_departamentoEntity>) estrategiaOrgDepartamentoRepository.findAll();
		List<Estrategia_org_departamentoDTO> dtoList = new ArrayList<>();
		for (Estrategia_org_departamentoEntity entity : entityList) {
			dtoList.add(entity.toDTO());
		}
		return dtoList;
	}
	
	@Override
	public Optional<Estrategia_org_departamentoDTO> findById(Long id) {
		Optional<Estrategia_org_departamentoEntity> entityOpt = estrategiaOrgDepartamentoRepository.findById(id);
		if (entityOpt.isPresent()) {
			return Optional.of(entityOpt.get().toDTO());
		} else {
			return Optional.empty();
		}
	}
	
	@Override
	public Estrategia_org_departamentoDTO save(Estrategia_org_departamentoDTO estrategiaOrgDepartamentoDTO) {
		Estrategia_org_departamentoEntity entity = estrategiaOrgDepartamentoDTO.toEntity();
		entity = estrategiaOrgDepartamentoRepository.save(entity);
		return entity.toDTO();
	}
	
	@Override
	public void delete(Estrategia_org_departamentoDTO dto) {
		Estrategia_org_departamentoEntity entity = dto.toEntity();
		estrategiaOrgDepartamentoRepository.delete(entity);
	}
	
	@Override
	public List<Estrategia_org_departamentoEntity> findSubDepartments(Long org_departamento_id_padre) {
	    return estrategiaOrgDepartamentoRepository.findSubDepartments(org_departamento_id_padre);
	}

//	@Override
//	public BscObjetivoResponse findObjetivosById(Long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public BscTipoProyectoResponse findTipoProyectoById(Long idTipoProyecto) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public BscCuentasDepartamentoPresupuestoResponse findCuentasByDepartamentoId(Long idDepartamento) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
//	@Override
//	public BscObjetivoResponse findObjetivosById(Long idTipoObjetivo) {
//	    // Lógica para obtener el tipo de objetivo usando el cliente
//	    BscObjetivoDTO tipoObjetivo = new BscObjetivoDTO(null, null, null, null, null, null, null, 0, null, null);
//	    
//	    // Verificamos si se encontró el tipo de objetivo
//	    String nombreTipoObjetivo = tipoObjetivo != null ? tipoObjetivo.getNombre() : "Tipo de objetivo no encontrado";
//
//	    // Llamamos al cliente para obtener los objetivos asociados al tipo
//	    List<BscObjetivoDTO> objetivos = BscObjetivoClient.findByTipo(idTipoObjetivo);
//
//	    // Construimos y retornamos la respuesta
//	    return BscObjetivoResponse.builder()
//	            .nombreTipoObjetivo(nombreTipoObjetivo)
//	            .bscObjetivos(objetivos)
//	            .build();
//	}
//
//	@Override
//	public BscTipoProyectoResponse findTipoProyectoById(Long idTipoProyecto) {
//	    // Obtener el tipo de proyecto usando el cliente
//	    BscTipoProyectoDTO tipoProyectoDTO = new BscTipoProyectoDTO(null, null, null, null, 0, null);
//	    
//	    // Lógica para obtener el nombre del tipo de proyecto
//	    String nombreTipoProyecto = (tipoProyectoDTO != null) ? tipoProyectoDTO.getNombre() : "Tipo de proyecto no encontrado";
//
//	    // Obtener la lista de tipos de proyecto si es necesario
//	    List<BscTipoProyectoDTO> tipoProyectos = BscTipoProyectoClient.findAll();
//
//	    // Construir y retornar la respuesta
//	    return BscTipoProyectoResponse.builder()
//	            .nombreTipoProyecto(nombreTipoProyecto)
//	            .bscTipoProyectos(tipoProyectos)
//	            .build();
//	}
//
//	@Override
//	public BscCuentasDepartamentoPresupuestoResponse findCuentasByDepartamentoId(Long idDepartamento) {
//	    // Lógica para obtener el nombre del departamento, si es necesario
//	    String nombreDepartamento = "Nombre del departamento"; // Reemplaza esto con la lógica real para obtener el nombre
//
//	    // Obtener la lista de cuentas asociadas al departamento
//	    List<BscCuentasDepartamentoPresupuestoDTO> cuentas = BscCuentasDepartamentoPresupuestoClient.findAll(); // O usa un método específico para buscar por departamento
//
//	    // Construir y retornar la respuesta
//	    return BscCuentasDepartamentoPresupuestoResponse.builder()
//	            .nombreDepartamento(nombreDepartamento)
//	            .cuentas(cuentas)
//	            .build();
//	}

	

}
