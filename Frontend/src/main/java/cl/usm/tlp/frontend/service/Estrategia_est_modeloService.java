package cl.usm.tlp.frontend.service;

import java.util.List;

import cl.usm.tlp.frontend.dto.Estrategia_est_modeloDTO;

public interface Estrategia_est_modeloService {

	public List<Estrategia_est_modeloDTO> findAllREST();

	public Estrategia_est_modeloDTO findByIdREST(Long id);

	public Estrategia_est_modeloDTO saveREST(Estrategia_est_modeloDTO p);

	public Estrategia_est_modeloDTO deleteREST(Long id);
}
