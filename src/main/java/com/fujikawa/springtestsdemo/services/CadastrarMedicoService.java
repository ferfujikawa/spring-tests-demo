package com.fujikawa.springtestsdemo.services;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.fujikawa.springtestsdemo.dtos.CadastrarMedicoDTO;
import com.fujikawa.springtestsdemo.dtos.MedicoDTO;
import com.fujikawa.springtestsdemo.entities.Medico;
import com.fujikawa.springtestsdemo.repositories.MedicoRepository;

@Service
public class CadastrarMedicoService {

    private MedicoRepository medicoRepository;

    public CadastrarMedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public MedicoDTO executar(@Valid CadastrarMedicoDTO dadosMedico) {

        Medico novoMedico = new Medico(
            dadosMedico.getNome(),
            dadosMedico.getEmail(),
            dadosMedico.getEspecialidade(),
            dadosMedico.getCrm());
        
        Medico medicoCadastrado = medicoRepository.save(novoMedico);

        return new MedicoDTO(medicoCadastrado);
    }
}
