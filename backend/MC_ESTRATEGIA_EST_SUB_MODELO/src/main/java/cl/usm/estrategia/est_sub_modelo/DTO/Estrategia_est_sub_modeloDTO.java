package cl.usm.estrategia.est_sub_modelo.DTO;

import java.util.Date;

import cl.usm.estrategia.est_sub_modelo.Entity.Estrategia_est_sub_modeloEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Estrategia_est_sub_modeloDTO {
	
    private Long id;
    
    @NotNull
    private Long est_modelo_id;
    
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
    
    public Estrategia_est_sub_modeloEntity toEntity() {
        Estrategia_est_sub_modeloEntity entity = new Estrategia_est_sub_modeloEntity();
        entity.setId(getId());
        entity.setEst_modelo_id(getEst_modelo_id());
        entity.setNombre(getNombre());
        entity.setAlias(getAlias());
        entity.setDescripcion(getDescripcion());
        entity.setOrden(getOrden());
        entity.setFecha_registro(getFecha_registro());
        return entity;
    }
}
