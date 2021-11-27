package com.murilonerdx.helpdesk.domain.repositories;

import com.murilonerdx.helpdesk.domain.entities.Chamado;
import com.murilonerdx.helpdesk.domain.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
