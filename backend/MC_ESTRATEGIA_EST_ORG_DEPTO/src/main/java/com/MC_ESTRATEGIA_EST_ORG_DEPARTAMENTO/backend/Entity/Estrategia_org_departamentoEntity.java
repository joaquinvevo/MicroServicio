package com.MC_ESTRATEGIA_EST_ORG_DEPARTAMENTO.backend.Entity;

import java.util.Date;

import com.MC_ESTRATEGIA_EST_ORG_DEPARTAMENTO.backend.DTO.Estrategia_org_departamentoDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name="org_departamento")
public class Estrategia_org_departamentoEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;  

	@Column(name = "org_departamento_id_padre", length = 20)
    private Long org_departamento_id_padre;  

    @Column
    private int nivel; 

    @Column
    private String nombre;  

    @Column
    private String alias;  

    @Column
    private String descripcion;  

    @Column
    private Integer orden;  

    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fecha_registro; 
    
    public Estrategia_org_departamentoEntity(@JsonProperty("id") Long id, 
                                             @JsonProperty("org_departamento_id_padre") Long org_departamento_id_padre,
                                             @JsonProperty("nivel") int nivel, 
                                             @JsonProperty("nombre") String nombre,
                                             @JsonProperty("alias") String alias, 
                                             @JsonProperty("descripcion") String descripcion,
                                             @JsonProperty("orden") Integer orden, 
                                             @JsonProperty("fecha_registro") Date fecha_registro) {
    	
    	super();
    	this.id = id;
    	this.org_departamento_id_padre = org_departamento_id_padre;
    	this.nivel = nivel;
    	this.nombre = nombre;
    	this.alias = alias;
    	this.descripcion = descripcion;
    	this.orden = orden;
    	this.fecha_registro = fecha_registro;
    }
    
    public Estrategia_org_departamentoDTO toDTO() {
    	Estrategia_org_departamentoDTO dto = new Estrategia_org_departamentoDTO();
    	dto.setId(getId());
    	dto.setOrg_departamento_id_padre(getOrg_departamento_id_padre());
    	dto.setNivel(getNivel());
    	dto.setNombre(getNombre());
    	dto.setAlias(getAlias());
    	dto.setDescripcion(getDescripcion());
    	dto.setOrden(getOrden());
    	dto.setFecha_registro(getFecha_registro());
    	return dto;
    }
}
