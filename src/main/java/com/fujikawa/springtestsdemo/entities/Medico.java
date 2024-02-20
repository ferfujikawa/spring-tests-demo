package com.fujikawa.springtestsdemo.entities;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "medicos")
@Entity(name = "Medico")
public class Medico {

	@Id
    @Column(name="id")
	private UUID id;

    @Column(name="nome")
	private String nome;

    @Column(name="ativo")
	private Boolean ativo;

	@Column(name="crm")
	private String crm;
	
	@Column(name="especialidade")
	private String especialidade;
	
	protected Medico() {}

	public Medico(String nome, String especialidade, String crm) {
		
		this.id = UUID.randomUUID();
		this.nome = nome;
		this.ativo = true;
		this.crm = crm;
		this.especialidade = especialidade;
	}

	public UUID getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public String getCrm() {
		return crm;
	}

	public String getEspecialidade() {
		return especialidade;
	}
}
