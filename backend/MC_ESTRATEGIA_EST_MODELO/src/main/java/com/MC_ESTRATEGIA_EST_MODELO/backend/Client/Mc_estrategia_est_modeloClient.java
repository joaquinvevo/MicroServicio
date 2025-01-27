package com.MC_ESTRATEGIA_EST_MODELO.backend.Client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.MC_ESTRATEGIA_EST_MODELO.backend.DTO.MC_ESTRATEGIA_SUBMODELODTO;




@FeignClient(name = "mnEstrategiaEstSubModelo")
public interface Mc_estrategia_est_modeloClient {
    @GetMapping("estrategia_est_sub_modelo/findByEstModeloId/{estModeloId}")
    List<MC_ESTRATEGIA_SUBMODELODTO> findAllModeloByIdTipo(@PathVariable Long estModeloId);
}

