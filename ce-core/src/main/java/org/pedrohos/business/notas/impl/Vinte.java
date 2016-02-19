package org.pedrohos.business.notas.impl;

import java.math.BigInteger;

import org.pedrohos.business.notas.NotaDefault;
import org.springframework.stereotype.Component;

@Component("20")
public class Vinte extends NotaDefault {

	@Override
	protected BigInteger getValorNota() {
		return new BigInteger("20");
	}

}
