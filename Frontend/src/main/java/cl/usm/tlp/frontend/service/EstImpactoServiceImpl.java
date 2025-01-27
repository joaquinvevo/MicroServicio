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

import cl.usm.tlp.frontend.dto.EstImpactoDTO;

@Component
@Service
public class EstImpactoServiceImpl implements IEstImpactoService{
	
	@Override
    public List<EstImpactoDTO> findAllREST() {
       
    	try {
			ObjectMapper unMapper = new ObjectMapper();

			List<EstImpactoDTO> p = Arrays
					.asList(unMapper.readValue(new URL("http://localhost:8082/api/bff/micronegocio/findallImpacto"), EstImpactoDTO[].class));
			return p;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public EstImpactoDTO findByIdREST(Long id) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<EstImpactoDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8082/api/bff/micronegocio/findByIdImpacto" + "/" + id, EstImpactoDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				EstImpactoDTO dto = responseEntity.getBody();
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
    public EstImpactoDTO saveREST(EstImpactoDTO p) {
    	try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<EstImpactoDTO> requestEntity = new HttpEntity<>(p, headers);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<EstImpactoDTO> responseEntity = restTemplate.postForEntity("http://localhost:8082/api/bff/micronegocio/createImpacto",
					requestEntity, EstImpactoDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				EstImpactoDTO dto = responseEntity.getBody();
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
    public EstImpactoDTO deleteREST(Long id) {
        // Make a REST call to delete the model
        String url = "http://localhost:8082/api/bff/micronegocio/deleteByIdImpacto/" + id;
        try {
        	HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<EstImpactoDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8082/api/bff/micronegocio/findByIdImpacto/"+ "/" + id, EstImpactoDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				EstImpactoDTO dto = responseEntity.getBody();

				restTemplate.delete("http://localhost:8082/api/bff/micronegocio/deleteByIdImpacto"+"/" + id);

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
