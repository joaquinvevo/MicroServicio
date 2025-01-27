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
public class BcsObjetivoDTO {
	
    private Long id; 

    @NotNull
    private Long bscTipoObjetivoId;

    @NotNull
    private Long bscTemaId; 
    
    @NotNull
    private Long orgDepartamentoIdResponsable; 
    
    @NotBlank
    private String nombre;

    @NotBlank
    private String alias;

    @NotBlank
    private String descripcion;

    @NotNull
    private Integer orden; 
    
    @NotBlank
    private String codigo;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private Date fechaRegistro; 
}
