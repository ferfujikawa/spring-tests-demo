package com.fujikawa.springtestsdemo.dtos;

import java.util.UUID;

import com.fujikawa.springtestsdemo.entities.Medico;

public class MedicoDTO {

    private UUID id;

    private String nome;

	private String email;

    private Boolean ativo;

	private String crm;
	
	private String especialidade;

    protected MedicoDTO() {}

    public MedicoDTO(UUID id, String nome, String email, Boolean ativo, String crm, String especialidade) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.ativo = ativo;
        this.crm = crm;
        this.especialidade = especialidade;
    }

    public MedicoDTO(Medico medico) {
        this(
            medico.getId(),
            medico.getNome(),
            medico.getEmail(),
            medico.getAtivo(),
            medico.getCrm(),
            medico.getEspecialidade());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
