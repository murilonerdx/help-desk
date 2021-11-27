package com.murilonerdx.helpdesk.domain.entity;

import com.murilonerdx.helpdesk.domain.enums.Perfil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Tecnico extends Pessoa{

    List<Chamado> chamados = new ArrayList<Chamado>();

    public Tecnico(Integer id, String nome, String cpf, String email, String senha, Set<Perfil> perfis, LocalDate dataCriacao, List<Chamado> chamados) {
        super(id, nome, cpf, email, senha, perfis, dataCriacao);
        this.chamados = chamados;
    }

    public Tecnico(List<Chamado> chamados) {
        this.chamados = chamados;
    }

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }
}
