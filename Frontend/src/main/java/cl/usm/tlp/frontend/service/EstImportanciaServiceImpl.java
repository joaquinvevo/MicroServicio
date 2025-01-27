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

import cl.usm.tlp.frontend.dto.EstImportanciaDTO;

@Component
@Service
public class EstImportanciaServiceImpl implements IEstImportanciaService {
	
	@Override
    public List<EstImportanciaDTO> findAllREST() {
       
    	try {
			ObjectMapper unMapper = new ObjectMapper();

			List<EstImportanciaDTO> p = Arrays
					.asList(unMapper.readValue(new URL("http://localhost:8082/api/bff/micronegocio/findallImportancia"), EstImportanciaDTO[].class));
			return p;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public EstImportanciaDTO findByIdREST(Long id) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<EstImportanciaDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8082/api/bff/micronegocio/findByIdImportancia" + "/" + id, EstImportanciaDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				EstImportanciaDTO dto = responseEntity.getBody();
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
    public EstImportanciaDTO saveREST(EstImportanciaDTO p) {
    	try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<EstImportanciaDTO> requestEntity = new HttpEntity<>(p, headers);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<EstImportanciaDTO> responseEntity = restTemplate.postForEntity("http://localhost:8082/api/bff/micronegocio/createImportancia",
					requestEntity, EstImportanciaDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				EstImportanciaDTO dto = responseEntity.getBody();
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
    public EstImportanciaDTO deleteREST(Long id) {
        // Make a REST call to delete the model
        String url = "http://localhost:8082/api/bff/micronegocio/deleteByIdImportancia/" + id;
        try {
        	HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<EstImportanciaDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8082/api/bff/micronegocio/findByIdImportancia/"+ "/" + id, EstImportanciaDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				EstImportanciaDTO dto = responseEntity.getBody();

				restTemplate.delete("http://localhost:8082/api/bff/micronegocio/deleteByIdImportancia"+"/" + id);

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
