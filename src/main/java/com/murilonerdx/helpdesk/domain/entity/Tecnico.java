package com.murilonerdx.helpdesk.domain.entity;

import com.murilonerdx.helpdesk.domain.enums.Perfil;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Tecnico extends Pessoa implements Serializable {

    @OneToMany(mappedBy="tecnico")
    List<Chamado> chamados = new ArrayList<Chamado>();

    public Tecnico(Integer id, String nome, String cpf, String email, String senha, Set<Perfil> perfis, LocalDate dataCriacao, List<Chamado> chamados) {
        super(id, nome, cpf, email, senha, perfis, dataCriacao);
        this.chamados = chamados;
    }

    public Tecnico() {
        super();
        addPerfil(Perfil.TECNICO);
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
