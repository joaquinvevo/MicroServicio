package com.MC_ESTRATEGIA_EST_ORG_DEPARTAMENTO.backend.Service;

import java.util.List;
import java.util.Optional;

import com.MC_ESTRATEGIA_EST_ORG_DEPARTAMENTO.backend.DTO.Estrategia_org_departamentoDTO;
import com.MC_ESTRATEGIA_EST_ORG_DEPARTAMENTO.backend.Entity.Estrategia_org_departamentoEntity;
import com.MC_ESTRATEGIA_EST_ORG_DEPARTAMENTO.backend.Response.BscCuentasDepartamentoPresupuestoResponse;
import com.MC_ESTRATEGIA_EST_ORG_DEPARTAMENTO.backend.Response.BscObjetivoResponse;
import com.MC_ESTRATEGIA_EST_ORG_DEPARTAMENTO.backend.Response.BscTipoProyectoResponse;



public interface IEstrategia_org_departamentoService {
	
	public List<Estrategia_org_departamentoDTO> findAll();
	
	public Optional<Estrategia_org_departamentoDTO> findById(Long long1);
	
	public Estrategia_org_departamentoDTO save(Estrategia_org_departamentoDTO estrategiaorg_departamento);
	
	public void delete(Estrategia_org_departamentoDTO dto);
	
	public List<Estrategia_org_departamentoEntity> findSubDepartments(Long org_departamento_id_padre);
	
	

//	public BscObjetivoResponse findObjetivosById(Long id);
//
//	public BscTipoProyectoResponse findTipoProyectoById(Long idTipoProyecto);
//
//	public BscCuentasDepartamentoPresupuestoResponse findCuentasByDepartamentoId(Long idDepartamento);
//

	}
