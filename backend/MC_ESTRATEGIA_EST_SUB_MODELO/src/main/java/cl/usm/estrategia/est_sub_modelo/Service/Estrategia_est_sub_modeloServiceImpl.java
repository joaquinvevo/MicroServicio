package cl.usm.estrategia.est_sub_modelo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import cl.usm.estrategia.est_sub_modelo.Client.ProyectoClient;
import cl.usm.estrategia.est_sub_modelo.DTO.Estrategia_est_situacionDTO;
import cl.usm.estrategia.est_sub_modelo.DTO.Estrategia_est_sub_modeloDTO;
import cl.usm.estrategia.est_sub_modelo.Entity.Estrategia_est_sub_modeloEntity;
import cl.usm.estrategia.est_sub_modelo.Repository.Estrategia_est_sub_modeloRepository;
import cl.usm.estrategia.est_sub_modelo.Response.situacionByIdEstSubmodeloId;

@Component
@Service
public class Estrategia_est_sub_modeloServiceImpl implements IEstrategia_est_sub_modeloService {
	
	private final Estrategia_est_sub_modeloRepository estrategia_est_sub_modeloRepository;
	
	//private final ProyectoClient proyectoClient;
	
    @Autowired
    public Estrategia_est_sub_modeloServiceImpl(Estrategia_est_sub_modeloRepository estrategia_est_sub_modeloRepository/*, ProyectoClient proyectoClient*/) {
        this.estrategia_est_sub_modeloRepository = estrategia_est_sub_modeloRepository;
		//this.proyectoClient = proyectoClient;
    }
	
	@Override
	public List<Estrategia_est_sub_modeloDTO> findAll() {
		List<Estrategia_est_sub_modeloEntity> entityList = (List<Estrategia_est_sub_modeloEntity>) estrategia_est_sub_modeloRepository.findAll();
		List<Estrategia_est_sub_modeloDTO> dtoList = new ArrayList<>();
		for (Estrategia_est_sub_modeloEntity entity : entityList) {
			dtoList.add(entity.toDTO());
		}
		return dtoList;
	}
	
	@Override
	public Optional<Estrategia_est_sub_modeloDTO> findById(Long id) {
		Optional<Estrategia_est_sub_modeloEntity> entityOpt = estrategia_est_sub_modeloRepository.findById(id);
		if (entityOpt.isPresent()) {
			return Optional.of(entityOpt.get().toDTO());
		} else {
			return Optional.empty();
		}
	}
	
	@Override
	public Estrategia_est_sub_modeloDTO save(Estrategia_est_sub_modeloDTO estrategiaEstSubModeloDTO) {
		Estrategia_est_sub_modeloEntity entity = estrategiaEstSubModeloDTO.toEntity();
		entity = estrategia_est_sub_modeloRepository.save(entity);
		return entity.toDTO();
	}
	
	@Override
	public void delete(Estrategia_est_sub_modeloDTO dto) {
		Estrategia_est_sub_modeloEntity entity = dto.toEntity();
		estrategia_est_sub_modeloRepository.delete(entity);
	}
	
	@Override
	public List<Estrategia_est_sub_modeloDTO> fk(Long estModeloId) {
	    List<Estrategia_est_sub_modeloEntity> subModelos = estrategia_est_sub_modeloRepository.findByEstModeloId(estModeloId);
	    return subModelos.stream().map(Estrategia_est_sub_modeloEntity::toDTO).collect(Collectors.toList());
	}
	
	//@Override
	//public situacionByIdEstSubmodeloId findAllSituacionesByIdEstSubModelo(Long EstSubmodeloId) {
	//	Estrategia_est_sub_modeloEntity tipoSituacion = estrategia_est_sub_modeloRepository.findById(EstSubmodeloId).orElse(new Estrategia_est_sub_modeloEntity());

    //    List<Estrategia_est_situacionDTO> proyectoDTOList =  proyectoClient.findAllSituacionesByIdEstSubModelo(EstSubmodeloId);

    //    return situacionByIdEstSubmodeloId.builder()
    //    		.nombre(tipoSituacion.getNombre())
    //    		.alias(tipoSituacion.getAlias())
    //    		.ProyectoDTOList(proyectoDTOList)
    //    		.build();
  //}
}
