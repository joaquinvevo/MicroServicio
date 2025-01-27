package com.microservice.bff.DTO;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BscCuentasDepartamentoPresupuestoDTO {
	@NotNull
    private Long bscPlanDeCuentasId; 

    @NotNull
    private Long orgDepartamentoId;
    @NotNull
    private int presupuesto;

    @NotBlank
    private String observacion;

    @NotNull
    private Date fechaRegistro; 
}
