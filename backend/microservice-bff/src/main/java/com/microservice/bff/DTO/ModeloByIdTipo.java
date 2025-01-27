package com.microservice.bff.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ModeloByIdTipo {
	
    private String name;
	
	private String alias;

    private List<ProyectoDTOEstrategia_est_sub_modelo>MC_ESTRATEGIA_SUBMODELODTOList;

}

