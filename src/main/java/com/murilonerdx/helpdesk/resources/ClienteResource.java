package com.murilonerdx.helpdesk.resources;


import com.murilonerdx.helpdesk.dto.ClienteDTO;
import com.murilonerdx.helpdesk.entities.Cliente;
import com.murilonerdx.helpdesk.entities.Tecnico;
import com.murilonerdx.helpdesk.enums.Perfil;
import com.murilonerdx.helpdesk.services.impl.ClienteServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

    @Autowired
    private ClienteServiceImpl service;

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable Integer id) {
        Cliente tec = service.findById(id);
        ClienteDTO clienteDTO = new ClienteDTO(tec);

        return ResponseEntity.ok().body(clienteDTO);
    }

    @PostMapping()
    public ResponseEntity<ClienteDTO> create(@RequestBody @Valid ClienteDTO clienteDTO) {

        Cliente cliente = new Cliente();

        clienteDTO.setId(null);
        clienteDTO.addPerfil(Perfil.CLIENTE);

        BeanUtils.copyProperties(clienteDTO, cliente);

        Cliente clienteSaved = service.create(cliente);
        ClienteDTO clienteDTOSaved = new ClienteDTO(clienteSaved);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(clienteSaved.getId()).toUri();
        return ResponseEntity.created(uri).body(clienteDTOSaved);
    }

    @GetMapping()
    public ResponseEntity<List<ClienteDTO>> findAll() {
        List<ClienteDTO> clientesDTO = service.listAll().stream().map(ClienteDTO::new).collect(Collectors.toList());

        return ResponseEntity.ok().body(clientesDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ClienteDTO> update(@RequestBody ClienteDTO clienteDTO, @PathVariable Integer id) {
        Cliente cliente = service.findById(id);

        cliente.setEmail(clienteDTO.getEmail());
        cliente.setNome(clienteDTO.getNome());

        Cliente clienteSaved = service.update(cliente);
        ClienteDTO clienteDTOSaved = new ClienteDTO(clienteSaved);

        return ResponseEntity.ok().body(clienteDTOSaved);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.remove(id);

        return ResponseEntity.noContent().build();
    }
}
