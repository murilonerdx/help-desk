package com.murilonerdx.helpdesk.resources;


import com.murilonerdx.helpdesk.dto.TecnicoDTO;
import com.murilonerdx.helpdesk.entities.Tecnico;
import com.murilonerdx.helpdesk.enums.Perfil;
import com.murilonerdx.helpdesk.services.impl.TecnicoServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tecnicos")
public class TecnicoResource {

    @Autowired
    private TecnicoServiceImpl service;

    @GetMapping("/{id}")
    public ResponseEntity<TecnicoDTO> findById(@PathVariable Integer id) {
        Tecnico tec = service.findById(id);

        TecnicoDTO tecnicoDTO = new TecnicoDTO(tec);
        return ResponseEntity.ok().body(tecnicoDTO);
    }

    @PostMapping()
    public ResponseEntity<TecnicoDTO> create(@RequestBody @Valid TecnicoDTO tecnicoDTO) {
        Tecnico tecnicoSaved = service.create(tecnicoDTO);
        TecnicoDTO tecnicoDTOSave = new TecnicoDTO(tecnicoSaved);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(tecnicoSaved.getId()).toUri();
        return ResponseEntity.created(uri).body(tecnicoDTOSave);
    }

    @GetMapping()
    public ResponseEntity<List<TecnicoDTO>> findAll() {
        List<TecnicoDTO> tecnicosDTO = service.listAll().stream().map(TecnicoDTO::new).collect(Collectors.toList());

        return ResponseEntity.ok().body(tecnicosDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TecnicoDTO> update(@RequestBody TecnicoDTO tecnicoDTO, @PathVariable Integer id) {
        Tecnico tecnicoSaved = service.update(id, tecnicoDTO);
        TecnicoDTO tecnicoDTOSaved = new TecnicoDTO(tecnicoSaved);

        return ResponseEntity.ok().body(tecnicoDTOSaved);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.remove(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<TecnicoDTO> findByCpf(@PathVariable String cpf) {

        Tecnico tecnico = service.findByCpf(cpf);
        TecnicoDTO tecnicoDTO = new TecnicoDTO(tecnico);

        return ResponseEntity.ok().body(tecnicoDTO);
    }
}
