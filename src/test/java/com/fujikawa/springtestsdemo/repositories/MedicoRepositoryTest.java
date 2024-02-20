package com.fujikawa.springtestsdemo.repositories;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import com.fujikawa.springtestsdemo.entities.Medico;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class MedicoRepositoryTest {

    private MedicoRepository medicoRepository;
    private TestEntityManager entityManager;

    @Autowired
    public MedicoRepositoryTest(
        MedicoRepository medicoRepository,
        TestEntityManager entityManager) {

        this.medicoRepository = medicoRepository;
        this.entityManager = entityManager;
    }

    private Medico cadastrarMedico(String nome, String email, String crm, String especialidade) {
        
        return entityManager.persist(new Medico(nome, email, especialidade, crm));
    }

    @Test
    @DisplayName("Deveria devolver uma lista vazia quando não há médicos com determinada especialidade")
    void testSortearMedicoAtivoDeUmaEspecialidadeCenario1() {

        cadastrarMedico("Médico teste 1", "medicoteste1@email.com", "121212", "ORTOPEDIA");
        cadastrarMedico("Médico teste 2", "medicoteste2@email.com", "232323", "CARDIOLOGIA");
        cadastrarMedico("Médico teste 3", "medicoteste3@email.com", "343434", "INFECTOLOGIA");
        cadastrarMedico("Médico teste 4", "medicoteste4@email.com", "454545", "ORTOPEDIA");
        cadastrarMedico("Médico teste 5", "medicoteste5@email.com", "565656", "CARDIOLOGIA");

        List<Medico> medicosDaEspecialidade = medicoRepository.sortearMedicosAtivosDeUmaEspecialidade("PSIQUIATRIA");
        Assertions.assertThat(medicosDaEspecialidade).isEmpty();
    }

    @Test
    @DisplayName("Deveria devolver uma lista de médicos quando há médicos com determinada especialidade")
    void testSortearMedicoAtivoDeUmaEspecialidadeCenario2() {

        cadastrarMedico("Médico teste 1", "medicoteste1@email.com", "121212", "ORTOPEDIA");
        cadastrarMedico("Médico teste 2", "medicoteste2@email.com", "232323", "CARDIOLOGIA");
        cadastrarMedico("Médico teste 3", "medicoteste3@email.com", "343434", "INFECTOLOGIA");
        cadastrarMedico("Médico teste 4", "medicoteste4@email.com", "454545", "ORTOPEDIA");
        cadastrarMedico("Médico teste 5", "medicoteste5@email.com", "565656", "CARDIOLOGIA");

        List<Medico> medicosDaEspecialidade = medicoRepository.sortearMedicosAtivosDeUmaEspecialidade("INFECTOLOGIA");
        Assertions.assertThat(medicosDaEspecialidade).isNotEmpty();
    }
}
