package cl.usm.estrategia.est_sub_modelo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import cl.usm.estrategia.est_sub_modelo.DTO.Estrategia_est_sub_modeloDTO;


import cl.usm.estrategia.est_sub_modelo.Entity.Estrategia_est_sub_modeloEntity;

@Repository
public interface Estrategia_est_sub_modeloRepository extends CrudRepository<Estrategia_est_sub_modeloEntity, Long>{
	@Query("SELECT e FROM Estrategia_est_sub_modeloEntity e WHERE e.est_modelo_id = :est_modelo_id")
    List<Estrategia_est_sub_modeloEntity> findByEstModeloId(@Param("est_modelo_id") Long est_modelo_id);
	
}
