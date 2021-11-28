package com.murilonerdx.helpdesk.services.impl;

import com.murilonerdx.helpdesk.entities.Chamado;
import com.murilonerdx.helpdesk.entities.Cliente;
import com.murilonerdx.helpdesk.exception.ResourceNotFoundException;
import com.murilonerdx.helpdesk.repositories.ChamadoRepository;
import com.murilonerdx.helpdesk.repositories.ClienteRepository;
import com.murilonerdx.helpdesk.services.DAOService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChamadoServiceImpl implements DAOService<Chamado, Integer> {

    @Autowired
    private ChamadoRepository chamadoRepository;

    @Override
    public Chamado create(Chamado o) {
        return chamadoRepository.save(o);
    }

    @SneakyThrows
    @Override
    public Chamado findById(Integer id) {
        return chamadoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID " + id + " not found"));
    }

    @Override
    public List<Chamado> listAll() {
        return chamadoRepository.findAll();
    }

    @Override
    public void remove(Integer id) {
        chamadoRepository.deleteById(id);
    }

    @Override
    public Chamado update(Chamado o) {
        return chamadoRepository.save(o);
    }
}
