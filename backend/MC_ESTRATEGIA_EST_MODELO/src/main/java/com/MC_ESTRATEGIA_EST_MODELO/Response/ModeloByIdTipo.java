package com.MC_ESTRATEGIA_EST_MODELO.Response;

import java.util.List;

import com.MC_ESTRATEGIA_EST_MODELO.backend.DTO.MC_ESTRATEGIA_SUBMODELODTO;

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

    private List<MC_ESTRATEGIA_SUBMODELODTO>MC_ESTRATEGIA_SUBMODELODTOList;

}
