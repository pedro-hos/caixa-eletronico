package org.pedrohos.model.repositories;

import org.pedrohos.model.entities.impl.CaixaEletronico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaixasEletronico extends JpaRepository<CaixaEletronico, Long> {

	public CaixaEletronico findByNomeIgnoreCase(String nome); 
	
}
