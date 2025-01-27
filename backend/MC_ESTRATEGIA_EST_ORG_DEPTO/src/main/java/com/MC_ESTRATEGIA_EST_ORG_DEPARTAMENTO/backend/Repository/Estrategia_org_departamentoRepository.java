package com.MC_ESTRATEGIA_EST_ORG_DEPARTAMENTO.backend.Repository;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.MC_ESTRATEGIA_EST_ORG_DEPARTAMENTO.backend.Entity.Estrategia_org_departamentoEntity;


@Repository
public interface Estrategia_org_departamentoRepository extends CrudRepository<Estrategia_org_departamentoEntity, Long>{
	@Query("SELECT e FROM Estrategia_org_departamentoEntity e WHERE e.org_departamento_id_padre = :org_departamento_id_padre")
	List<Estrategia_org_departamentoEntity> findSubDepartments(@Param("org_departamento_id_padre") Long org_departamento_id_padre);

}
