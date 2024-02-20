package com.fujikawa.springtestsdemo.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fujikawa.springtestsdemo.entities.Medico;

public interface MedicoRepository extends JpaRepository<Medico, UUID> {

    @Query("select m from Medico m where m.ativo = 1 and m.especialidade = :especialidade order by rand() limit 1")
    Optional<Medico> sortearMedicoAtivoDeUmaEspecialidade(String especialidade);
}
