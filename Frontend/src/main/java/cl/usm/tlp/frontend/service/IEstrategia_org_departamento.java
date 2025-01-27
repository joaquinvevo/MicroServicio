package cl.usm.tlp.frontend.service;

import java.util.List;

import cl.usm.tlp.frontend.dto.Estrategia_org_departamentoDTO;


public interface IEstrategia_org_departamento {
	
	public List<Estrategia_org_departamentoDTO> findAllREST();

	public Estrategia_org_departamentoDTO findByIdREST(Long id);

	public Estrategia_org_departamentoDTO saveREST(Estrategia_org_departamentoDTO dpto);

	public Estrategia_org_departamentoDTO deleteREST(Long id);
}
