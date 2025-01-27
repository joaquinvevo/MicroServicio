package com.microservice.bff.DTO;

import java.util.Date;

import jakarta.validation.constraints.NotNull;

public class Estrategia_org_r_persona_cargoDTO {
	
	@NotNull
	private Long org_cargo_id;
	
	@NotNull
	private Long org_persona_id;
	
	@NotNull
	private Date fecha_registro;

}
