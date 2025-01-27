package cl.usm.tlp.frontend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.usm.tlp.frontend.dto.Estrategia_org_cargoDTO;
import cl.usm.tlp.frontend.service.IEstrategia_org_cargoService;

@Controller
@RequestMapping("cargo")
public class ControladorOrgCargo {

	@Autowired
	private IEstrategia_org_cargoService servicio;

	// http://localhost:8081/cargo/listar/REST
	@GetMapping("listar/REST")
	public String listarREST(Model model) {
		List<Estrategia_org_cargoDTO> cargo = servicio.findAllREST();
		model.addAttribute("cargos", cargo);
		return "rest/indexCargo";
	}

	// http://localhost:8081/cargo/listar/nuevo/REST
	@GetMapping("listar/nuevo/REST")
	public String agregarREST(Model model) {
		model.addAttribute("cargo", new Estrategia_org_cargoDTO());
		return "rest/formCargo";
	}

// http://localhost:8081/cargo/REST/id
	@GetMapping("editar/REST/{id}")
	public String editarREST(@PathVariable long id, Model model) {
		Estrategia_org_cargoDTO cargo = servicio.findByIdREST(id);
		model.addAttribute("cargo", cargo);
		return "rest/formCargo";
	}

	@PostMapping("grabar/REST")
	public String saveREST(@Valid Estrategia_org_cargoDTO p, Model model) {
	    servicio.saveREST(p);
	    return "redirect:/admin/cargo"; 
	}

	// http://localhost:8081/cargo/eliminar/id
	@GetMapping("eliminar/REST/{id}")
	public String deleteREST(@PathVariable long id, Model model) {
		servicio.deleteREST(id);
		return "redirect:/admin/cargo";
	}

}
