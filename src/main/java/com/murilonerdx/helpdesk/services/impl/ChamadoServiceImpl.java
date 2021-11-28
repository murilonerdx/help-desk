package com.murilonerdx.helpdesk.services.impl;

import com.murilonerdx.helpdesk.dto.ChamadoDTO;
import com.murilonerdx.helpdesk.entities.Chamado;
import com.murilonerdx.helpdesk.entities.Cliente;
import com.murilonerdx.helpdesk.entities.Tecnico;
import com.murilonerdx.helpdesk.enums.Prioridade;
import com.murilonerdx.helpdesk.enums.Status;
import com.murilonerdx.helpdesk.exception.ResourceNotFoundException;
import com.murilonerdx.helpdesk.repositories.ChamadoRepository;
import com.murilonerdx.helpdesk.repositories.ClienteRepository;
import com.murilonerdx.helpdesk.services.DAOService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ChamadoServiceImpl implements DAOService<Chamado, Integer, ChamadoDTO> {

    @Autowired
    private ChamadoRepository chamadoRepository;

    @Autowired
    private TecnicoServiceImpl tecnicoService;

    @Autowired
    private ClienteServiceImpl clienteService;

    @SneakyThrows
    @Override
    public Chamado create(ChamadoDTO chamadoDTO) {
        chamadoDTO.setId(null);
        Chamado chamado = newChamado(chamadoDTO, new Chamado());

        return chamadoRepository.save(chamado);
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
    public Chamado update(Integer id, ChamadoDTO chamadoDTO) {
        Chamado chamadoSearch = chamadoRepository.findById(id).get();
        Chamado chamado = newChamado(chamadoDTO, chamadoSearch);

        return chamadoRepository.save(chamado);
    }

    @SneakyThrows
    private Chamado newChamado(ChamadoDTO chamadoDTO, Chamado chamado) {
        Tecnico tecnico = tecnicoService.findById(chamadoDTO.getTecnico());
        Cliente cliente = clienteService.findById(chamadoDTO.getCliente());

        chamado.setCliente(cliente);
        chamado.setTecnico(tecnico);
        chamado.setPrioridade(Prioridade.toEnum(chamadoDTO.getPrioridade()));
        chamado.setStatus(Status.toEnum(chamadoDTO.getStatus()));
        chamado.setTitulo(chamadoDTO.getTitulo());
        chamado.setObservacoes(chamadoDTO.getObservacoes());

        if(chamadoDTO.getStatus() == 2){
            chamado.setDataFechamento(LocalDate.now());
        }

        return chamado;
    }
}
