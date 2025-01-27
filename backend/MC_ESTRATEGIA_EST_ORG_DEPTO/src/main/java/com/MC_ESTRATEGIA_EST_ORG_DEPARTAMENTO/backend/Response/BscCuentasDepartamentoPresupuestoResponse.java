package com.MC_ESTRATEGIA_EST_ORG_DEPARTAMENTO.backend.Response;

import java.util.List;

import com.MC_ESTRATEGIA_EST_ORG_DEPARTAMENTO.backend.DTO.BscCuentasDepartamentoPresupuestoDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BscCuentasDepartamentoPresupuestoResponse {
    private String nombreDepartamento; // Puedes cambiar este campo según lo que necesites
    private List<BscCuentasDepartamentoPresupuestoDTO> cuentas; // Lista de cuentas asociadas

    // Agrega más campos si es necesario
}
