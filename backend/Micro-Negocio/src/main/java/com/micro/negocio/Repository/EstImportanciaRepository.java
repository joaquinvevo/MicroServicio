package com.micro.negocio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.micro.negocio.Entity.EstImportanciaEntity;

@Repository
public interface EstImportanciaRepository extends JpaRepository<EstImportanciaEntity, Long> {

}
