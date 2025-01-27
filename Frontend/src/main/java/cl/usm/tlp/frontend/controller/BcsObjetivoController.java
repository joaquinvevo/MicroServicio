package cl.usm.tlp.frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.usm.tlp.frontend.dto.BcsObjetivoDTO;
import cl.usm.tlp.frontend.service.IBcsObjetivoService;



@Controller
@RequestMapping("objetivo")
public class BcsObjetivoController {
	
	@Autowired
	private IBcsObjetivoService servicio;
	
	// Listar todas las situaciones
	@GetMapping("listar/REST")
	public String listarREST(Model model) {
		List<BcsObjetivoDTO> objetivo = servicio.findAllREST();
		model.addAttribute("objetivo", objetivo); 
		return "rest/indexMicronegocio";
	}
}
