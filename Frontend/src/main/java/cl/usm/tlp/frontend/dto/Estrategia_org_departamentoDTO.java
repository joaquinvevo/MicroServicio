package cl.usm.tlp.frontend.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;




import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
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
    
    @DateTimeFormat(pattern = "yyyy-MM-dd") // Establece el patrón que estás enviando
    @NotNull
    private Date fecha_registro;
}
