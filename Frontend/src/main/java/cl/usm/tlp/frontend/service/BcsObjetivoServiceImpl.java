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

import cl.usm.tlp.frontend.dto.BcsObjetivoDTO;

@Component
@Service
public class BcsObjetivoServiceImpl implements IBcsObjetivoService {
	
	@Override
    public List<BcsObjetivoDTO> findAllREST() {
       
    	try {
			ObjectMapper unMapper = new ObjectMapper();

			List<BcsObjetivoDTO> p = Arrays
					.asList(unMapper.readValue(new URL("http://localhost:8082/api/bff/micronegocio/findallObjetivo"), BcsObjetivoDTO[].class));
			return p;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public BcsObjetivoDTO findByIdREST(Long id) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<BcsObjetivoDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8082/api/bff/micronegocio/findByIdObjetivo" + "/" + id, BcsObjetivoDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				BcsObjetivoDTO dto = responseEntity.getBody();
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
    public BcsObjetivoDTO saveREST(BcsObjetivoDTO p) {
    	try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<BcsObjetivoDTO> requestEntity = new HttpEntity<>(p, headers);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<BcsObjetivoDTO> responseEntity = restTemplate.postForEntity("http://localhost:8082/api/bff/micronegocio/createObjetivo",
					requestEntity, BcsObjetivoDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				BcsObjetivoDTO dto = responseEntity.getBody();
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
    public BcsObjetivoDTO deleteREST(Long id) {
        // Make a REST call to delete the model
        String url = "http://localhost:8082/api/bff/micronegocio/deleteByIdObjetivo/" + id;
        try {
        	HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<BcsObjetivoDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8082/api/bff/micronegocio/findByIdObjetivo/"+ "/" + id, BcsObjetivoDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				BcsObjetivoDTO dto = responseEntity.getBody();

				restTemplate.delete("http://localhost:8082/api/bff/micronegocio/deleteByIdObjetivo"+"/" + id);

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
