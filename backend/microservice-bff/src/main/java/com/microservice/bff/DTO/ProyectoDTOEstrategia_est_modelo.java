package com.microservice.bff.DTO;

import java.time.LocalDate;
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
public class ProyectoDTOEstrategia_est_modelo {
	
	
	private Long id;
	
	@NotBlank
	private String nombre;
	
	@NotBlank
	private String alias;
	
	@NotBlank
	private String descripcion;
	
	@NotNull
	private Integer orden;
	
	@NotNull
	private Boolean aplicaSoloADepartamentos;
	
	
	private Date fechaRegistro;


}
