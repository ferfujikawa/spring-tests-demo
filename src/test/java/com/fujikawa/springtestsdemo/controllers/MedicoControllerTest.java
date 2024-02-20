package com.fujikawa.springtestsdemo.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.io.IOException;
import java.util.UUID;

import com.fujikawa.springtestsdemo.dtos.CadastrarMedicoDTO;
import com.fujikawa.springtestsdemo.dtos.MedicoDTO;
import com.fujikawa.springtestsdemo.services.CadastrarMedicoService;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
public class MedicoControllerTest {
    
    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<CadastrarMedicoDTO> dadosCadastroMedicoMock;

    @Autowired
    private JacksonTester<MedicoDTO> dadosMedicoCadastradoMock;

    @MockBean
    private CadastrarMedicoService cadastrarMedicoService;

    @Test
    @DisplayName("Deveria devolver código http 201 quando informações válidas")
    void testCadastrarMedicoCenario1() throws IOException, Exception {

        UUID novoMedicoId = UUID.randomUUID();

        CadastrarMedicoDTO dadosCadastroMedico = new CadastrarMedicoDTO(
            "Novo medico",
            "novo.medico@email.com",
            "CARDIOLOGIA",
            "123555");

        MedicoDTO dadosMedicoCadastrado = new MedicoDTO(
            novoMedicoId,
            dadosCadastroMedico.getNome(),
            dadosCadastroMedico.getEmail(),
            true,
            dadosCadastroMedico.getCrm(),
            dadosCadastroMedico.getEspecialidade());

        when(cadastrarMedicoService.executar(any())).thenReturn(dadosMedicoCadastrado);

        MockHttpServletResponse response = mvc
            .perform(
                post("/medicos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(dadosCadastroMedicoMock.write(dadosCadastroMedico).getJson()))
            .andReturn()
            .getResponse();

        MedicoDTO dadosMedicoCadastradoEsperado = new MedicoDTO(
            novoMedicoId,
            dadosCadastroMedico.getNome(),
            dadosCadastroMedico.getEmail(),
            true,
            dadosCadastroMedico.getCrm(),
            dadosCadastroMedico.getEspecialidade());

        String jsonEsperado = dadosMedicoCadastradoMock.write(dadosMedicoCadastradoEsperado).getJson();

        Assertions.assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
        Assertions.assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);
    }

    @Test
    @DisplayName("Deveria devolver código http 400 quando informações inválidas")
    void testCadastrarMedicoCenario2() throws Exception {

        MockHttpServletResponse response = mvc
            .perform(post("/medicos"))
            .andReturn()
            .getResponse();

        Assertions.assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }
}
