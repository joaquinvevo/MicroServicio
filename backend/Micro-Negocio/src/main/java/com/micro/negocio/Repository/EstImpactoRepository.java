package com.micro.negocio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.micro.negocio.Entity.EstImpactoEntity;

@Repository
public interface EstImpactoRepository extends JpaRepository<EstImpactoEntity, Long> {

}
