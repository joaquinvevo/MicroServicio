package com.MC_ESTRATEGIA_EST_MODELO.backend.Service;

import java.util.List;
import java.util.Optional;

import com.MC_ESTRATEGIA_EST_MODELO.Response.ModeloByIdTipo;
import com.MC_ESTRATEGIA_EST_MODELO.backend.DTO.Mc_estrategia_est_modeloDTO;

public interface IMc_estrategia_est_modeloService {
	
	public List<Mc_estrategia_est_modeloDTO> findAll();
	public Optional<Mc_estrategia_est_modeloDTO> findById(Long id);
	
	ModeloByIdTipo findAllModeloByIdTipo(Long estModeloId);
	
	public Mc_estrategia_est_modeloDTO save(Mc_estrategia_est_modeloDTO mc_estrategia_est_modelo);
	
	public void delete(Mc_estrategia_est_modeloDTO dto);
	
	
	

}
