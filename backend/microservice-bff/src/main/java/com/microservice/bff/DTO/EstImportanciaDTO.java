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
public class EstImportanciaDTO {
	
	private Long id;
	
	@NotBlank
	private String nombre;
	
	@NotBlank
	private String alias;
	
	@NotNull
	private Date fecha_registro;
}
