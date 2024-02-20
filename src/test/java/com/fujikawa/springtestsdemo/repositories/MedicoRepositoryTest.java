package com.fujikawa.springtestsdemo.repositories;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.fujikawa.springtestsdemo.entities.Medico;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class MedicoRepositoryTest {

    private MedicoRepository medicoRepository;

    @Autowired
    public MedicoRepositoryTest(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    @Test
    @DisplayName("Deveria devolver uma lista vazia quando não há médicos com determinada especialidade")
    void testSortearMedicoAtivoDeUmaEspecialidade() {

        List<Medico> medicosDaEspecialidade = medicoRepository.sortearMedicosAtivosDeUmaEspecialidade("INEXISTENTE");
        Assertions.assertThat(medicosDaEspecialidade).isEmpty();
    }
}
