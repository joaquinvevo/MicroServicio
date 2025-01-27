package cl.usm.tlp.frontend.service;

import java.util.List;

import cl.usm.tlp.frontend.dto.EstSituacionDTO;


public interface IEstSituacionService {
	
	public List<EstSituacionDTO> findAllREST();

	public EstSituacionDTO findByIdREST(Long id);

	public EstSituacionDTO saveREST(EstSituacionDTO p);

	public EstSituacionDTO deleteREST(Long id);
	
	public EstSituacionDTO updateREST(Long id, EstSituacionDTO p);
}
