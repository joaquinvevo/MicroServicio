package cl.usm.tlp.frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.usm.tlp.frontend.dto.EstSituacionDTO;
import cl.usm.tlp.frontend.service.IEstSituacionService;

@Controller
@RequestMapping("situacion")
public class EstSituacionController {
	
	@Autowired
	private IEstSituacionService servicio;
	
	// Listar todas las situaciones
		@GetMapping("listar/REST")
		public String listarREST(Model model) {
			List<EstSituacionDTO> situacion = servicio.findAllREST();
			model.addAttribute("situacion", situacion); 
			return "rest/indexMicronegocio";
		}

		// Mostrar formulario para agregar una nueva situacion
		@GetMapping("listar/nuevo/REST")
		public String agregarREST(Model model) {
			model.addAttribute("situacion", new EstSituacionDTO());
			return "rest/formMicronegocio";
		}

		// Mostrar formulario para editar una situacion existente
		@GetMapping("editar/REST/{id}")
		public String editarREST(@PathVariable long id, Model model) {
			EstSituacionDTO situacion = servicio.findByIdREST(id);
			model.addAttribute("situacion", situacion);
			return "rest/formMicronegocio";
		}


		// Guardar una nueva situacion o actualizar una existente
		@PostMapping("grabar/REST")
		public String saveREST(@Validated EstSituacionDTO p, Model model) {
		    servicio.saveREST(p);
		    return "redirect:/admin/micronegocio";  
		}



		// Eliminar una situacion
		@GetMapping("eliminar/REST/{id}")
		public String deleteREST(@PathVariable long id, Model model) {
			servicio.deleteREST(id);
			return "redirect:/situacion/listar/rest";  // Cambié la redirección para que sea coherente con las rutas del HTML
		}

}