package cl.usm.tlp.frontend.security;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository <Usuario,Integer>{

	public Optional<Usuario> findOneByEmail(String email);
}