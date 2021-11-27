package com.murilonerdx.helpdesk.repositories;

import com.murilonerdx.helpdesk.entities.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {

}
