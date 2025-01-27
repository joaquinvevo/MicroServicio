package com.micro.negocio.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.negocio.Entity.BcsObjetivoEntity;
import com.micro.negocio.Repository.BcsObjetivoRepository;

@Service
public class BcsObjetivoServiceImpl implements IBcsObjetivoService {

	@Autowired
	private BcsObjetivoRepository repo;
	
	@Override
	public List<BcsObjetivoEntity> findAll(){
		return repo.findAll();
	}
	
	@Override
	public Optional<BcsObjetivoEntity> findById(Long id){
		return repo.findById(id);
	}
	
	@Override
	public void save(BcsObjetivoEntity objetivo) {
		repo.save(objetivo);
	}
	
	@Override
	public void deleteById(Long id) {
		repo.deleteById(id);
	}
	
	@Override
	public BcsObjetivoEntity updateObjetivo(Long id, BcsObjetivoEntity objetivo) {
		return repo.findById(id).map(existingProyecto ->{
			BeanUtils.copyProperties(objetivo, existingProyecto, "id", "fecha_registro");
			return repo.save(existingProyecto);
		}).orElse(null);			
				
	}
}
