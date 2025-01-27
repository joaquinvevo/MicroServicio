package cl.usm.tlp.frontend.service;

import java.util.List;

import cl.usm.tlp.frontend.dto.EstImpactoDTO;


public interface IEstImpactoService {
	
	public List<EstImpactoDTO> findAllREST();

	public EstImpactoDTO findByIdREST(Long id);

	public EstImpactoDTO saveREST(EstImpactoDTO p);

	public EstImpactoDTO deleteREST(Long id);
}
