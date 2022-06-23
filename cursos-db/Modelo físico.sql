DROP DATABASE IF EXISTS BD2A3;

CREATE DATABASE IF NOT EXISTS BD2A3;
USE BD2A3;

CREATE TABLE IF NOT EXISTS areas_conhecimento (
	id INTEGER AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

INSERT INTO areas_conhecimento (nome)
VALUES
	('Ciências da Natureza e suas Tecnologias'), 
	('Ciências Humanas'),
	('Ciências Sociais'),
	('Linguagens e suas Tecnologias'),
    ('Matemática e suas Tecnologias');

CREATE TABLE IF NOT EXISTS disciplinas (
	id INTEGER AUTO_INCREMENT,
    nome VARCHAR(30) NOT NULL UNIQUE,
	carga_horaria INTEGER NOT NULL,
	optativa BOOL NOT NULL,
    area_conhecimento INTEGER NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (area_conhecimento) REFERENCES areas_conhecimento(id)
);

INSERT INTO disciplinas (nome, carga_horaria, optativa, area_conhecimento)
VALUES
	('Arte', 12, true, 4),
    ('Biologia', 48, false, 1),
    ('Filosofia', 24, false, 3),
	('Física', 48, false, 1),
	('Fundamentos da Matemática', 24, true, 5),
    ('Geografia', 48, false, 2),
	('História Brasileira', 24, false, 2),
	('História Geral', 24, false, 2),
	('Interpretação', 24, false, 4),
	('Língua Inglesa', 24, true, 4),
	('Língua Portuguesa', 48, false, 4),
	('Literatura', 24, false, 4),
	('Lógica I', 24, true, 5),
	('Lógica II', 24, true, 5),
	('Matemática Básica', 12, true, 5),
	('Matemática', 48, false, 5),
	('Oratória', 12, true, 3),
    ('Química', 48, false, 1),
	('Redação', 36, true, 4),
    ('Sociologia', 24, false, 3);

/*SELECT * FROM disciplinas INNER JOIN areas_conhecimento ON disciplinas.area_conhecimento = (SELECT id FROM areas_conhecimento WHERE nome = 'Linguagens');*/

CREATE TABLE IF NOT EXISTS cursos (
	id INTEGER AUTO_INCREMENT,
    nome VARCHAR(30) NOT NULL UNIQUE,
	descricao VARCHAR(255),
    carga_horaria INTEGER NOT NULL,
    preco DOUBLE NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO cursos (nome, descricao, carga_horaria, preco)
VALUES
	('ENEM VIP', 'Provê acesso a matérias exclusivas, a 6 redações corrigidas e comentadas por mês, a 7 simulados anuais e a reuniões com nossos monitores', 640, 799.99),
    ('ENEM PLUS', 'Provê acesso às matérias essências, a 4 redações corrigidas e comentadas por mês e a reuniões com nossos monitores', 500, 599.99),
    ('Turma Essencial', 'Provê acesso às matérias essências e a 1 redação corrigida e comentada por mês', 420, 399.99),
    ('Redação', 'Provê acesso às aulas de redação dissertativa argumentativa e a 4 redações corrigidas e comentadas por mês', 44, 99.99),
    ('Inglês', null, 24, 299.99);
    
CREATE TABLE IF NOT EXISTS cursos_disciplinas (
	id_curso INTEGER AUTO_INCREMENT,
    id_disciplina INTEGER,
    PRIMARY KEY (id_curso, id_disciplina)
);

CREATE TABLE IF NOT EXISTS professores (
	matricula INTEGER AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
	rg VARCHAR(9) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
	email VARCHAR(75) NOT NULL UNIQUE,
	coordenador BOOLEAN NOT NULL,
    area_conhecimento INTEGER NOT NULL,
    PRIMARY KEY (matricula),
    FOREIGN KEY (area_conhecimento) REFERENCES areas_conhecimento(id)
);

INSERT INTO professores (nome, rg, cpf, email, area_conhecimento, coordenador)
VALUES
	('Maria da Silva Teixeira', '111111111', '11111111111', 'maria.teixeira@gmail.com', 4, false),
    ('José dos Santos', '111111112', '11111111112', 'jose.santos@hotmail.com', 1, false),
    ('Ana de Oliveira', '111111113', '11111111113', 'ana.oliveira@outlook.com', 3, false),
	('Antônio Souza', '111111114', '11111111114', 'antonio.souza@gmail.com', 1, true),
    ('Juliana Rodrigues Santana', '111111115', '11111111115', 'juliana.santana@gmail.com', 5, true),
    ('João Ferreira Gonçalves', '111111116', '11111111116', 'joao.goncalves@hotmail.com', 2, false),
    ('Patrícia Alves', '111111117', '11111111117', 'patricia.alves@outlook.com', 2, true),
    ('João Carlos Pereira', '111111118', '11111111118', 'joao.pereira@gmail.com', 2, false),
    ('Adriana de Lima', '111111119', '11111111119', 'adriana.lima@gmail.com', 4, false),
    ('Carlos Gomes', '111111120', '11111111120', 'carlos.gomes@hotmail.com', 4, true),
    ('Aline da Costa Ramos', '111111121', '11111111121', 'aline.ramos@outlook.com', 4, false),
    ('Rafael Ribeiro Cardoso', '111111122', '11111111122', 'rafael.cardoso@gmail.com', 4, false),
    ('Fernanda Martins', '111111123', '11111111123', 'fernanda.martins@gmail.com', 5, false),
    ('Paulo Carvalho Freitas', '111111124', '11111111124', 'paulo.carvalho@hotmail.com', 5, false),
    ('Vanessa de Almeida', '111111125', '11111111125', 'vanessa.almeida@outlook.com', 5, false),
    ('Rodrigo Lopes Mendes', '111111126', '11111111126', 'rodrigo.mendes@gmail.com', 5, false),
    ('Luciana Soares', '111111127', '11111111127', 'luciana.soares@gmail.com', 3, true),
    ('Marcos Fernandes', '111111128', '11111111128', 'marcos.fernandes@hotmail.com', 1, false),
    ('Cristiane Vieira', '111111129', '11111111129', 'cristiane.vieira@outlook.com', 4, false),
	('Fábio Barbosa Machado', '111111130', '11111111130', 'fabio.machado@gmail.com', 3, false);
    
CREATE VIEW coordenadores 
AS SELECT areas_conhecimento.nome AS area_conhecimento,
professores.nome AS professor
FROM areas_conhecimento
INNER JOIN professores
ON professores.coordenador = true AND areas_conhecimento.id = professores.area_conhecimento;

SELECT * FROM coordenadores;

CREATE TABLE IF NOT EXISTS alunos (
	matricula INTEGER AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
	rg VARCHAR(9) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
	email VARCHAR(75) NOT NULL UNIQUE,
    observacoes VARCHAR(255),
    PRIMARY KEY (matricula)
);

INSERT INTO alunos (nome, rg, cpf, email, observacoes)
VALUES 
	('Helena Rocha da Silva', '222222221', '22222222221', 'helena.silva@gmail.com', null),
    ('Miguel Dias', '222222222', '22222222222', 'miguel.dias@hotmail.com', 'Portador de deficiência. Possui necessidades especiais'),
    ('Alice Nascimento dos Santos', '222222223', '22222222223', 'alice.santos@outlook.com', null),
	('Arthur Andrade de Oliveira', '222222224', '22222222224', 'arthur.oliveira@gmail.com', null),
    ('Laura Moreira', '222222225', '22222222225', 'laura.moreira@gmail.com', null),
    ('Gael Nunes', '222222226', '22222222226', 'gael.nunes@hotmail.com', null),
    ('Maria Alice Marques', '222222227', '22222222227', 'mariaa.marques@outlook.com', 'Bolsista integral. Adquiriu o plano através do sorteio do Instagram'),
    ('Heitor Machado de Souza', '222222228', '22222222228', 'heitor.souza@gmail.com', null),
    ('Valentina Mendes', '222222229', '22222222229', 'valentina.mendes@gmail.com', null),
    ('Theo Freitas Rodrigues', '222222230', '22222222230', 'theo.rodrigues@hotmail.com', null),
    ('Heloísa Cardoso', '222222231', '22222222231', 'heloisa.cardoso@outlook.com', 'Deficiente auditiva. Necessita do acompanhamento de um professor interlocutor'),
    ('Davi Ramos', '222222232', '22222222232', 'davi.ramos@gmail.com', null),
    ('Maria Clara Gonçalves', '222222233', '22222222233', 'mariac.goncalves@gmail.com', null),
    ('Gabriel Santana Ferreira', '222222234', '22222222234', 'gabriel.ferreira@hotmail.com', 'Bolsista integral. Possui parentesco com um de nossos professores'),
    ('Maria Cecília Teixeira Alves', '222222235', '22222222235', 'mariac.alves@outlook.com', null),
    ('Bernardo Silva', '222222236', '22222222236', 'bernardo.silva@gmail.com', null),
    ('Maria Julia dos Santos', '222222237', '22222222237', 'mariaj.santos@gmail.com', null),
    ('Samuel Oliveira', '222222238', '22222222238', 'samuel.oliveira@hotmail.com', 'Portador de doença crônica'),
    ('Sophia de Souza Pereira', '222222239', '22222222239', 'sophia.pereira@outlook.com', null),
	('João Miguel Rodrigues Lima', '222222240', '22222222240', 'joaom.lima@gmail.com', null);

CREATE TABLE IF NOT EXISTS usuarios_perfis (
  id_perfil_usuario INTEGER AUTO_INCREMENT ,
  descricao VARCHAR(255) NOT NULL UNIQUE,
  PRIMARY KEY (id_perfil_usuario)
);

INSERT INTO usuarios_perfis (descricao)
VALUES ('Admin'), ('Regular');

CREATE TABLE IF NOT EXISTS usuarios (
  id_usuario INTEGER AUTO_INCREMENT,
  nome VARCHAR(75) NOT NULL,
  email VARCHAR(75) NOT NULL,  
  senha VARCHAR(256) NOT NULL,
  id_perfil_usuario INTEGER  NOT NULL DEFAULT 2,
  PRIMARY KEY(id_usuario),
  FOREIGN KEY (id_perfil_usuario) REFERENCES usuarios_perfis(id_perfil_usuario)
);

INSERT INTO usuarios (nome, email, senha, id_perfil_usuario) 
VALUES 
('Administrador', 'admin@gmail.com', '$2a$10$2.P3Sj9JMG5pHGJYZAKA.eMX97aUcQwMWRNX9Puo1k2YBQuY0BvKS', 1),
('José Ferreira', 'jose@gmail.com', '$2a$10$WXfQsblcdtTpL/dndZUC9.NUXDk6bvOTpCr33N7E2/cB/U83RTfvu', 2);