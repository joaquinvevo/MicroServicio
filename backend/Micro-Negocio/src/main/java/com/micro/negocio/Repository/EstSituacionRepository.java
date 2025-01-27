package com.micro.negocio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.micro.negocio.Entity.EstSituacionEntity;


@Repository
public interface EstSituacionRepository extends JpaRepository<EstSituacionEntity, Long> {
	
}

