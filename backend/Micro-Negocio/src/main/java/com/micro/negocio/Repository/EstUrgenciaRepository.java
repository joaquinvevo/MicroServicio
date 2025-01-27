package com.micro.negocio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.micro.negocio.Entity.EstUrgenciaEntity;

@Repository
public interface EstUrgenciaRepository extends JpaRepository<EstUrgenciaEntity, Long> {

}