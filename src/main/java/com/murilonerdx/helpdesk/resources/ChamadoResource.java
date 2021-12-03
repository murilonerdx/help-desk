package com.murilonerdx.helpdesk.resources;


import com.murilonerdx.helpdesk.dto.ChamadoDTO;
import com.murilonerdx.helpdesk.entities.Chamado;
import com.murilonerdx.helpdesk.services.impl.ChamadoServiceImpl;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/chamados")
public class ChamadoResource {

    @Autowired
    private ChamadoServiceImpl chamadoService;

    @GetMapping("/{id}")
    public ResponseEntity<ChamadoDTO> findById(@PathVariable Integer id) {
        Chamado chamado = chamadoService.findById(id);

        ChamadoDTO chamadoDTO = new ChamadoDTO(chamado);
        return ResponseEntity.ok().body(chamadoDTO);
    }

    @PreAuthorize("hasAnyRole('CLIENTE')")
    @SneakyThrows
    @PostMapping()
    public ResponseEntity<ChamadoDTO> create(@RequestBody @Valid ChamadoDTO chamadoDTO) {


        Chamado chamadoSaved = chamadoService.create(chamadoDTO);
        ChamadoDTO chamadoDTOSaved = new ChamadoDTO(chamadoSaved);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(chamadoDTOSaved.getId()).toUri();
        return ResponseEntity.created(uri).body(chamadoDTOSaved);
    }

    @GetMapping()
    public ResponseEntity<List<ChamadoDTO>> findAll() {
        List<ChamadoDTO> chamadosDTO = chamadoService.listAll().stream().map(ChamadoDTO::new).collect(Collectors.toList());

        return ResponseEntity.ok().body(chamadosDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChamadoDTO> update(@RequestBody ChamadoDTO chamadoDTO, @PathVariable Integer id) {
        if(chamadoDTO.getStatus()==2){
            chamadoDTO.setDataFechamento(LocalDate.now());
        }
        Chamado chamadoUpdated = chamadoService.update(id, chamadoDTO);
        ChamadoDTO chamadoDTOUpdated = new ChamadoDTO(chamadoUpdated);

        return ResponseEntity.ok().body(chamadoDTOUpdated);
    }

    @PreAuthorize("hasAnyRole('TECNICO')" + " && " + "hasAnyRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        chamadoService.remove(id);

        return ResponseEntity.noContent().build();
    }
}
