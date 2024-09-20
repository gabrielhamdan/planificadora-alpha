USE planificadora_alpha;

CREATE TABLE aluno (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    data_nascimento DATE NOT NULL,
    email VARCHAR(255) NOT NULL,
    telefone VARCHAR(15),
    endereco VARCHAR(255),
    nivel VARCHAR(50),
    objetivo_aprendizado TEXT,
    situacao VARCHAR(20) NOT NULL
);