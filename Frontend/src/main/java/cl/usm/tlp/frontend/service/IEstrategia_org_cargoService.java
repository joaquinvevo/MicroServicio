package cl.usm.tlp.frontend.service;

import java.util.List;

import cl.usm.tlp.frontend.dto.Estrategia_org_cargoDTO;

public interface IEstrategia_org_cargoService {
	
	public List<Estrategia_org_cargoDTO> findAllREST();

	public Estrategia_org_cargoDTO findByIdREST(Long id);

	public Estrategia_org_cargoDTO saveREST(Estrategia_org_cargoDTO cargo);

	public Estrategia_org_cargoDTO deleteREST(Long id);

}
