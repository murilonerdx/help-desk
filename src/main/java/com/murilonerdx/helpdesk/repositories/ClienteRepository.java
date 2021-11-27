package com.murilonerdx.helpdesk.repositories;

import com.murilonerdx.helpdesk.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
