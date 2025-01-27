package cl.usm.tlp.frontend.dto;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EstSituacionDTO {
	
	private Long id;
	
	@NotNull
	private Long est_submodelo_id;
	
	@NotNull
	private Long bcs_objetivo_id;
	
	@NotNull
	private Long est_impacto_id;
	
	@NotNull
	private Long est_importancia_id;
	
	@NotNull
	private Integer relevancia;

	@NotBlank
	private String nombre;
	
	@NotBlank
	private String alias;
	
	@NotBlank
	private String descripcion;
	
	@NotNull
	private Integer orden;
	
	@NotNull
	private boolean incluir;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private Date fecha_registro;
	
	 
		
	


}

