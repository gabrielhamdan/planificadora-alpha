USE
planificadora_alpha;

CREATE TABLE professor
(
    id      INT AUTO_INCREMENT PRIMARY KEY,
    usuario VARCHAR(50)  NOT NULL UNIQUE,
    senha   VARCHAR(255) NOT NULL,
    nome    VARCHAR(255) NOT NULL,
    cpf     VARCHAR(14)  NOT NULL,
    area    VARCHAR(50),
    ativo   TINYINT      NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE privilegios
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT,
    privilegio VARCHAR(50),
    FOREIGN KEY (usuario_id) REFERENCES professor (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE aluno
(
    id                   INT AUTO_INCREMENT PRIMARY KEY,
    nome                 VARCHAR(255) NOT NULL,
    cpf                  VARCHAR(14)  NOT NULL,
    data_nascimento      DATE         NOT NULL,
    email                VARCHAR(255) NOT NULL,
    telefone             VARCHAR(15),
    endereco             VARCHAR(255),
    nivel                VARCHAR(50),
    objetivo_aprendizado TEXT,
    situacao             VARCHAR(20)  NOT NULL
);

ALTER TABLE aluno ADD COLUMN professor_id INT;
ALTER TABLE aluno ADD CONSTRAINT fk_professor FOREIGN KEY (professor_id) REFERENCES professor (id) ON DELETE CASCADE;

CREATE TABLE pacote_aula (
    id INT AUTO_INCREMENT PRIMARY KEY,
    descricao_local VARCHAR(255),
    tipo_local VARCHAR(255),
    valor_hora_aula FLOAT,
    professor_id INT,
    FOREIGN KEY (professor_id) REFERENCES professor(id)
);

CREATE TABLE aula (
    id INT AUTO_INCREMENT PRIMARY KEY,
    pacote_aula_id INT,
    status_aula VARCHAR(255),
    data DATE,
    hora_inicial TIME,
    hora_final TIME,
    tarefas_de_casa TEXT,
    anotacoes TEXT,
    professor_id INT,
    FOREIGN KEY (pacote_aula_id) REFERENCES pacote_aula(id)
);

CREATE TABLE pagamento (
    id INT AUTO_INCREMENT PRIMARY KEY,
    data_pagamento DATE,
    valor_pago FLOAT,
    aula_id INT,
    FOREIGN KEY (aula_id) REFERENCES aula(id) ON DELETE CASCADE
);

ALTER TABLE pacote_aula
ADD COLUMN aluno_id INT;

ALTER TABLE pacote_aula
ADD CONSTRAINT fk_aluno FOREIGN KEY (aluno_id) REFERENCES aluno (id) ON DELETE CASCADE;
