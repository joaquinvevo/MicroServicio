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

import cl.usm.tlp.frontend.dto.Estrategia_est_modeloDTO;
import cl.usm.tlp.frontend.dto.Estrategia_est_sub_modeloDTO;


@Component
@Service
public class Estrategia_est_sub_modeloServiceImpl implements IEstrategia_est_sub_modeloService {

    @Override
    public List<Estrategia_est_sub_modeloDTO> findAllREST() {
       
    	try {
			ObjectMapper unMapper = new ObjectMapper();

			List<Estrategia_est_sub_modeloDTO> p = Arrays
					.asList(unMapper.readValue(new URL("http://localhost:8082/api/bff/estrategia_est_sub_modelo/findall"), Estrategia_est_sub_modeloDTO[].class));
			return p;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
    
    
    
    @Override
	public Estrategia_est_sub_modeloDTO findByIdREST(Long id) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<Estrategia_est_sub_modeloDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8082/api/bff/estrategia_est_sub_modelo/findById" + "/" + id, Estrategia_est_sub_modeloDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				Estrategia_est_sub_modeloDTO dto = responseEntity.getBody();
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
    public Estrategia_est_sub_modeloDTO saveREST(Estrategia_est_sub_modeloDTO p) {
    	try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<Estrategia_est_sub_modeloDTO> requestEntity = new HttpEntity<>(p, headers);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<Estrategia_est_sub_modeloDTO> responseEntity = restTemplate.postForEntity("http://localhost:8082/api/bff/estrategia_est_sub_modelo/create",
					requestEntity, Estrategia_est_sub_modeloDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				Estrategia_est_sub_modeloDTO dto = responseEntity.getBody();
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
    public Estrategia_est_sub_modeloDTO deleteREST(Long id) {
        // Make a REST call to delete the model
        String url = "http://localhost:8082/api/bff/estrategia_est_sub_modelo/delete/" + id;
        try {
        	HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<Estrategia_est_sub_modeloDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8082/api/bff/estrategia_est_sub_modelo/findById/"+ "/" + id, Estrategia_est_sub_modeloDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				Estrategia_est_sub_modeloDTO dto = responseEntity.getBody();

				restTemplate.delete("http://localhost:8082/api/bff/estrategia_est_sub_modelo/delete"+"/" + id);

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