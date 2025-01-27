package cl.usm.tlp.frontend.controller;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.usm.tlp.frontend.dto.BcsObjetivoDTO;
import cl.usm.tlp.frontend.dto.EstImpactoDTO;
import cl.usm.tlp.frontend.dto.EstImportanciaDTO;
import cl.usm.tlp.frontend.dto.EstSituacionDTO;
import cl.usm.tlp.frontend.dto.EstUrgenciaDTO;
import cl.usm.tlp.frontend.dto.Estrategia_est_modeloDTO;
import cl.usm.tlp.frontend.dto.Estrategia_est_sub_modeloDTO;
import cl.usm.tlp.frontend.dto.Estrategia_org_departamentoDTO;
import cl.usm.tlp.frontend.dto.Estrategia_org_cargoDTO;
import cl.usm.tlp.frontend.service.Estrategia_est_modeloService;
import cl.usm.tlp.frontend.service.IBcsObjetivoService;
import cl.usm.tlp.frontend.service.IEstImpactoService;
import cl.usm.tlp.frontend.service.IEstImportanciaService;
import cl.usm.tlp.frontend.service.IEstSituacionService;
import cl.usm.tlp.frontend.service.IEstUrgenciaService;
import cl.usm.tlp.frontend.service.IEstrategia_est_sub_modeloService;
import cl.usm.tlp.frontend.service.IEstrategia_org_departamento;
import cl.usm.tlp.frontend.service.IEstrategia_org_cargoService;


@Controller
@RequestMapping("admin")
public class AdminPageController {
	
	@Autowired
	private IEstrategia_org_departamento bddpto;
	@Autowired
	private Estrategia_est_modeloService bdmodelo;
	@Autowired
	private IEstrategia_est_sub_modeloService bdsubmodelo;
	@Autowired
	private IEstrategia_org_cargoService bdcargo;
	
	@Autowired
	private IEstSituacionService bdsituacion;
	
	@Autowired
	private IEstUrgenciaService bdurgencia;
	
	@Autowired
	private IEstImportanciaService bdimportancia;
	
	@Autowired
	private IEstImpactoService bdimpacto;
	
	@Autowired
	private IBcsObjetivoService bdobjetivo;

	
	@GetMapping("home")
	public String home(Model model) {
		return "AdminPage/starter";
	}
	
	///// DEPTO INICIO
		
	@GetMapping("/dpto")
	public String dpto(Model model) {
	    List<Estrategia_org_departamentoDTO> dptos = bddpto.findAllREST();
	    model.addAttribute("departamentos", dptos);
	    model.addAttribute("dpto", new Estrategia_org_departamentoDTO());
	    return "AdminPage/mantenedor_dpto";
	}
	
	// http://localhost:7777/admin/editar/dpto/(id}
	@GetMapping("editar/dpto/{id}")
	public String editarREST(@PathVariable long id, Model model) {
	    Estrategia_org_departamentoDTO dpto = bddpto.findByIdREST(id);
	    model.addAttribute("dpto", dpto);

	    // Obtener la lista de todos los departamentos
	    List<Estrategia_org_departamentoDTO> departamentos = bddpto.findAllREST(); // Asumiendo que tienes un método para obtener todos los departamentos
	    model.addAttribute("departamentos", departamentos);

	    return "AdminPage/editar_dpto"; // Asegúrate de que esto coincida con la ruta de tu plantilla
	}

	
	// http://localhost:7777/admin/eliminar/dpto/(id}
	@GetMapping("eliminar/dpto/{id}")
	public String deletedpto(@PathVariable Long id, Model model) {
	    bddpto.deleteREST(id);
	    return "redirect:/admin/dpto"; // Redirige después de eliminar
	}
	
	
	///// DEPTO FIN

///// MODELO INICIO
    // http://localhost:7777/admin/modelo
    @GetMapping("modelo")
    public String modelo(Model model) {
        List<Estrategia_est_modeloDTO> modelos = bdmodelo.findAllREST();  // Cambiado a findAllREST
        model.addAttribute("modelo", new Estrategia_est_modeloDTO());  
        model.addAttribute("modelos", modelos); 
        return "AdminPage/mantenedor_modelo";  
    }

    // http://localhost:7777/admin/editar/modelo/{id}
    @GetMapping("/editar/modelo/{id}")
    public String editarModelo(@PathVariable Long id, Model model) {
        Estrategia_est_modeloDTO modelo = bdmodelo.findByIdREST(id);  
        model.addAttribute("modelo", modelo);  
        return "AdminPage/editar_modelo";  
    }

    // http://localhost:7777/admin/eliminar/modelo/{id}
    @GetMapping("eliminar/modelo/{id}")
    public String deleteModelo(@PathVariable Long id, Model model) {
        bdmodelo.deleteREST(id);  
        return "redirect:/admin/modelo"; 
    }
    ///// MODELO FIN
    
        ///// SUBMODELO INICIO
    
	// http://localhost:7777/admin/persona
    @GetMapping("submodelo")
    public String submodelo(Model model) {
        List<Estrategia_est_sub_modeloDTO> submodelos = bdsubmodelo.findAllREST(); 
        List<Estrategia_est_modeloDTO> modelos = bdmodelo.findAllREST(); // Lista de modelos

        model.addAttribute("submodelo", new Estrategia_est_sub_modeloDTO());
        model.addAttribute("submodelos", submodelos);
        model.addAttribute("modelos", modelos); // Añade modelos para el combo box
        return "AdminPage/mantenedor_submodelo";
    }
	
