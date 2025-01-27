package com.microservice.bff.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.bff.Client.ProyectoClientEstrategia_org_departamento;
import com.microservice.bff.DTO.ProyectoDTOEstrategia_org_departamento;

@Service

public class BffServiceEstrategia_org_departamentoImpl implements IBffServiceEstrategia_org_departamento {
	
	@Autowired
	private ProyectoClientEstrategia_org_departamento proyectoClient;
	
	@Override
	public List<ProyectoDTOEstrategia_org_departamento> FindAll() {
	    try {
	        return proyectoClient.findAll();
	    } catch (Exception e) {
	        // Manejo del error, por ejemplo, logueando el error
	        throw new RuntimeException("Error al obtener proyectos: " + e.getMessage());
	    }
	}


	@Override
	public Optional<ProyectoDTOEstrategia_org_departamento> FindById(Long id) {
		return proyectoClient.findById(id);
	}

	@Override
	public void Save(ProyectoDTOEstrategia_org_departamento proyectoDTO) {
		proyectoClient.save(proyectoDTO);
	}

	@Override
	public void DeleteById(Long id) {
		proyectoClient.deleteById(id);
	}

	@Override
	public ProyectoDTOEstrategia_org_departamento updateProyecto(Long id, ProyectoDTOEstrategia_org_departamento proyectoDetails) {
		proyectoClient.updateProyecto(id, proyectoDetails);
		return null;
	}
}