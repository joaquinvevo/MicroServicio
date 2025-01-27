package cl.usm.tlp.frontend.service;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import cl.usm.tlp.frontend.dto.Estrategia_org_departamentoDTO;



@Service
public class Estrategia_org_departamentoServiceImpls implements IEstrategia_org_departamento {
	
	
	@Override
	public List<Estrategia_org_departamentoDTO> findAllREST() {
		try {
			ObjectMapper unMapper = new ObjectMapper();

			List<Estrategia_org_departamentoDTO> dpto = Arrays
					.asList(unMapper.readValue(new URL("http://localhost:8082/api/bff/estrategia_org_departamento/findall"), Estrategia_org_departamentoDTO[].class));
			return dpto;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Estrategia_org_departamentoDTO findByIdREST(Long id) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<Estrategia_org_departamentoDTO> responseEntity = restTemplate
				    .getForEntity("http://localhost:8082/api/bff/estrategia_org_departamento/findById/" + id, Estrategia_org_departamentoDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				Estrategia_org_departamentoDTO dto = responseEntity.getBody();
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
	public Estrategia_org_departamentoDTO saveREST(Estrategia_org_departamentoDTO p) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<Estrategia_org_departamentoDTO> requestEntity = new HttpEntity<>(p, headers);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<Estrategia_org_departamentoDTO> responseEntity = restTemplate.postForEntity("http://localhost:8082/api/bff/estrategia_org_departamento/create",
					requestEntity, Estrategia_org_departamentoDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				Estrategia_org_departamentoDTO dto = responseEntity.getBody();
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
	public Estrategia_org_departamentoDTO deleteREST(Long id) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<Estrategia_org_departamentoDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8082/api/bff/estrategia_org_departamento/findById/"+ "/" + id, Estrategia_org_departamentoDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				Estrategia_org_departamentoDTO dto = responseEntity.getBody();

				restTemplate.delete("http://localhost:8082/api/bff/estrategia_org_departamento/delete"+"/" + id);

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