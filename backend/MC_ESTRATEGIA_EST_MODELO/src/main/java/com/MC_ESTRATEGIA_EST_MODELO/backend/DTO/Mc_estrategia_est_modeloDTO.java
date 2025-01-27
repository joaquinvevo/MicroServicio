package com.MC_ESTRATEGIA_EST_MODELO.backend.DTO;

import java.time.LocalDate;
import java.util.Date;

import com.MC_ESTRATEGIA_EST_MODELO.backend.Entity.Mc_estrategia_est_modelo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Mc_estrategia_est_modeloDTO {
	
	
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
	
	public Mc_estrategia_est_modelo toEntity() {
		Mc_estrategia_est_modelo e = new Mc_estrategia_est_modelo(id,nombre,alias,descripcion,orden,aplicaSoloADepartamentos,fechaRegistro);
	    e.setId(getId());
		e.setNombre(getNombre());
		e.setAlias(getAlias());
		e.setDescripcion(getDescripcion());
		e.setOrden(getOrden());
		e.setAplicaSoloADepartamentos(getAplicaSoloADepartamentos());
		e.setFechaRegistro(getFechaRegistro());
		return e;
	
			
		
		
	}	
}
