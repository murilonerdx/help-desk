package com.murilonerdx.helpdesk.domain.repositories;

import com.murilonerdx.helpdesk.domain.entities.Chamado;
import com.murilonerdx.helpdesk.domain.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

}
