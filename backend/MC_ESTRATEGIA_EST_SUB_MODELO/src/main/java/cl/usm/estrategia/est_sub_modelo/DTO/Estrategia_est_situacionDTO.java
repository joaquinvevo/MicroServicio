package cl.usm.estrategia.est_sub_modelo.DTO;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class Estrategia_est_situacionDTO {
	
	@NotNull
	private Long id;
	
	@NotNull
	private Long est_submodelo_id;
	
	@NotNull
	private Long bsc_objetivo_id;
	
	@NotNull
	private Long est_impacto_id;
	
	@NotNull
	private Long est_importancia_id;
	
	@NotBlank
	private String nombre;
	
	@NotBlank
	private String alias;
	
	@NotBlank
	private String descripcion;
	
	@NotNull
	private int orden;
	
	@NotNull
	private boolean incluir;
	
	@NotNull
	private Date fecha_registro;
}
