package cl.usm.tlp.frontend.service;

import java.util.List;

import cl.usm.tlp.frontend.dto.Estrategia_est_sub_modeloDTO;

public interface IEstrategia_est_sub_modeloService {

	public List<Estrategia_est_sub_modeloDTO> findAllREST();

	public Estrategia_est_sub_modeloDTO findByIdREST(Long id);

	public Estrategia_est_sub_modeloDTO saveREST(Estrategia_est_sub_modeloDTO p);

	public Estrategia_est_sub_modeloDTO deleteREST(Long id);
}