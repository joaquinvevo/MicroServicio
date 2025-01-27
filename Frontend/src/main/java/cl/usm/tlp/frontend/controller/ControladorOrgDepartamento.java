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

import cl.usm.tlp.frontend.dto.Estrategia_org_departamentoDTO;
import cl.usm.tlp.frontend.service.IEstrategia_org_departamento;

@Controller
@RequestMapping("dpto")
public class ControladorOrgDepartamento {

	@Autowired
	private IEstrategia_org_departamento servicio;

	// http://localhost:8081/dpto/listar/REST
	@GetMapping("listar/REST")
	public String listarREST(Model model) {
		List<Estrategia_org_departamentoDTO> dpto = servicio.findAllREST();
		model.addAttribute("departamentos", dpto);
		return "rest/indexEstrategiaOrgDepartamento";
	}

	// http://localhost:8081/dpto/listar/nuevo/REST
	@GetMapping("listar/nuevo/REST")
	public String agregarREST(Model model) {
		model.addAttribute("dpto", new Estrategia_org_departamentoDTO());
		return "rest/formEstrategiaOrgDepartamento";
	}

// http://localhost:8081/dpto/REST/id
// Mostrar formulario para editar un dpto existente
	@GetMapping("editar/REST/{id}")
	public String editarREST(@PathVariable long id, Model model) {
	    Estrategia_org_departamentoDTO dpto = servicio.findByIdREST(id);
	    model.addAttribute("dpto", dpto);

	    // Obtener la lista de departamentos y agregarla al modelo
	    List<Estrategia_org_departamentoDTO> departamentos = servicio.findAllREST(); // Suponiendo que tienes un método para obtener todos los departamentos
	    model.addAttribute("departamentos", departamentos);

	    return "rest/formEstrategiaOrgDepartamento";
	}


	// Guardar un nuevo dpto o actualizar uno existente
	@PostMapping("grabar/REST")
	public String saveREST(@Valid Estrategia_org_departamentoDTO p, Model model) {
	    servicio.saveREST(p);
	    return "redirect:/admin/dpto";  // Redirige a la lista, no es necesario pasar 'dpto'
	}

	// http://localhost:8081/dpto/eliminar/id
	@GetMapping("eliminar/REST/{id}")
	public String deleteREST(@PathVariable long id, Model model) {
		servicio.deleteREST(id);
		return "redirect:/admin/dpto";
	}

}
