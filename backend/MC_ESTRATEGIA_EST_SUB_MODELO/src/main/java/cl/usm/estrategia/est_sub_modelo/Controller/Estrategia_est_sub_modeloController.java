package cl.usm.estrategia.est_sub_modelo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cl.usm.estrategia.est_sub_modelo.DTO.Estrategia_est_sub_modeloDTO;
import cl.usm.estrategia.est_sub_modelo.Service.IEstrategia_est_sub_modeloService;
import jakarta.validation.Valid;
import lombok.NonNull;

@Controller
@RequestMapping("estrategia_est_sub_modelo")

public class Estrategia_est_sub_modeloController {
	
	private final IEstrategia_est_sub_modeloService service;

    @Autowired
    public Estrategia_est_sub_modeloController(IEstrategia_est_sub_modeloService service) {
        this.service = service;
    }
	
	@ResponseBody
    @PostMapping("create")
    public Estrategia_est_sub_modeloDTO crearEstrategiaEstSubModelo(@Valid @NonNull @RequestBody Estrategia_est_sub_modeloDTO dto) {
        return service.save(dto);
    }
	
	@ResponseBody
    @GetMapping("findall")
    public List<Estrategia_est_sub_modeloDTO> findAll() {
        return service.findAll();
    }
    
    @ResponseBody
    @GetMapping("findById/{id}")
    public Estrategia_est_sub_modeloDTO findById(@PathVariable("id") Long id) {
        Optional<Estrategia_est_sub_modeloDTO> dtoOpt = service.findById(id);
        return dtoOpt.orElse(null);  // Devuelve null si el DTO no está presente
    }
    
    @ResponseBody
    @PutMapping("update")
    public ResponseEntity<Estrategia_est_sub_modeloDTO> updateEstrategiaEstSubModelo(@Valid @NonNull @RequestBody Estrategia_est_sub_modeloDTO dto) {
        Optional<Estrategia_est_sub_modeloDTO> existingDto = service.findById(dto.getId());
        if (existingDto.isPresent()) {
            Estrategia_est_sub_modeloDTO updatedDto = service.save(dto);
            return new ResponseEntity<>(updatedDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // 404 si el ID no existe
        }
    }
    
    @ResponseBody
    @DeleteMapping("delete/{id}")
    public boolean deleteEstrategiaEstSubModeloById(@PathVariable("id") Long id) {
        Optional<Estrategia_est_sub_modeloDTO> oDto = service.findById(id);
        if (oDto.isPresent()) {
            service.delete(oDto.get());
            return true;
        } else {
            return false;
        }
    }
    
    @ResponseBody
    @GetMapping("findByEstModeloId/{estModeloId}")
    public List<Estrategia_est_sub_modeloDTO> getSubModelosByEstModeloId(@PathVariable("estModeloId") Long estModeloId) {
        return service.fk(estModeloId);
    }
    
    //@ResponseBody
    //@GetMapping("/search-sub-modelo/{idEstSubModelo}")
    //public ResponseEntity<?> findAllSituacionesByIdEstSubModelo(@PathVariable Long EstSubmodeloId){
    //   return ResponseEntity.ok(service.findAllSituacionesByIdEstSubModelo(EstSubmodeloId));
  //}
    
}
