package cl.usm.tlp.frontend.service;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import cl.usm.tlp.frontend.dto.EstSituacionDTO;
import cl.usm.tlp.frontend.dto.Estrategia_est_sub_modeloDTO;

@Component
@Service
public class EstSituacionServiceImpl implements IEstSituacionService{
	
	@Override
    public List<EstSituacionDTO> findAllREST() {
       
    	try {
			ObjectMapper unMapper = new ObjectMapper();

			List<EstSituacionDTO> p = Arrays
					.asList(unMapper.readValue(new URL("http://localhost:8082/api/bff/micronegocio/findallSituacion"), EstSituacionDTO[].class));
			return p;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public EstSituacionDTO findByIdREST(Long id) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<EstSituacionDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8082/api/bff/micronegocio/findByIdSituacion" + "/" + id, EstSituacionDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				EstSituacionDTO dto = responseEntity.getBody();
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
    public EstSituacionDTO saveREST(EstSituacionDTO p) {
    	try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<EstSituacionDTO> requestEntity = new HttpEntity<>(p, headers);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<EstSituacionDTO> responseEntity = restTemplate.postForEntity("http://localhost:8082/api/bff/micronegocio/createSituacion",
					requestEntity, EstSituacionDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				EstSituacionDTO dto = responseEntity.getBody();
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
    public EstSituacionDTO deleteREST(Long id) {
        // Make a REST call to delete the model
        String url = "http://localhost:8082/api/bff/micronegocio/deleteByIdSituacion/" + id;
        try {
        	HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<EstSituacionDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8082/api/bff/micronegocio/findByIdSituacion/"+ "/" + id, EstSituacionDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				EstSituacionDTO dto = responseEntity.getBody();

				restTemplate.delete("http://localhost:8082/api/bff/micronegocio/deleteByIdSituacion"+"/" + id);

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
	public EstSituacionDTO updateREST(Long id, EstSituacionDTO p) {
	    try {
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        
	        // Crear el cuerpo de la solicitud con el objeto EstSituacionDTO y los headers
	        HttpEntity<EstSituacionDTO> requestEntity = new HttpEntity<>(p, headers);

	        RestTemplate restTemplate = new RestTemplate();
	        
	        // Realizar la solicitud PUT al endpoint con el ID
	        ResponseEntity<EstSituacionDTO> responseEntity = restTemplate.exchange(
	                "http://localhost:8082/api/bff/micronegocio/updateByIdSituacion/" + id,
	                HttpMethod.PUT,
	                requestEntity,
	                EstSituacionDTO.class
	        );

	        // Verificar si la respuesta fue exitosa (código HTTP 2xx)
	        if (responseEntity.getStatusCode().is2xxSuccessful()) {
	            return responseEntity.getBody();
	        } else {
	            System.out.println("Ocurrió un error durante la actualización.");
	            return null;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}



}
