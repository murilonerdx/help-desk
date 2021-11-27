package com.murilonerdx.helpdesk.dto;

import com.murilonerdx.helpdesk.enums.Perfil;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
public class TecnicoDTO {
    private Integer id;
    private String nome;

    private String cpf;

    private String email;
    private String senha;

    private Set<Perfil> perfis = new HashSet<>();

    private LocalDate dataCriacao = LocalDate.now();
}
