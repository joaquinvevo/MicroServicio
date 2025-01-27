package com.MC_ESTRATEGIA_ORG_CARGO.Entity;

import java.util.Date;

import com.MC_ESTRATEGIA_ORG_CARGO.DTO.Estrategia_org_cargoDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "org_cargo")
public class Estrategia_org_cargoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private Long est_persona_cargo_id; 
	
	@Column
	private String nombre;
	
	@Column
	private String alias;
	
	@Column
	private String descripcion;
	
	@Column
	private Integer orden;
	
	@Column
	private Date fecha_registro;

    public Estrategia_org_cargoEntity(@JsonProperty("id") int id,
    		  @JsonProperty("est_persona_cargo_id") Long est_persona_cargo_id,
	          @JsonProperty("nombre") String nombre,
	          @JsonProperty("alias") String alias, 
	          @JsonProperty("descripcion") String descripcion,
	          @JsonProperty("orden") Integer orden, 
	          @JsonProperty("fecha_registro") Date fecha_registro) {
	super();
	this.id = id;
	this.est_persona_cargo_id=est_persona_cargo_id;
	this.nombre = nombre;
	this.alias = alias;
	this.descripcion = descripcion;
	this.orden = orden;
	this.fecha_registro = fecha_registro;
    }
    
    public Estrategia_org_cargoDTO toDTO() {
    	Estrategia_org_cargoDTO dto = new Estrategia_org_cargoDTO();
    	dto.setId(getId());
    	dto.setEst_persona_cargo_id(getEst_persona_cargo_id());
    	dto.setNombre(getNombre());
    	dto.setAlias(getAlias());
    	dto.setDescripcion(getDescripcion());
    	dto.setOrden(getOrden());
    	dto.setFecha_registro(getFecha_registro());
    	return dto;
    }
}
