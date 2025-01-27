package com.microservice.bff.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.bff.Client.ProyectoClientEstrategia_org_cargo;
import com.microservice.bff.DTO.ProyectoDTOEstrategia_org_cargo;

@Service
public class BffServiceEstrategia_org_cargoImpl implements IBffServiceEstrategia_org_cargo{
	
	@Autowired
	private ProyectoClientEstrategia_org_cargo proyectoClient;
	
	@Override
	public List<ProyectoDTOEstrategia_org_cargo> FindAll() {
	    try {
	        return proyectoClient.findAll();
	    } catch (Exception e) {
	        // Manejo del error, por ejemplo, logueando el error
	        throw new RuntimeException("Error al obtener proyectos: " + e.getMessage());
	    }
	}


	@Override
	public Optional<ProyectoDTOEstrategia_org_cargo> FindById(Long id) {
		return proyectoClient.findById(id);
	}

	@Override
	public void Save(ProyectoDTOEstrategia_org_cargo proyectoDTO) {
		proyectoClient.save(proyectoDTO);
	}

	@Override
	public void DeleteById(Long id) {
		proyectoClient.deleteById(id);
	}

	@Override
	public ProyectoDTOEstrategia_org_cargo updateProyecto(Long id, ProyectoDTOEstrategia_org_cargo proyectoDetails) {
		proyectoClient.updateProyecto(id, proyectoDetails);
		return null;
	}

//	@Override
//	public situacionByIdEstSubmodeloId findAllSituacionesByIdEstSubModelo(Long idTipoCargoPersona) {
//		Estrategia_org_cargoEntity tipoCargoPersona = tipoCargoPersonaRepository.findById(idTipoCargoPersona).orElse(new TipoCargoPersonaEntity());
//
//        List<Estrategia_org_r_persona_cargoDTO> OrgCargoPersonaDTOList =  personaClient.findAllPersonasByIdEstOrgCargo(idTipoCargoPersona);
//
//        return PersonaCargoByIdEstOrgCargo.builder()
//        		.org_cargo_id(tipoCargoPersona.getOrg_cargo_id())
//        		.org_persona_id(tipoCargoPersona.getPOrg_persona_id())
//        		.OrgCargoPersonaDTOList(OrgCargoPersonaDTOList)
//        		.build();
//  }
	
}
