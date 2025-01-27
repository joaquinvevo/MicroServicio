package cl.usm.estrategia.est_sub_modelo.Entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import cl.usm.estrategia.est_sub_modelo.DTO.Estrategia_est_sub_modeloDTO;
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
@Table(name="est_submodelo")

public class Estrategia_est_sub_modeloEntity {
	
		@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "proyecto_gen")
	@SequenceGenerator(name = "proyecto_gen", sequenceName = "proyecto_seq", allocationSize = 1)
    private Long id;  

    @Column
    private Long est_modelo_id;  

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
    
    public Estrategia_est_sub_modeloEntity(@JsonProperty("id") Long id, 
            								  @JsonProperty("est_modelo_id") Long est_modelo_id, 
									          @JsonProperty("nombre") String nombre,
									          @JsonProperty("alias") String alias, 
									          @JsonProperty("descripcion") String descripcion,
									          @JsonProperty("orden") Integer orden, 
									          @JsonProperty("fecha_registro") Date fecha_registro) {

			super();
			this.id = id;
			this.est_modelo_id = est_modelo_id;
			this.nombre = nombre;
			this.alias = alias;
			this.descripcion = descripcion;
			this.orden = orden;
			this.fecha_registro = fecha_registro;
			
    }
    
    public Estrategia_est_sub_modeloDTO toDTO() {
    	Estrategia_est_sub_modeloDTO dto = new Estrategia_est_sub_modeloDTO();
    	dto.setId(getId());
    	dto.setEst_modelo_id(getEst_modelo_id());
    	dto.setNombre(getNombre());
    	dto.setAlias(getAlias());
    	dto.setDescripcion(getDescripcion());
    	dto.setOrden(getOrden());
    	dto.setFecha_registro(getFecha_registro());
    	return dto;
    }

}
