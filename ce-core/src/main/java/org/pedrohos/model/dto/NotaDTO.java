package org.pedrohos.model.dto;

import java.math.BigInteger;

public class NotaDTO {
	
	private BigInteger nota;
	private BigInteger quantidade;
	private BigInteger valorRestante;
	
	public BigInteger getNota() {
		return nota;
	}

	public void setNota(BigInteger nota) {
		this.nota = nota;
	}

	public BigInteger getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigInteger quantidade) {
		this.quantidade = quantidade;
	}

	public BigInteger getValorRestante() {
		return valorRestante;
	}

	public void setValorRestante(BigInteger resto) {
		this.valorRestante = resto;
	}

}
