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

import cl.usm.tlp.frontend.dto.EstUrgenciaDTO;


@Component
@Service
public class EstUrgenciaServiceImpl implements IEstUrgenciaService{
	
	@Override
    public List<EstUrgenciaDTO> findAllREST() {
       
    	try {
			ObjectMapper unMapper = new ObjectMapper();

			List<EstUrgenciaDTO> p = Arrays
					.asList(unMapper.readValue(new URL("http://localhost:8082/api/bff/micronegocio/findallUrgencia"), EstUrgenciaDTO[].class));
			return p;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public EstUrgenciaDTO findByIdREST(Long id) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<EstUrgenciaDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8082/api/bff/micronegocio/findByIdUrgencia" + "/" + id, EstUrgenciaDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				EstUrgenciaDTO dto = responseEntity.getBody();
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
    public EstUrgenciaDTO saveREST(EstUrgenciaDTO p) {
    	try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<EstUrgenciaDTO> requestEntity = new HttpEntity<>(p, headers);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<EstUrgenciaDTO> responseEntity = restTemplate.postForEntity("http://localhost:8082/api/bff/micronegocio/createUrgencia",
					requestEntity, EstUrgenciaDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				EstUrgenciaDTO dto = responseEntity.getBody();
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
    public EstUrgenciaDTO deleteREST(Long id) {
        // Make a REST call to delete the model
        String url = "http://localhost:8082/api/bff/micronegocio/deleteByIdUrgencia/" + id;
        try {
        	HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<EstUrgenciaDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8082/api/bff/micronegocio/findByIdUrgencia/"+ "/" + id, EstUrgenciaDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				EstUrgenciaDTO dto = responseEntity.getBody();

				restTemplate.delete("http://localhost:8082/api/bff/micronegocio/deleteByIdUrgencia"+"/" + id);

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
