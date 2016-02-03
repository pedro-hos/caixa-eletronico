package org.pedrohos.model.entities.impl;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.pedrohos.model.entities.DefaultEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Nota extends DefaultEntity {
	
	private static final long serialVersionUID = 1L;
	
	private BigInteger nota;
	private BigInteger quantidade;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "caixa_eletronico_fk", nullable = false)
	private CaixaEletronico caixaEletronico;

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

	public CaixaEletronico getCaixaEletronico() {
		return caixaEletronico;
	}

	public void setCaixaEletronico(CaixaEletronico caixaEletronico) {
		this.caixaEletronico = caixaEletronico;
	}

}
