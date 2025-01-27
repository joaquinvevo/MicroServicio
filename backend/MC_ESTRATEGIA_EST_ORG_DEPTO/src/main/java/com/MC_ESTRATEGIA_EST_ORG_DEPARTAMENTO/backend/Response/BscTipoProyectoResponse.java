package com.MC_ESTRATEGIA_EST_ORG_DEPARTAMENTO.backend.Response;

import java.util.List;

import com.MC_ESTRATEGIA_EST_ORG_DEPARTAMENTO.backend.DTO.BscTipoProyectoDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BscTipoProyectoResponse {
    private String nombreTipoProyecto; // Nombre del tipo de proyecto
    private List<BscTipoProyectoDTO> bscTipoProyectos;
}