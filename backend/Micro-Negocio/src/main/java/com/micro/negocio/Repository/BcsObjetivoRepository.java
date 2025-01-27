package com.micro.negocio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.micro.negocio.Entity.BcsObjetivoEntity;

@Repository
public interface BcsObjetivoRepository extends JpaRepository<BcsObjetivoEntity, Long> {

}