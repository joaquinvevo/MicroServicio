package cl.usm.estrategia.est_sub_modelo.Response;

import lombok.AllArgsConstructor;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

import cl.usm.estrategia.est_sub_modelo.DTO.*;

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

    private List<Estrategia_est_situacionDTO> ProyectoDTOList;

}
