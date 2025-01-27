package com.MC_ESTRATEGIA_EST_ORG_DEPARTAMENTO.backend.DTO;

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
public class BscObjetivoDTO {
	 @NotNull
    private Long id; 

    @NotNull
    private Long bscTipoObjetivoId;

    @NotNull
    private Long bscTemaId; 
    @NotNull
    private Long orgDepartamentoIdResponsable; 
    @NotBlank
    private String nombre;

    @NotBlank
    private String alias;

    @NotBlank
    private String descripcion;

    @NotNull
    private int orden; 
    @NotBlank
    private String codigo;

    @NotNull
    private Date fechaRegistro; 
}
