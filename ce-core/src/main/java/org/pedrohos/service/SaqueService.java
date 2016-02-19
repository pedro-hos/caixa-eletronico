package org.pedrohos.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;

import org.pedrohos.business.factory.NotaFactory;
import org.pedrohos.model.dto.NotaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaqueService {
	
	@Autowired
	private NotaFactory notaFactory;
	
	public Collection<NotaDTO> realizaCalculoDeNotas(BigInteger valor, Collection<String> celulasDisponiveisBean) {
		
		Collection<NotaDTO> notas = new ArrayList<NotaDTO>();
		NotaDTO nota = new NotaDTO();
		nota.setValorRestante(valor);
		
		for (String notaBean : celulasDisponiveisBean) {
			nota = notaFactory.getService(notaBean).calcula(nota.getValorRestante());
			notas.add(nota);
		}
		
		return notas;
	}

}
