package cl.usm.tlp.frontend.service;

import java.util.List;

import cl.usm.tlp.frontend.dto.EstUrgenciaDTO;


public interface IEstUrgenciaService {
	
	public List<EstUrgenciaDTO> findAllREST();

	public EstUrgenciaDTO findByIdREST(Long id);

	public EstUrgenciaDTO saveREST(EstUrgenciaDTO p);

	public EstUrgenciaDTO deleteREST(Long id);
}
