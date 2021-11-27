package com.murilonerdx.helpdesk.repositories;

import com.murilonerdx.helpdesk.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
