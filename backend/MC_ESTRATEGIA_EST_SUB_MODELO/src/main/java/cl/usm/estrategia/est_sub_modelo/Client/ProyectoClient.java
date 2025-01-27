package cl.usm.estrategia.est_sub_modelo.Client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cl.usm.estrategia.est_sub_modelo.DTO.Estrategia_est_situacionDTO;

//@FeignClient(name = "")
public interface ProyectoClient {
	
	//@GetMapping("")
    //List<Estrategia_est_situacionDTO> findAllSituacionesByIdEstSubModelo(@PathVariable Long EstSubmodeloId);
}