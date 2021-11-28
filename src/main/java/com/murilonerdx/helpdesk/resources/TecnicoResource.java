package com.murilonerdx.helpdesk.resources;


import com.murilonerdx.helpdesk.dto.TecnicoDTO;
import com.murilonerdx.helpdesk.entities.Tecnico;
import com.murilonerdx.helpdesk.services.impl.TecnicoServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tecnicos")
public class TecnicoResource {

    @Autowired
    private TecnicoServiceImpl service;

    @GetMapping("/{id}")
    public ResponseEntity<Tecnico> findById(@PathVariable Integer id) {
        Tecnico tec = service.findById(id);

        return ResponseEntity.ok().body(tec);
    }

    @PostMapping()
    public ResponseEntity<Tecnico> create(@RequestBody TecnicoDTO tecnicoDTO){
        Tecnico tecnico = new Tecnico(tecnicoDTO);

        Tecnico tecnicoSaved = service.create(tecnico);
        return ResponseEntity.ok().body(tecnicoSaved);
    }

    @GetMapping()
    public ResponseEntity<List<Tecnico>> findAll(){
        List<Tecnico> tecnicos = service.listAll();

        return ResponseEntity.ok().body(tecnicos);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Tecnico> update(@RequestBody TecnicoDTO tecnicoDTO, @PathVariable Integer id){
        Tecnico tecnico = service.findById(id);

        tecnico.setEmail(tecnicoDTO.getEmail());
        tecnico.setNome(tecnicoDTO.getNome());

        Tecnico tecnicoSaved = service.update(tecnico);
        return ResponseEntity.ok().body(tecnicoSaved);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id){
        service.remote(id);

        return ResponseEntity.noContent().build();
    }
}
