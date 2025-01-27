package com.microservice.bff.DTO;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public class ProyectoDTOEstrategia_est_situacion {
	
	private Long id;
	
	@NotNull
	private Long est_submodelo_id;
	
	@NotNull
	private Long bcs_objetivo_id;
	
	@NotNull
	private Long est_impacto_id;
	
	@NotNull
	private Long est_importancia_id;
	
	@NotNull
	private Integer relevancia;

	@NotBlank
	private String nombre;
	
	@NotBlank
	private String alias;
	
	@NotBlank
	private String descripcion;
	
	@NotNull
	private Integer orden;
	
	@NotNull
	private boolean incluir;
	
	@NotNull
	private Date fecha_registro;
	
	 
		
	


}

