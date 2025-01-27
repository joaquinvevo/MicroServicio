package cl.usm.tlp.frontend.service;

import java.util.List;

import cl.usm.tlp.frontend.dto.BcsObjetivoDTO;


public interface IBcsObjetivoService {
	
	public List<BcsObjetivoDTO> findAllREST();

	public BcsObjetivoDTO findByIdREST(Long id);

	public BcsObjetivoDTO saveREST(BcsObjetivoDTO p);

	public BcsObjetivoDTO deleteREST(Long id);
}
