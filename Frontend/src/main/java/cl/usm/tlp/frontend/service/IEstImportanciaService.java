package cl.usm.tlp.frontend.service;

import java.util.List;

import cl.usm.tlp.frontend.dto.EstImportanciaDTO;


public interface IEstImportanciaService {
	
	public List<EstImportanciaDTO> findAllREST();

	public EstImportanciaDTO findByIdREST(Long id);

	public EstImportanciaDTO saveREST(EstImportanciaDTO p);

	public EstImportanciaDTO deleteREST(Long id);
}
