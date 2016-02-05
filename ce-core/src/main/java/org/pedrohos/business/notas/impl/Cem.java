package org.pedrohos.business.notas.impl;

import java.math.BigInteger;

import org.pedrohos.business.notas.NotaDefault;
import org.springframework.stereotype.Component;

@Component("100")
public class Cem extends NotaDefault {

	@Override
	protected BigInteger getValorNota() {
		return new BigInteger("100");
	}

}
