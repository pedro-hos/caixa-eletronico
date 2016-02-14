package org.pedrohos.service;

import java.util.Collection;

import org.pedrohos.model.dto.CaixaEletronicoDTO;
import org.pedrohos.model.dto.NotaDTO;
import org.pedrohos.model.dto.SaqueDTO;
import org.pedrohos.model.dto.ValidationErrorDTO;
import org.pedrohos.model.exceptions.SaqueException;
import org.pedrohos.util.JsonConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class CaixaEletronicoService {

	@Value("${CE_CRUD_URL}")
	private String URL;
	
	public Collection<String> verificaSaldoEPegaNotasDisponiveis(SaqueDTO saqueDTO) {

		RestTemplate restTemplate = new RestTemplate();

		try {

			String URI = URL + "caixa-eletronico/" + saqueDTO.getNomeCaixaEletronico();
			CaixaEletronicoDTO caixaEletronico = restTemplate.getForObject(URI, CaixaEletronicoDTO.class);

			if (caixaEletronico.getSaldo().compareTo(saqueDTO.getValorASacar()) < 0) {
				throw new SaqueException("Caixa Eletrônico não possui saldo disponível. Saldo: " + caixaEletronico.getSaldo());
			}

			return caixaEletronico.pegaNotasDisponiveis();

		} catch (HttpClientErrorException e) {

			String message = JsonConverter.convert(e.getResponseBodyAsString(), ValidationErrorDTO.class)
					.getFieldErrors().get(0).getMessage();

			throw new SaqueException(message);
		}

	}

	public void sacar(Collection<NotaDTO> notas, String nomeCaixa) {

		RestTemplate restTemplate = new RestTemplate();

		try {

			restTemplate.put(URL + "caixa-eletronico/saque/" + nomeCaixa, notas);

		} catch (HttpClientErrorException e) {

			String message = JsonConverter.convert(e.getResponseBodyAsString(), ValidationErrorDTO.class)
										  .getFieldErrors().get(0)
										  .getMessage();

			throw new SaqueException(message);
		}

	}

}
