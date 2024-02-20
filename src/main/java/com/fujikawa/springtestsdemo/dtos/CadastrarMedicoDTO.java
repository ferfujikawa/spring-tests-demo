package com.fujikawa.springtestsdemo.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class CadastrarMedicoDTO {

    @NotBlank
    private String nome;
    
    @Email
    private String email;
    
    @NotBlank
    private String especialidade;
    
    @NotBlank
    private String crm;

    protected CadastrarMedicoDTO() {}

    public CadastrarMedicoDTO(String nome, String email, String especialidade, String crm) {
        this.nome = nome;
        this.email = email;
        this.especialidade = especialidade;
        this.crm = crm;
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

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }
}
