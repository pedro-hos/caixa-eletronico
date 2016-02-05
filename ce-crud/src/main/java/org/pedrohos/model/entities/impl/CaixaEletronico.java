package org.pedrohos.model.entities.impl;

import java.math.BigInteger;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.pedrohos.model.entities.DefaultEntity;

@Entity
public class CaixaEletronico extends DefaultEntity {

	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "Nome do caixa eletrônico não pode ser vazio!")
	@Column(unique = true, nullable = false)
	private String nome;
	
	@OneToMany(mappedBy = "caixaEletronico", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Collection<Nota> notas;
	
	@NotNull(message = "Saldo não pode ser vazio!")
	@Min(value = 10, message = "Saldo deve ser no mínio de 10,00 reais")
	private BigInteger saldo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Collection<Nota> getNotas() {
		return notas;
	}

	public void setNotas(Collection<Nota> notas) {
		
		notas.forEach(n -> {
			n.setCaixaEletronico(this);
		});
		
		this.notas = notas;
	}

	public BigInteger getSaldo() {
		return saldo;
	}

	public void setSaldo(BigInteger saldo) {
		this.saldo = saldo;
	}
	
}
