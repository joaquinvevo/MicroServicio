package com.microservice.bff.DTO;

import lombok.AllArgsConstructor;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

import com.microservice.bff.DTO.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class situacionByIdEstSubmodeloId {
	
	private String nombre;
	
	private String alias;
	
	private String descripcion;
	
	private int orden;
	
	private Date fecha_registrada;

    private List<ProyectoDTOEstrategia_est_situacion> ProyectoDTOList;

}
