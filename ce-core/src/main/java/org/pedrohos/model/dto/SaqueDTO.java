package org.pedrohos.model.dto;

import java.math.BigInteger;

public class SaqueDTO {
	
	private String nomeUsuario;
	private String nomeCaixaEletronico;
	private BigInteger valorASacar;
	
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getNomeCaixaEletronico() {
		return nomeCaixaEletronico;
	}
	public void setNomeCaixaEletronico(String nomeCaixaEletronico) {
		this.nomeCaixaEletronico = nomeCaixaEletronico;
	}
	public BigInteger getValorASacar() {
		return valorASacar;
	}
	public void setValorASacar(BigInteger valorASacar) {
		this.valorASacar = valorASacar;
	}
	
}
