package com.MC_ESTRATEGIA_EST_MODELO.backend.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

import com.MC_ESTRATEGIA_EST_MODELO.backend.Entity.Mc_estrategia_est_modelo;

@Repository
public interface Mc_estrategia_est_modeloRepository extends CrudRepository<Mc_estrategia_est_modelo, Integer> {

    Optional<Mc_estrategia_est_modelo> findById(Long id);
    
    
}