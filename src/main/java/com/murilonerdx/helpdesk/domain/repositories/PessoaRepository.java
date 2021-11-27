package com.murilonerdx.helpdesk.domain.repositories;

import com.murilonerdx.helpdesk.domain.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
