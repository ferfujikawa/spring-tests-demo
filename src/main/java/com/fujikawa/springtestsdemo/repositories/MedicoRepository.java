package com.fujikawa.springtestsdemo.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fujikawa.springtestsdemo.entities.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, UUID> {

    @Query("select m from Medico m where m.ativo = 1 and m.especialidade = :especialidade order by RANDOM()")
    List<Medico> sortearMedicosAtivosDeUmaEspecialidade(String especialidade);
}
