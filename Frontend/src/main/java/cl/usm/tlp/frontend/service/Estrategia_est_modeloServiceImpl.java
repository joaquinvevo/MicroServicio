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


@Component
@Service
public class Estrategia_est_modeloServiceImpl implements Estrategia_est_modeloService {

	

   // @Override
    //public ModeloByIdTipo findAllModeloByIdTipo(Long estModeloId) {
      // /  Make a REST call to the backend service to get the model details and submodels
        //String url = "http://localhost:8082/api/bff/estrategia_est_modelo/find" + estModeloId;

        //ResponseEntity<ModeloByIdTipo> responseEntity = restTemplate.getForEntity(url, ModeloByIdTipo.class);
        //if (responseEntity.getStatusCode().is2xxSuccessful()) {
           // return responseEntity.getBody();
        //} else {
          //  System.out.println("Error fetching data");
           // return null;
        //}
    //}
//////
    @Override
    public List<Estrategia_est_modeloDTO> findAllREST() {
       
    	try {
			ObjectMapper unMapper = new ObjectMapper();

			List<Estrategia_est_modeloDTO> p = Arrays
					.asList(unMapper.readValue(new URL("http://localhost:8082/api/bff/estrategia_est_modelo/findall"), Estrategia_est_modeloDTO[].class));
			return p;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
    
    
    
    @Override
	public Estrategia_est_modeloDTO findByIdREST(Long id) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<Estrategia_est_modeloDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8082/api/bff/estrategia_est_modelo/findById" + "/" + id, Estrategia_est_modeloDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				Estrategia_est_modeloDTO dto = responseEntity.getBody();
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
    public Estrategia_est_modeloDTO saveREST(Estrategia_est_modeloDTO j) {
    	try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<Estrategia_est_modeloDTO> requestEntity = new HttpEntity<>(j, headers);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<Estrategia_est_modeloDTO> responseEntity = restTemplate.postForEntity("http://localhost:8082/api/bff/estrategia_est_modelo/create",
					requestEntity, Estrategia_est_modeloDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				Estrategia_est_modeloDTO dto = responseEntity.getBody();
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
    public Estrategia_est_modeloDTO deleteREST(Long id) {
        // Make a REST call to delete the model
        String url = "http://localhost:8082/api/bff/estrategia_est_modelo/delete/" + id;
        try {
        	HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<Estrategia_est_modeloDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8082/api/bff/estrategia_est_modelo/findById/"+ "/" + id, Estrategia_est_modeloDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				Estrategia_est_modeloDTO dto = responseEntity.getBody();

				restTemplate.delete("http://localhost:8082/api/bff/estrategia_est_modelo/delete"+"/" + id);

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