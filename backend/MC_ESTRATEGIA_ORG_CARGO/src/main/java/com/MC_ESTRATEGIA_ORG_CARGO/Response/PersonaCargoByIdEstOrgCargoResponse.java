package com.MC_ESTRATEGIA_ORG_CARGO.Response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.MC_ESTRATEGIA_ORG_CARGO.DTO.Estrategia_org_r_persona_cargoDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonaCargoByIdEstOrgCargoResponse {

	private Long org_cargo_id;

	private Long org_persona_id;
	
    private List<Estrategia_org_r_persona_cargoDTO> OrgCargoPersonaDTOList;

}
