package org.pedrohos.model.repositories;

import org.pedrohos.model.entities.impl.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Notas extends JpaRepository<Nota, Long> {

}
