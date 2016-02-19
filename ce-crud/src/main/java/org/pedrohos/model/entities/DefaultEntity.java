package org.pedrohos.model.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIgnore;

@MappedSuperclass
public class DefaultEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;

	@JsonIgnore
	@Column(nullable = false)
	private boolean ativo = true;
	
	@JsonIgnore
	@Column(nullable = false)
	private LocalDate dataCriacao = LocalDate.now();

	public Long getId() {
		return id;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}
	
}
