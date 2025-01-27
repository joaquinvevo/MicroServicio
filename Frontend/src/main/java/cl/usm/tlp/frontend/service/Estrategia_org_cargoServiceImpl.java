package cl.usm.tlp.frontend.service;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import cl.usm.tlp.frontend.dto.Estrategia_org_cargoDTO;

@Component
@Service
public class Estrategia_org_cargoServiceImpl implements IEstrategia_org_cargoService{
	
	@Override
    public List<Estrategia_org_cargoDTO> findAllREST() {
       
    	try {
			ObjectMapper unMapper = new ObjectMapper();

			List<Estrategia_org_cargoDTO> p = Arrays
					.asList(unMapper.readValue(new URL("http://localhost:8082/api/bff/estrategia_org_cargo/findall"), Estrategia_org_cargoDTO[].class));
			return p;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
    
    
    
    @Override
	public Estrategia_org_cargoDTO findByIdREST(Long id) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<Estrategia_org_cargoDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8082/api/bff/estrategia_org_cargo/findById" + "/" + id, Estrategia_org_cargoDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				Estrategia_org_cargoDTO dto = responseEntity.getBody();
				return dto;
			} else {
				System.out.println("A ocurrido un error");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
   
    @Override
    public Estrategia_org_cargoDTO saveREST(Estrategia_org_cargoDTO p) {
    	try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<Estrategia_org_cargoDTO> requestEntity = new HttpEntity<>(p, headers);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<Estrategia_org_cargoDTO> responseEntity = restTemplate.postForEntity("http://localhost:8082/api/bff/estrategia_org_cargo/create",
					requestEntity, Estrategia_org_cargoDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				Estrategia_org_cargoDTO dto = responseEntity.getBody();
				return dto;
			} else {
				System.out.println("A ocurrido un error");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }

    @Override
    public Estrategia_org_cargoDTO deleteREST(Long id) {
        // Make a REST call to delete the model
        String url = "http://localhost:8082/api/bff/estrategia_org_cargo/delete/" + id;
        try {
        	HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<Estrategia_org_cargoDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8082/api/bff/estrategia_org_cargo/findById/"+ "/" + id, Estrategia_org_cargoDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				Estrategia_org_cargoDTO dto = responseEntity.getBody();

				restTemplate.delete("http://localhost:8082/api/bff/estrategia_org_cargo/delete"+"/" + id);

				return dto;
			} else {
				System.out.println("A ocurrido un error");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
