package com.MC_ESTRATEGIA_EST_ORG_DEPARTAMENTO.backend.DTO;

import java.util.Date;

import com.MC_ESTRATEGIA_EST_ORG_DEPARTAMENTO.backend.Entity.Estrategia_org_departamentoEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Estrategia_org_departamentoDTO {
    
    
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fecha_registro;
    
    public Estrategia_org_departamentoEntity toEntity() {
        Estrategia_org_departamentoEntity entity = new Estrategia_org_departamentoEntity();
        entity.setId(getId());
        entity.setOrg_departamento_id_padre(getOrg_departamento_id_padre());
        entity.setNivel(getNivel());
        entity.setNombre(getNombre());
        entity.setAlias(getAlias());
        entity.setDescripcion(getDescripcion());
        entity.setOrden(getOrden());
        entity.setFecha_registro(getFecha_registro());
        return entity;
    }
}
