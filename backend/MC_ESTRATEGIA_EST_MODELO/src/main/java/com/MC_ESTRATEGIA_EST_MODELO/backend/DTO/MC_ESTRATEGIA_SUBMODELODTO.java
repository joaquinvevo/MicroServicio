package com.MC_ESTRATEGIA_EST_MODELO.backend.DTO;

import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class MC_ESTRATEGIA_SUBMODELODTO {
	
    private Long id;
    
    
    private Long est_modelo_id;
    
    
    private String nombre;
    
    
    private String alias;
    
    
    private String descripcion;
    
    
    private int orden;
    
    
    private Date fecha_registro;
    
    
    
 

}
