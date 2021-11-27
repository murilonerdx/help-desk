package com.murilonerdx.helpdesk.domain.entity;

import com.murilonerdx.helpdesk.domain.enums.Perfil;
import lombok.AllArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Cliente extends Pessoa implements Serializable {

    @OneToMany(mappedBy="cliente")
    private List<Chamado> chamados = new ArrayList<>();

    public Cliente(Integer id, String nome, String cpf, String email, String senha, Set<Perfil> perfis, LocalDate dataCriacao, List<Chamado> chamados) {
        super(id, nome, cpf, email, senha, perfis, dataCriacao);
        this.chamados = chamados;
    }

    public Cliente() {
        super();
        addPerfil(Perfil.CLIENTE);
    }

    public Cliente(List<Chamado> chamados) {
        this.chamados = chamados;
    }

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }
}
