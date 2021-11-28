package com.murilonerdx.helpdesk.services.impl;

import com.murilonerdx.helpdesk.dto.TecnicoDTO;
import com.murilonerdx.helpdesk.entities.Pessoa;
import com.murilonerdx.helpdesk.entities.Tecnico;
import com.murilonerdx.helpdesk.enums.Perfil;
import com.murilonerdx.helpdesk.exception.ResourceNotFoundException;
import com.murilonerdx.helpdesk.repositories.PessoaRepository;
import com.murilonerdx.helpdesk.repositories.TecnicoRepository;
import com.murilonerdx.helpdesk.services.DAOService;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoServiceImpl implements DAOService<Tecnico, Integer, TecnicoDTO> {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public Tecnico create(TecnicoDTO tecnicoDTO) {
        validarCpf(tecnicoDTO);
        Tecnico tecnico = new Tecnico();

        tecnicoDTO.setId(null);
        tecnicoDTO.addPerfil(Perfil.CLIENTE);

        BeanUtils.copyProperties(tecnicoDTO, tecnico);

        return tecnicoRepository.save(tecnico);
    }

    @SneakyThrows
    @Override
    public Tecnico findById(Integer id) {
        return tecnicoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID " + id + " not found"));
    }

    @Override
    public List<Tecnico> listAll() {
        return tecnicoRepository.findAll();
    }

    @Override
    public void remove(Integer id) {
        tecnicoRepository.deleteById(id);
    }

    @Override
    public Tecnico update(Integer id, TecnicoDTO tecnicoDTO) {
        Tecnico tecnico = tecnicoRepository.findById(id).get();

        tecnico.setEmail(tecnicoDTO.getEmail());
        tecnico.setNome(tecnicoDTO.getNome());

        return tecnicoRepository.save(tecnico);
    }

    public Tecnico findByCpf(String cpf) {
        return tecnicoRepository.findByCpf(cpf).orElseThrow(() -> new DataIntegrityViolationException("CPF não encontrado"));
    }

    public void validarCpf(TecnicoDTO tecnicoDTO) {
        Optional<Pessoa> obj = pessoaRepository.findByCpf(tecnicoDTO.getCpf());
        if (obj.isPresent() && !obj.get().getId().equals(tecnicoDTO.getId()))
            throw new DataIntegrityViolationException("CPF já cadastrado no sistema");
    }


}
