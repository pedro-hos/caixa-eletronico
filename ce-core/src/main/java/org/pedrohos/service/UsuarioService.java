package org.pedrohos.service;

import org.pedrohos.model.dto.SaqueDTO;
import org.pedrohos.model.dto.ValidationErrorDTO;
import org.pedrohos.model.exceptions.SaqueException;
import org.pedrohos.util.JsonConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class UsuarioService {
	
	
	public void verificaSaldoERealizaSaqueSePossivel(SaqueDTO saqueDTO) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		try {
			
			restTemplate.put("http://localhost:8080/usuario/saque/" + saqueDTO.getNomeUsuario(), saqueDTO);
			
		} catch (HttpClientErrorException e) {
			
			String message = JsonConverter.convert(e.getResponseBodyAsString(), ValidationErrorDTO.class )
										  .getFieldErrors().get(0)
										  .getMessage();
			
			throw new SaqueException(message);
		}
				
	}

}
