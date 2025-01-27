package com.MC_ESTRATEGIA_EST_ORG_DEPARTAMENTO.backend.Response;

import java.util.List;

import com.MC_ESTRATEGIA_EST_ORG_DEPARTAMENTO.backend.DTO.BscObjetivoDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BscObjetivoResponse {
    private String nombreTipoObjetivo; // Puedes cambiar este campo según lo que necesites
    private List<BscObjetivoDTO> bscObjetivos; // Lista de objetivos asociados

    // Agrega más campos si es necesario
}
