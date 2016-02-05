package org.pedrohos.business.notas;

import java.math.BigInteger;

import org.pedrohos.model.dto.NotaDTO;

public abstract class NotaDefault {
	
	public NotaDTO calcula(BigInteger valor) {
		
		NotaDTO nota = new NotaDTO();
		nota.setNota(getValorNota());
		
		BigInteger quantidade = valor.divide(getValorNota());
		
		if( quantidade.compareTo(BigInteger.ONE) >= 0 ) {
			nota.setQuantidade(quantidade);
			nota.setValorRestante(valor.subtract(getValorNota().multiply(quantidade)));
		} else {
			nota.setQuantidade(BigInteger.ZERO);
			nota.setValorRestante(valor);
		}
		
		return nota;
	}
	
	protected abstract BigInteger getValorNota();

}
