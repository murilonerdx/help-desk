package com.murilonerdx.helpdesk.services.impl;

import com.murilonerdx.helpdesk.dto.ClienteDTO;
import com.murilonerdx.helpdesk.entities.Cliente;
import com.murilonerdx.helpdesk.exception.ResourceNotFoundException;
import com.murilonerdx.helpdesk.repositories.ClienteRepository;
import com.murilonerdx.helpdesk.services.DAOService;
import lombok.SneakyThrows;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements DAOService<Cliente, Integer, ClienteDTO> {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente create(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(clienteDTO, cliente);

        return clienteRepository.save(cliente);
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
    public Cliente update(Integer id,ClienteDTO clienteDTO) {
        Cliente cliente = clienteRepository.findById(id).get();

        cliente.setEmail(clienteDTO.getEmail());
        cliente.setNome(clienteDTO.getNome());

        return clienteRepository.save(cliente);
    }

}
