package com.micro.negocio.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.negocio.Entity.EstUrgenciaEntity;
import com.micro.negocio.Repository.EstUrgenciaRepository;

@Service
public class EstUrgenciaServiceImpl implements IEstUrgenciaService{
	
	@Autowired
	private EstUrgenciaRepository repo;
	
	@Override
	public List<EstUrgenciaEntity> findAll(){
		return repo.findAll();
	}
	
	@Override
	public Optional<EstUrgenciaEntity> findById(Long id){
		return repo.findById(id);
	}
	
	@Override
	public void save(EstUrgenciaEntity urgencia) {
		repo.save(urgencia);
	}
	
	@Override
	public void deleteById(Long id) {
		repo.deleteById(id);
	}
	
	@Override
	public EstUrgenciaEntity updateUrgencia(Long id, EstUrgenciaEntity urgencia) {
		return repo.findById(id).map(existingProyecto->{
			BeanUtils.copyProperties(urgencia, existingProyecto, "id", "fecha_registro");
			return repo.save(existingProyecto);
		}).orElse(null);
							
	}
}
