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

import cl.usm.tlp.frontend.dto.Estrategia_est_modeloDTO;
import cl.usm.tlp.frontend.service.Estrategia_est_modeloService;

@Controller
@RequestMapping("modelo")
public class ControladorModelo {

	@Autowired
    private Estrategia_est_modeloService servicio;

	
		@GetMapping("listar/REST")
		public String listarREST(Model model) {
			List<Estrategia_est_modeloDTO> modelos = servicio.findAllREST();
			model.addAttribute("modelos", modelos); 
			return "rest/indexModelo";
		}

		
		@GetMapping("listar/nuevo/REST")
		public String agregarREST(Model model) {
			model.addAttribute("modelo", new Estrategia_est_modeloDTO());
			return "rest/formModelo";
		}

		
		@GetMapping("editar/REST/{id}")
		public String editarREST(@PathVariable long id, Model model) {
			Estrategia_est_modeloDTO modelo = servicio.findByIdREST(id);
			model.addAttribute("modelo", modelo);
			return "rest/formModelo";
		}


		
		@PostMapping("grabar/REST")
		public String saveREST(@Validated Estrategia_est_modeloDTO p, Model model) {
		    servicio.saveREST(p);
		    return "redirect:/admin/modelo";  
		}



		
		@GetMapping("eliminar/REST/{id}")
		public String deleteREST(@PathVariable long id, Model model) {
			servicio.deleteREST(id);
			return "redirect:/admin/modelo";   
		}
}
