package com.MC_ESTRATEGIA_ORG_CARGO.Service;

import java.util.List;
import java.util.Optional;

import com.MC_ESTRATEGIA_ORG_CARGO.DTO.Estrategia_org_cargoDTO;

public interface IEstrategia_org_cargoService {
	
	public List<Estrategia_org_cargoDTO> findAll();
	
	public Optional<Estrategia_org_cargoDTO> findById(int id);
	
	public Estrategia_org_cargoDTO save(Estrategia_org_cargoDTO estrategia_org_cargoDTO);
	
	public void delete(Estrategia_org_cargoDTO dto);
	
	public List<Estrategia_org_cargoDTO> fk(Long est_cargo_id);
	
	//cargoPersonaByIdEstOrgcargoId findAllPersonasByIdEstOrgCargo(Long EstOrgcargoId);

}
