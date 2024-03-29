package com.murilonerdx.helpdesk.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.murilonerdx.helpdesk.dto.ClienteDTO;
import com.murilonerdx.helpdesk.dto.TecnicoDTO;
import com.murilonerdx.helpdesk.enums.Perfil;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
public class Cliente extends Pessoa implements Serializable {

    @JsonIgnore
    @OneToMany(mappedBy= "cliente",cascade = CascadeType.ALL)
    private List<Chamado> chamados = new ArrayList<>();

    public Cliente() {
        super();
        addPerfil(Perfil.CLIENTE);
    }

    public Cliente(Integer id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
        addPerfil(Perfil.CLIENTE);
    }

    public Cliente(ClienteDTO obj) {
        super(obj.getId(),
                obj.getNome(),
                obj.getCpf(),
                obj.getEmail(),
                obj.getSenha());

    }

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(chamados, cliente.chamados);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), chamados);
    }
}
