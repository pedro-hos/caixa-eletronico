package org.pedrohos.business.notas.impl;

import java.math.BigInteger;

import org.pedrohos.business.notas.NotaDefault;
import org.springframework.stereotype.Component;

@Component("10")
public class Dez extends NotaDefault {

	@Override
	protected BigInteger getValorNota() {
		return BigInteger.TEN;
	}

}
