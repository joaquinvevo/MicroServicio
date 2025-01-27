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

public class ProyectoDTOEstrategia_org_departamento {
	
    private Long id; 
	
    @NotNull
	private Long org_departamento_id_padre; 
    
    @NotNull
    private int nivel; 
    
    @NotBlank
    private String nombre;
    
    @NotBlank
    private String alias;
    
    @NotBlank
    private String descripcion;
    
    @NotNull
    private Integer orden; 
    
    @NotNull
    private Date fecha_registro; 
}

