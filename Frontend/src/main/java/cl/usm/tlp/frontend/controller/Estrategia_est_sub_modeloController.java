package cl.usm.tlp.frontend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cl.usm.tlp.frontend.dto.Estrategia_est_sub_modeloDTO;
import cl.usm.tlp.frontend.service.IEstrategia_est_sub_modeloService;

@Controller
@RequestMapping("submodelo")
public class Estrategia_est_sub_modeloController {

	@Autowired
	private IEstrategia_est_sub_modeloService servicio;
	
	// Listar todos los submodelos
	@GetMapping("listar/REST")
	public String listarREST(Model model) {
		List<Estrategia_est_sub_modeloDTO> submodelos = servicio.findAllREST();
		model.addAttribute("submodelos", submodelos); // Cambié de 'personas' a 'submodelos' para que coincida con el HTML
		return "rest/indexSubmodelo";
	}

	// Mostrar formulario para agregar un nuevo submodelo
	@GetMapping("listar/nuevo/REST")
	public String agregarREST(Model model) {
		model.addAttribute("submodelo", new Estrategia_est_sub_modeloDTO());
		return "rest/formSubmodelo";
	}

	// Mostrar formulario para editar un submodelo existente
	@GetMapping("editar/REST/{id}")
	public String editarREST(@PathVariable long id, Model model) {
		Estrategia_est_sub_modeloDTO submodelo = servicio.findByIdREST(id);
		model.addAttribute("submodelo", submodelo);
		return "rest/formSubmodelo";
	}


	// Guardar un nuevo submodelo o actualizar uno existente
	@PostMapping("grabar/REST")
	public String saveREST(@Validated Estrategia_est_sub_modeloDTO p, Model model) {
	    servicio.saveREST(p);
	    return "redirect:/admin/submodelo";  // Redirige a la lista, no es necesario pasar 'submodelo'
	}



	// Eliminar un submodelo
	@GetMapping("eliminar/REST/{id}")
	public String deleteREST(@PathVariable long id, Model model) {
		servicio.deleteREST(id);
		return "redirect:/admin/submodelo";  // Cambié la redirección para que sea coherente con las rutas del HTML
	}

}
