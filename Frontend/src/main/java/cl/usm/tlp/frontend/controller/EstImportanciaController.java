package cl.usm.tlp.frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.usm.tlp.frontend.dto.EstImportanciaDTO;
import cl.usm.tlp.frontend.service.IEstImportanciaService;


@Controller
@RequestMapping("importancia")
public class EstImportanciaController {
	
	@Autowired
	private IEstImportanciaService servicio;
	
	// Listar todas las situaciones
	@GetMapping("listar/REST")
	public String listarREST(Model model) {
		List<EstImportanciaDTO> importancia = servicio.findAllREST();
		model.addAttribute("importancia", importancia); 
		return "rest/indexMicronegocio";
	}

}
