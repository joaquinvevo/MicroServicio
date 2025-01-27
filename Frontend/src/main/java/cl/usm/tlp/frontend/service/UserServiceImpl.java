package cl.usm.tlp.frontend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import cl.usm.tlp.frontend.security.Usuario;
import cl.usm.tlp.frontend.security.UsuarioRepository;



@Component
@Service
public class UserServiceImpl {

    @Autowired
    private UsuarioRepository userRepository; // Repositorio para acceder a la base de datos

    @Autowired
    private PasswordEncoder passwordEncoder; // Para encriptar la contraseña

    public String encryptPassword(String password) {
        return passwordEncoder.encode(password);
    }

    public void saveUser(Usuario user) {
        userRepository.save(user);
    }
    
}
