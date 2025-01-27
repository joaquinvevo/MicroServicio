package cl.usm.tlp.frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.usm.tlp.frontend.dto.EstUrgenciaDTO;
import cl.usm.tlp.frontend.service.IEstUrgenciaService;

@Controller
@RequestMapping("urgencia")
public class EstUrgenciaController {
	
	@Autowired
	private IEstUrgenciaService servicio;
	
	// Listar todas las situaciones
	@GetMapping("listar/REST")
	public String listarREST(Model model) {
		List<EstUrgenciaDTO> urgencia = servicio.findAllREST();
		model.addAttribute("urgencia", urgencia); 
		return "rest/indexMicronegocio";
	}
}
