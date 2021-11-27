package com.murilonerdx.helpdesk.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.murilonerdx.helpdesk.enums.Perfil;
import lombok.Data;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
public class ClienteDTO {
    private Integer id;
    private String nome;

    private String cpf;

    private String email;
    private String senha;

    private Set<Perfil> perfis = new HashSet<>();

    private LocalDate dataCriacao = LocalDate.now();
}