	// http://localhost:7777/admin/editar/persona/(id}
    @GetMapping("editar/submodelo/{id}")
    public String editarsubmodelo(@PathVariable Long id, Model model) {
        Estrategia_est_sub_modeloDTO submodelo = bdsubmodelo.findByIdREST(id);
        List<Estrategia_est_modeloDTO> modelos = bdmodelo.findAllREST(); // Trae la lista de modelos

        model.addAttribute("submodelo", submodelo);
        model.addAttribute("modelos", modelos); // Añade la lista de modelos a la vista

        return "AdminPage/editar_submodelo";
    }

	
	// http://localhost:7777/admin/eliminar/persona/(id}
	@GetMapping("eliminar/submodelo/{id}")
	public String deletepersona(@PathVariable Long id, Model model) {
		bdsubmodelo.deleteREST(id);
		return "redirect:/admin/submodelo";
	}
	
	
	///// SUBMODELO FIN
	
    ///// CARGO INICIO
	
	// http://localhost:7777/admin/cargo
	@GetMapping("cargo")
	public String cargo(Model model) {
		List<Estrategia_org_cargoDTO> cargos = bdcargo.findAllREST();
		model.addAttribute("cargo", new Estrategia_org_cargoDTO());
		model.addAttribute("cargos", cargos);
		return "AdminPage/mantenedor_cargo";
	}
	
	// http://localhost:7777/admin/editar/cargo}
	@GetMapping("editar/cargo/{id}")
	public String editarcargo(@PathVariable Long id, Model model) {
    	Estrategia_org_cargoDTO cargo = bdcargo.findByIdREST(id);
    	List<Estrategia_org_cargoDTO> cargos = bdcargo.findAllREST(); // Lista completa de cargos
    
    	model.addAttribute("cargo", cargo);
    	model.addAttribute("cargos", cargos); // Añadir la lista de cargos para el combo box
    	return "AdminPage/editar_cargo";
	}

	
	// http://localhost:7777/admin/eliminar/cargo}
	@GetMapping("eliminar/cargo/{id}")
	public String deletecargo(@PathVariable Long id, Model model) {
		bdcargo.deleteREST(id);
		return "redirect:/admin/cargo";
	}


	
	///// CARGO FIN
	
	//// MICRONEGOCIO INICIO
	
	@GetMapping("micronegocio")
	public String micronegocio(Model model) {
		List<EstSituacionDTO> situaciones = bdsituacion.findAllREST();
		List<Estrategia_est_modeloDTO> modelos = bdmodelo.findAllREST();
		List<Estrategia_est_sub_modeloDTO> submodelos = bdsubmodelo.findAllREST();
		List<EstUrgenciaDTO> urgencias = bdurgencia.findAllREST();
		List<EstImportanciaDTO> importancias = bdimportancia.findAllREST();
		List<EstImpactoDTO> impactos = bdimpacto.findAllREST();
		List<BcsObjetivoDTO> objetivos = bdobjetivo.findAllREST();
		Map<Long, String> objetivoNombres = objetivos.stream()
				.collect(Collectors.toMap(BcsObjetivoDTO::getId, BcsObjetivoDTO::getNombre));
		
		model.addAttribute("situacion", new EstSituacionDTO());
		//model.addAttribute("urgencia", new EstUrgenciaDTO());
		//model.addAttribute("importancia", new EstImportanciaDTO());
		//model.addAttribute("impacto", new EstImpactoDTO());
		//model.addAttribute("objetivo", new BcsObjetivoDTO());
		model.addAttribute("situaciones", situaciones);
		model.addAttribute("objetivoNombres", objetivoNombres);
		model.addAttribute("submodelos", submodelos);
        model.addAttribute("modelos", modelos);
		model.addAttribute("urgencias", urgencias);
		model.addAttribute("importancias", importancias);
		model.addAttribute("impactos", impactos);
		model.addAttribute("objetivos", objetivos);
		return "AdminPage/mantenedor_micronegocio";
	}
	
	@GetMapping("editar/micronegocio/{id}")
	public String editarMicronegocio(@PathVariable Long id, Model model) {
		EstSituacionDTO situacion = bdsituacion.findByIdREST(id); 
		List<Estrategia_est_modeloDTO> modelos = bdmodelo.findAllREST();
		List<EstUrgenciaDTO> urgencias = bdurgencia.findAllREST();
		List<EstImportanciaDTO> importancias = bdimportancia.findAllREST();
		List<Estrategia_est_sub_modeloDTO> submodelos = bdsubmodelo.findAllREST();
		List<EstImpactoDTO> impactos = bdimpacto.findAllREST();
		List<BcsObjetivoDTO> objetivos = bdobjetivo.findAllREST(); 
		model.addAttribute("modelos", modelos);
		model.addAttribute("urgencias", urgencias);
		model.addAttribute("importancias", importancias);
		model.addAttribute("impactos", impactos);
		model.addAttribute("submodelos", submodelos);
		model.addAttribute("objetivos", objetivos);
		model.addAttribute("situacion", situacion);
		return "AdminPage/editar_micronegocio";
	}

	
	@GetMapping("eliminar/micronegocio/{id}")
	public String deleteMicronegocio(@PathVariable Long id, Model model) {
		bdsituacion.deleteREST(id);
		return "redirect:/admin/micronegocio";
	}
	
	
}