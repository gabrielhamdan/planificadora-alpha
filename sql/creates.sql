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
ALTER TABLE aluno ADD FOREIGN KEY (professor_id) REFERENCES professor(id);
