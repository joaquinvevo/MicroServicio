package com.MC_ESTRATEGIA_EST_MODELO.backend.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.MC_ESTRATEGIA_EST_MODELO.Response.ModeloByIdTipo;
import com.MC_ESTRATEGIA_EST_MODELO.backend.Client.Mc_estrategia_est_modeloClient;
import com.MC_ESTRATEGIA_EST_MODELO.backend.DTO.MC_ESTRATEGIA_SUBMODELODTO;
import com.MC_ESTRATEGIA_EST_MODELO.backend.DTO.Mc_estrategia_est_modeloDTO;
import com.MC_ESTRATEGIA_EST_MODELO.backend.Entity.Mc_estrategia_est_modelo;
import com.MC_ESTRATEGIA_EST_MODELO.backend.Repository.Mc_estrategia_est_modeloRepository;


@Component
@Service
public class Mc_estrategia_est_modeloServiceImpl implements IMc_estrategia_est_modeloService{
	
	@Autowired
	private Mc_estrategia_est_modeloRepository mc_estrategia_est_modeloRepository;
	
	@Autowired
	private Mc_estrategia_est_modeloClient mc_client;
	
	@Override
	public ModeloByIdTipo findAllModeloByIdTipo(Long  estModeloId) {
		Mc_estrategia_est_modelo proyecto = mc_estrategia_est_modeloRepository.findById(estModeloId).orElse(new Mc_estrategia_est_modelo());

        List<MC_ESTRATEGIA_SUBMODELODTO>MC_ESTRATEGIA_SUBMODELODTOList =  mc_client.findAllModeloByIdTipo(estModeloId);

        return ModeloByIdTipo.builder()
        		.name(proyecto.getNombre())
        		.alias(proyecto.getAlias())
        		.MC_ESTRATEGIA_SUBMODELODTOList(MC_ESTRATEGIA_SUBMODELODTOList)
        		.build();
	}
	
	@Override
	public List<Mc_estrategia_est_modeloDTO> findAll(){
		List<Mc_estrategia_est_modelo> listE = (List<Mc_estrategia_est_modelo>) mc_estrategia_est_modeloRepository.findAll();
		List<Mc_estrategia_est_modeloDTO> listDTO = new ArrayList<Mc_estrategia_est_modeloDTO>();
		for (Mc_estrategia_est_modelo e: listE) {
			listDTO.add(e.toDTO());
			
		}
		return listDTO;
		
	}
	
	@Override
	public Optional<Mc_estrategia_est_modeloDTO> findById( Long id){
		Optional<Mc_estrategia_est_modelo> oe = mc_estrategia_est_modeloRepository.findById(id);
		Mc_estrategia_est_modelo e = oe.get();
		Mc_estrategia_est_modeloDTO dto = e.toDTO();
		return Optional.ofNullable(dto);
		
	}
	
	@Override
	public Mc_estrategia_est_modeloDTO save(Mc_estrategia_est_modeloDTO mc_estrategia_est_modelo) {
		
		Mc_estrategia_est_modelo e = mc_estrategia_est_modeloRepository.save(mc_estrategia_est_modelo.toEntity());
		return e.toDTO();
	}
	
	@Override
	public void delete(Mc_estrategia_est_modeloDTO b) {
		
		 mc_estrategia_est_modeloRepository.delete(b.toEntity());
	}
	
	
	
	
	
	
	

}
