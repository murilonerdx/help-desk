package com.murilonerdx.helpdesk.repositories;

import com.murilonerdx.helpdesk.entities.Pessoa;
import com.murilonerdx.helpdesk.entities.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {
    Optional<Tecnico> findByCpf(String cpf);

}
