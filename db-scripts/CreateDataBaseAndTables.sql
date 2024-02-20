CREATE DATABASE spring_tests_demo;

CREATE TABLE public.medicos (
	id uuid NOT NULL,
	nome varchar(100) NOT NULL,
	email varchar(100) NOT NULL,
	crm varchar(6) NOT NULL,
	especialidade varchar(100) NOT NULL,
	ativo bool NOT NULL,
	CONSTRAINT medicos_pkey PRIMARY KEY (id),
	CONSTRAINT uk_medicos_crm UNIQUE (crm)
);