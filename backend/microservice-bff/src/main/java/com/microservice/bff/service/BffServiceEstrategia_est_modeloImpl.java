package com.microservice.bff.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.bff.Client.ProyectoClientEstrategia_est_modelo;
import com.microservice.bff.DTO.*;

@Service
public class BffServiceEstrategia_est_modeloImpl implements IBffServiceEstrategia_est_modelo{
	
	@Autowired
	private ProyectoClientEstrategia_est_modelo proyectoClient;
	
	@Override
	public List<ProyectoDTOEstrategia_est_modelo> FindAll() {
	    try {
	        return proyectoClient.findAll();
	    } catch (Exception e) {
	        // Manejo del error, por ejemplo, logueando el error
	        throw new RuntimeException("Error al obtener proyectos: " + e.getMessage());
	    }
	}


	@Override
	public Optional<ProyectoDTOEstrategia_est_modelo> FindById(Long id) {
		return proyectoClient.findById(id);
	}

	@Override
	public void Save(ProyectoDTOEstrategia_est_modelo proyectoDTO) {
		proyectoClient.save(proyectoDTO);
	}

	@Override
	public void DeleteById(Long id) {
		proyectoClient.deleteById(id);
	}

	@Override
	public ProyectoDTOEstrategia_est_modelo updateProyecto(ProyectoDTOEstrategia_est_modelo proyectoDetails) {
		proyectoClient.updateProyecto(proyectoDetails);
		return null;
	}
	
	@Override
	public ModeloByIdTipo findAllModeloByIdTipo(Long estModeloId) {
		return proyectoClient.findAllModeloByIdTipo(estModeloId);
	}
	
	
}
