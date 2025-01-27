package com.microservice.bff.service;

import java.util.List;
import java.util.Optional;

import com.microservice.bff.DTO.ProyectoDTOEstrategia_org_cargo;

public interface IBffServiceEstrategia_org_cargo {
	
	   List<ProyectoDTOEstrategia_org_cargo> FindAll();
	   Optional<ProyectoDTOEstrategia_org_cargo> FindById(Long id);
	   void Save(ProyectoDTOEstrategia_org_cargo proyectoDTO);
	   void DeleteById(Long id);
	   ProyectoDTOEstrategia_org_cargo updateProyecto(Long id, ProyectoDTOEstrategia_org_cargo proyectoDetails);
	   //cargoPersonaByIdEstOrgcargoId findAllPersonasByIdEstOrgCargo(Long EstOrgcargoId);
}
