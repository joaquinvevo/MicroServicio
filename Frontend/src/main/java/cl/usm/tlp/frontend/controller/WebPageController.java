package cl.usm.tlp.frontend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.usm.tlp.frontend.dto.UsuarioDTO;
import cl.usm.tlp.frontend.security.Usuario;
import cl.usm.tlp.frontend.service.UserServiceImpl;



@Controller
public class WebPageController {
	
	@Autowired
	private UserServiceImpl userService;
	
	// http://localhost:8081/persona/listar/REST
		@GetMapping("/ingresar")
		public String login() {
			return "WebPage/login";
		}
		
	// http://localhost:8081/persona/listar/REST
		@GetMapping("/registrarse")
		public String register() {
			return "WebPage/register";
		}
		
		@PostMapping("register")
	    public ResponseEntity<String> registerUser(@RequestBody UsuarioDTO userDto) {
	        if (!userDto.getPassword().equals(userDto.getConfirmPassword())) {
	            return ResponseEntity.badRequest().body("Las contraseñas no coinciden");
	        }
	        
	        String encryptedPassword = userService.encryptPassword(userDto.getPassword());
	        
	        Usuario user = new Usuario();
	        user.setNombre(userDto.getUsername());
	        user.setEmail(userDto.getEmail());
	        user.setPassword(encryptedPassword);
	        
	        userService.saveUser(user);

	        return ResponseEntity.ok("Usuario registrado exitosamente");

	    }
		
		@GetMapping("home")
		public String home(Model model) {
			return "AdminPage/starter";
		}
		


}