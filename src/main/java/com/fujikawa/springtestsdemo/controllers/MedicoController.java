package com.fujikawa.springtestsdemo.controllers;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fujikawa.springtestsdemo.dtos.CadastrarMedicoDTO;
import com.fujikawa.springtestsdemo.dtos.MedicoDTO;
import com.fujikawa.springtestsdemo.services.CadastrarMedicoService;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    private CadastrarMedicoService cadastrarMedicoService;

    public MedicoController(CadastrarMedicoService cadastrarMedicoService) {
        this.cadastrarMedicoService = cadastrarMedicoService;
    }

    @PostMapping
    public ResponseEntity<MedicoDTO> cadastrarMedico(
        @RequestBody CadastrarMedicoDTO dadosMedico,
        UriComponentsBuilder uriComponentsBuilder) {

        MedicoDTO medicoCadastrado = cadastrarMedicoService.executar(dadosMedico);

        URI uri = uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(medicoCadastrado.getId()).toUri();

        return ResponseEntity.created(uri).body(medicoCadastrado);
    }
}
