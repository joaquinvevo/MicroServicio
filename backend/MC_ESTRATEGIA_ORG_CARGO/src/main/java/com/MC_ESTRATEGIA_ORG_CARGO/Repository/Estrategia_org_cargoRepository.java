package com.MC_ESTRATEGIA_ORG_CARGO.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.MC_ESTRATEGIA_ORG_CARGO.Entity.Estrategia_org_cargoEntity;

@Repository
public interface Estrategia_org_cargoRepository extends CrudRepository<Estrategia_org_cargoEntity, Integer> {
	@Query("SELECT e FROM Estrategia_org_cargoEntity e WHERE e.est_persona_cargo_id = :est_persona_cargo_id")
    List<Estrategia_org_cargoEntity> findByPersonaCargoId(@Param("est_persona_cargo_id") Long est_persona_cargo_id);
}
