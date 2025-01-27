package cl.usm.tlp.frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.usm.tlp.frontend.dto.EstImpactoDTO;
import cl.usm.tlp.frontend.service.IEstImpactoService;

@Controller
@RequestMapping("impacto")
public class EstImpactoController {
	
	@Autowired
	private IEstImpactoService servicio;
	
	// Listar todas las situaciones
	@GetMapping("listar/REST")
	public String listarREST(Model model) {
		List<EstImpactoDTO> impacto = servicio.findAllREST();
		model.addAttribute("impacto", impacto); 
		return "rest/indexMicronegocio";
	}
}
