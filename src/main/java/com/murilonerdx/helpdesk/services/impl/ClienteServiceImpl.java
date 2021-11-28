package com.murilonerdx.helpdesk.services.impl;

import com.murilonerdx.helpdesk.dto.TecnicoDTO;
import com.murilonerdx.helpdesk.entities.Cliente;
import com.murilonerdx.helpdesk.entities.Pessoa;
import com.murilonerdx.helpdesk.entities.Tecnico;
import com.murilonerdx.helpdesk.exception.ResourceNotFoundException;
import com.murilonerdx.helpdesk.repositories.ClienteRepository;
import com.murilonerdx.helpdesk.repositories.PessoaRepository;
import com.murilonerdx.helpdesk.repositories.TecnicoRepository;
import com.murilonerdx.helpdesk.services.DAOService;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements DAOService<Cliente, Integer> {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente create(Cliente o) {
        return clienteRepository.save(o);
    }

    @SneakyThrows
    @Override
    public Cliente findById(Integer id) {
        return clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID " + id + " not found"));
    }

    @Override
    public List<Cliente> listAll() {
        return clienteRepository.findAll();
    }

    @Override
    public void remove(Integer id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public Cliente update(Cliente o) {
        return clienteRepository.save(o);
    }

}
