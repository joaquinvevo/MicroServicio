package cl.usm.tlp.frontend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cl.usm.tlp.frontend.security.UserDetailsImpl;
import cl.usm.tlp.frontend.security.Usuario;
import cl.usm.tlp.frontend.security.UsuarioRepository;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UsuarioRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = repository.findOneByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("El usuario con email " + email + " no existe en BD"));
				
				return new UserDetailsImpl(usuario);
	}

}
