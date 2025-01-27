package com.microservice.bff.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.bff.Client.ProyectoClientEstrategia_est_sub_modelo;
import com.microservice.bff.DTO.*;

@Service
public class BffServiceEstrategia_est_sub_modeloImpl implements IBffServiceEstrategia_est_sub_modelo{
	
	@Autowired
	private ProyectoClientEstrategia_est_sub_modelo proyectoClient;
	
	@Override
	public List<ProyectoDTOEstrategia_est_sub_modelo> FindAll() {
	    try {
	        return proyectoClient.findAll();
	    } catch (Exception e) {
	        // Manejo del error, por ejemplo, logueando el error
	        throw new RuntimeException("Error al obtener proyectos: " + e.getMessage());
	    }
	}


	@Override
	public Optional<ProyectoDTOEstrategia_est_sub_modelo> FindById(Long id) {
		return proyectoClient.findById(id);
	}

	@Override
	public void Save(ProyectoDTOEstrategia_est_sub_modelo proyectoDTO) {
		proyectoClient.save(proyectoDTO);
	}

	@Override
	public void DeleteById(Long id) {
		proyectoClient.deleteById(id);
	}

	@Override
	public ProyectoDTOEstrategia_est_sub_modelo updateProyecto(Long id, ProyectoDTOEstrategia_est_sub_modelo proyectoDetails) {
	    // Asegúrate de que el ID en proyectoDetails sea el mismo que se está pasando
	    if (proyectoDetails.getId() == null) {
	        throw new IllegalArgumentException("El ID no puede ser nulo para la actualización.");
	    }
	    
	    // Aquí llamas al cliente para realizar la actualización
	    return proyectoClient.updateProyecto(proyectoDetails); // Cambia esto para que coincida con la nueva firma
	}

	//@Override
	//public situacionByIdEstSubmodeloId findAllSituacionesByIdEstSubModelo(Long EstSubmodeloId) {
	//	return proyectoClient.findAllSituacionesByIdEstSubModelo(EstSubmodeloId);
	//}
	
}
