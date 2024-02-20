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

INSERT INTO public.medicos
(id, nome, email, crm, especialidade, ativo)
VALUES('4dd9efd1-7544-4a62-988c-81b0b228eb57', 'Médico 1', 'medico1@email.com', '123456', 'ORTOPEDIA', false);
INSERT INTO public.medicos
(id, nome, email, crm, especialidade, ativo)
VALUES('a8e84f3d-0e0b-4b8c-b7a5-6bad0ad04ab5', 'Médico 2', 'medico2@email.com', '456789', 'ORTOPEDIA', false);
INSERT INTO public.medicos
(id, nome, email, crm, especialidade, ativo)
VALUES('15acbf86-3dc3-412e-aee6-bd6228430d4e', 'Médico 3', 'medico3@email.com', '111111', 'ORTOPEDIA', true);