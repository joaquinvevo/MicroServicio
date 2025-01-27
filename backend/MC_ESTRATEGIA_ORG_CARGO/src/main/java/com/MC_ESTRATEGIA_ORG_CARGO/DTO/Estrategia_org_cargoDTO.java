package com.MC_ESTRATEGIA_ORG_CARGO.DTO;

import java.util.Date;

import com.MC_ESTRATEGIA_ORG_CARGO.Entity.Estrategia_org_cargoEntity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Estrategia_org_cargoDTO {
	
	
	private int id;
	
	@NotNull
    private Long est_persona_cargo_id;  
	
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
	
    public Estrategia_org_cargoEntity toEntity() {
    	Estrategia_org_cargoEntity entity = new Estrategia_org_cargoEntity();
        entity.setId(getId());
        entity.setEst_persona_cargo_id(getEst_persona_cargo_id());
        entity.setNombre(getNombre());
        entity.setAlias(getAlias());
        entity.setDescripcion(getDescripcion());
        entity.setOrden(getOrden());
        entity.setFecha_registro(getFecha_registro());
        return entity;
    }

	
}
