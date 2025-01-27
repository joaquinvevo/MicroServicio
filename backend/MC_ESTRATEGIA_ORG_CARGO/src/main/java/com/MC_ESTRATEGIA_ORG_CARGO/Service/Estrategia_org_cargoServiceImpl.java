package com.MC_ESTRATEGIA_ORG_CARGO.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.MC_ESTRATEGIA_ORG_CARGO.DTO.Estrategia_org_cargoDTO;
import com.MC_ESTRATEGIA_ORG_CARGO.DTO.Estrategia_org_r_persona_cargoDTO;
import com.MC_ESTRATEGIA_ORG_CARGO.Entity.Estrategia_org_cargoEntity;
import com.MC_ESTRATEGIA_ORG_CARGO.Repository.Estrategia_org_cargoRepository;

import jakarta.validation.constraints.NotNull;

@Component
@Service
public class Estrategia_org_cargoServiceImpl implements IEstrategia_org_cargoService {
	
	@Autowired
	private Estrategia_org_cargoRepository estrategia_org_cargoRepository;

	@Override
	public List<Estrategia_org_cargoDTO> findAll() {
		List<Estrategia_org_cargoEntity> ListE = (List<Estrategia_org_cargoEntity>) estrategia_org_cargoRepository.findAll();
		List<Estrategia_org_cargoDTO> ListDTO = new ArrayList<>();
		for (Estrategia_org_cargoEntity e : ListE) {
			ListDTO.add(e.toDTO());
		}
		return ListDTO;
	}
	
	@Override
	public Optional<Estrategia_org_cargoDTO> findById(int id) {
		Optional<Estrategia_org_cargoEntity> oe = estrategia_org_cargoRepository.findById(id);
		Estrategia_org_cargoEntity e = oe.get();
		Estrategia_org_cargoDTO dto = e.toDTO();
		return Optional.ofNullable(dto);
	}
	
	@Override
	public Estrategia_org_cargoDTO save(Estrategia_org_cargoDTO estrategia_org_cargoEntity) {
		Estrategia_org_cargoEntity e = estrategia_org_cargoRepository.save(estrategia_org_cargoEntity.toEntity());
		return e.toDTO();
	}
	
	@Override
	public void delete(Estrategia_org_cargoDTO dto) {
		estrategia_org_cargoRepository.delete(dto.toEntity());
	}
	
	@Override
	public List<Estrategia_org_cargoDTO> fk(Long estCargoId) {
	    List<Estrategia_org_cargoEntity> subModelos = estrategia_org_cargoRepository.findByPersonaCargoId(estCargoId);
	    return subModelos.stream().map(Estrategia_org_cargoEntity::toDTO).collect(Collectors.toList());
	}
	
//	@Override
//	public situacionByIdEstSubmodeloId findAllSituacionesByIdEstSubModelo(Long idTipoCargoPersona) {
//		Estrategia_org_cargoEntity tipoCargoPersona = tipoCargoPersonaRepository.findById(idTipoCargoPersona).orElse(new TipoCargoPersonaEntity());
//
//        List<Estrategia_org_r_persona_cargoDTO> OrgCargoPersonaDTOList =  personaClient.findAllPersonasByIdEstOrgCargo(idTipoCargoPersona);
//
//        return PersonaCargoByIdEstOrgCargo.builder()
//        		.org_cargo_id(tipoCargoPersona.getOrg_cargo_id())
//        		.org_persona_id(tipoCargoPersona.getPOrg_persona_id())
//        		.OrgCargoPersonaDTOList(OrgCargoPersonaDTOList)
//        		.build();
//  }

}
