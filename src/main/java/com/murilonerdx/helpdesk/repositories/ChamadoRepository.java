package com.murilonerdx.helpdesk.repositories;

import com.murilonerdx.helpdesk.entities.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

}
