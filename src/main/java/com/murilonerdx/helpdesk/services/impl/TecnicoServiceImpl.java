package com.murilonerdx.helpdesk.services.impl;

import com.murilonerdx.helpdesk.entities.Tecnico;
import com.murilonerdx.helpdesk.exception.ResourceNotFoundException;
import com.murilonerdx.helpdesk.repositories.TecnicoRepository;
import com.murilonerdx.helpdesk.services.DAOService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TecnicoServiceImpl implements DAOService<Tecnico, Integer> {

    @Autowired
    private TecnicoRepository repository;

    @Override
    public Tecnico create(Tecnico o) {
        return repository.save(o);
    }

    @SneakyThrows
    @Override
    public Tecnico findById(Integer id) {
        return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("ID " + id + " not found"));
    }

    @Override
    public List<Tecnico> listAll() {
        return repository.findAll();
    }

    @Override
    public void remote(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Tecnico update(Tecnico o) {
        return repository.save(o);
    }
}
