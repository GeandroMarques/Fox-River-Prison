CREATE DATABASE IF NOT EXISTS foxriver;

USE foxriver;

CREATE TABLE IF NOT EXISTS pessoa (
	id_pessoa INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
    data_nascimento DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS celas (
	id_cela INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    bloco INT NOT NULL,
    capacidade INT NOT NULL,
	vagas_utilizadas INT NOT NULL
);

CREATE TABLE IF NOT EXISTS preso (
	preso_id INT NOT NULL UNIQUE,
	FOREIGN KEY (preso_id) REFERENCES pessoa (id_pessoa),
	pena_meses INT NOT NULL,
    data_entrada TIMESTAMP DEFAULT current_timestamp() NOT NULL,
    cela INT NOT NULL
);

CREATE TABLE IF NOT EXISTS funcionario (
	funcionario_id INT NOT NULL,
	FOREIGN KEY (funcionario_id) REFERENCES pessoa (id_pessoa),
    cargo VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS visitas (
	id_visita INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    preso_id INT NOT NULL,
    FOREIGN KEY (preso_id) REFERENCES preso (preso_id),
	nome_visitante VARCHAR(50) NOT NULL,
    data_visita DATE NOT NULL
);


CREATE USER "teste1" IDENTIFIED BY "test1";
GRANT ALL ON *.* TO "teste1" WITH GRANT OPTION
