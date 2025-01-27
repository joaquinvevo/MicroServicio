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
    
    @DateTimeFormat(pattern = "yyyy-MM-dd") // Establece el patrón que estás enviando
    @NotNull
    private Date fecha_registro;
}