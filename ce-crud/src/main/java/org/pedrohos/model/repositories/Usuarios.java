package org.pedrohos.model.repositories;

import org.pedrohos.model.entities.impl.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Usuarios extends JpaRepository<Usuario, Long>{ 
	public Usuario findByNomeIgnoreCase(String nome);
}
