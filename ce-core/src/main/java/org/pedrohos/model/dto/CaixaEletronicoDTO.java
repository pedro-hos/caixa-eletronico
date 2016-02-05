package org.pedrohos.model.dto;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;

public class CaixaEletronicoDTO {

	private String nome;
	private Collection<NotaDTO> notas;
	private BigInteger saldo;

	public Collection<NotaDTO> getNotas() {
		return notas;
	}

	public void setNotas(Collection<NotaDTO> notas) {
		this.notas = notas;
	}

	public BigInteger getSaldo() {
		return saldo;
	}

	public void setSaldo(BigInteger saldo) {
		this.saldo = saldo;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Collection<String> pegaNotasDisponiveis() {
		
		Collection<String> notasDisponiveis = new ArrayList<String>();
		
		notas.forEach(n -> {
			
			if(n.getQuantidade().compareTo(BigInteger.ZERO) != 0) {
				notasDisponiveis.add(n.getNota().toString());
			}
			
		});
		
		return notasDisponiveis;
	}

}
