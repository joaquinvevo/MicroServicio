package com.MC_ESTRATEGIA_ORG_CARGO.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.MC_ESTRATEGIA_ORG_CARGO.DTO.Estrategia_org_cargoDTO;
import com.MC_ESTRATEGIA_ORG_CARGO.Service.IEstrategia_org_cargoService;

import jakarta.validation.Valid;
import lombok.NonNull;

@Controller
@RequestMapping("/estrategia_org_cargo")
public class Estrategia_org_cargoController {
	
	private IEstrategia_org_cargoService service;
	
    @Autowired
    public Estrategia_org_cargoController(IEstrategia_org_cargoService service) {
        this.service = service;
    }
    
	@ResponseBody
	@PostMapping("/create")
	public Estrategia_org_cargoDTO crearEstrategiaOrgCargo(@Valid @NonNull @RequestBody Estrategia_org_cargoDTO dto) {
		return service.save(dto);
	}
	
	@ResponseBody
    @GetMapping("/findall")
    public List<Estrategia_org_cargoDTO> findAll() {
        return service.findAll();
    }
    
    @ResponseBody
    @GetMapping("/findById/{id}")
    public Estrategia_org_cargoDTO findById(@PathVariable("id") int id) {
        Optional<Estrategia_org_cargoDTO> dtoOpt = service.findById(id);
        return dtoOpt.orElse(null); 
    }
    
    @ResponseBody
    @PutMapping("/update/{id}")
    public Estrategia_org_cargoDTO updateEstrategiaOrgCargo(@Valid @NonNull @RequestBody Estrategia_org_cargoDTO dto) {
        Optional<Estrategia_org_cargoDTO> oDto = service.findById(dto.getId());
        if (oDto.isPresent()) {
            return service.save(dto);
        } else {
            return null;  
        }
    }
    
    @ResponseBody
    @DeleteMapping("/delete/{id}")
    public boolean deleteEstrategiaOrgCargoById(@PathVariable("id") int id) {
        Optional<Estrategia_org_cargoDTO> oDto = service.findById(id);
        if (oDto.isPresent()) {
            service.delete(oDto.get());
            return true;
        } else {
            return false;
        }
    }
	
    @ResponseBody
    @GetMapping("findByEstCargoId/{estCargoId}")
    public List<Estrategia_org_cargoDTO> getOrgCargosByEstCargoId(@PathVariable("estCargoId") Long estCargoId) {
        return service.fk(estCargoId);
    }
    
    //@ResponseBody
    //@GetMapping("/search-org-cargo/{idEstOrgCargo}")
    //public ResponseEntity<?> findAllPersonasByIdEstOrgCargo(@PathVariable Long EstOrgcargoId){
    //   return ResponseEntity.ok(service.findAllPersonasByIdEstOrgCargo(EstOrgcargoId));
  //}

}
