package cl.usm.estrategia.est_sub_modelo.Service;

import java.util.List;
import java.util.Optional;

import cl.usm.estrategia.est_sub_modelo.DTO.Estrategia_est_sub_modeloDTO;
import cl.usm.estrategia.est_sub_modelo.Response.situacionByIdEstSubmodeloId;

public interface IEstrategia_est_sub_modeloService {
	
	public List<Estrategia_est_sub_modeloDTO> findAll();
	
	public Optional<Estrategia_est_sub_modeloDTO> findById(Long id);
	
	public Estrategia_est_sub_modeloDTO save(Estrategia_est_sub_modeloDTO estrategia_est_sub_modelo);
	
	public void delete(Estrategia_est_sub_modeloDTO dto);
	
	public List<Estrategia_est_sub_modeloDTO> fk(Long est_modelo_id);
	
	//situacionByIdEstSubmodeloId findAllSituacionesByIdEstSubModelo(Long EstSubmodeloId);
}
