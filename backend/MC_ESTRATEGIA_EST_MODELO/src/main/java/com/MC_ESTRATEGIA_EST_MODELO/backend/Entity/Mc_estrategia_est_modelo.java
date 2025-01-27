package com.MC_ESTRATEGIA_EST_MODELO.backend.Entity;

import java.time.LocalDate;
import java.util.Date;

import com.MC_ESTRATEGIA_EST_MODELO.backend.DTO.Mc_estrategia_est_modeloDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="est_modelo")
public class Mc_estrategia_est_modelo {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator= "proyecto")
	@SequenceGenerator(name= "proyecto", sequenceName = "proyecto_m", allocationSize = 1)
    private Long id;  

    @Column
    private String nombre;  

    @Column
    private String alias; 

    @Column
    private String descripcion; 

    @Column
    private Integer orden;  

    @Column
    private Boolean aplicaSoloADepartamentos; 

    @Column
    private Date fechaRegistro;  
    
    public Mc_estrategia_est_modelo(@JsonProperty("id") Long id,  @JsonProperty("nombre") String nombre,
    		@JsonProperty("alias") String alias, @JsonProperty("descripcion") String descripcion,
    		@JsonProperty("orden") Integer orden, @JsonProperty("aplicaSoloADepartamentos") Boolean aplicaSoloADepartamentos,
    		@JsonProperty("fechaRegistro") Date fechaRegistro) {
    	
    	super();
    	this.id=id;
    	this.nombre= nombre;
    	this.alias= alias;
    	this.descripcion= descripcion;
    	this.orden= orden;
    	this.aplicaSoloADepartamentos= aplicaSoloADepartamentos;
    	this.fechaRegistro = fechaRegistro;
    			
    }
    
    public Mc_estrategia_est_modeloDTO toDTO() {
    	Mc_estrategia_est_modeloDTO dto = new Mc_estrategia_est_modeloDTO();
    	dto.setId(getId());
    	dto.setNombre(getNombre());
    	dto.setAlias(getAlias());
    	dto.setDescripcion(getDescripcion());
    	dto.setOrden(getOrden());
    	dto.setAplicaSoloADepartamentos(getAplicaSoloADepartamentos());
    	dto.setFechaRegistro(getFechaRegistro());
    	return dto;
    	
    	
    }
    
}
