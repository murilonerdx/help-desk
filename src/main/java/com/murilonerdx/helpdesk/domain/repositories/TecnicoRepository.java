package com.murilonerdx.helpdesk.domain.repositories;

import com.murilonerdx.helpdesk.domain.entities.Chamado;
import com.murilonerdx.helpdesk.domain.entities.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {

}
