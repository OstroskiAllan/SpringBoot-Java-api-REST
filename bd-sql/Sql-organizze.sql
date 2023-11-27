create database organizze;
use organizze;

-- Tabela Usuario
CREATE TABLE Usuario (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(80) NOT NULL,
    email VARCHAR(100) NOT NULL,
    senha VARCHAR(100) NOT NULL
);

-- Tabela Tarefa
CREATE TABLE Tarefa (
    id INT PRIMARY KEY AUTO_INCREMENT,
    observacaoTarefa VARCHAR(200),
    data DATE,
    dataEntrega DATE,
    usuario_id INT,
    tabela_id INT
);

-- Tabela Tabela
CREATE TABLE Tabela (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(45) NOT NULL,
    observacoes VARCHAR(200),
    projeto_id INT
);

-- Tabela Projeto
CREATE TABLE Projeto (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(45) NOT NULL,
    observacoes VARCHAR(200)
);

-- Adição de chaves estrangeiras
ALTER TABLE Tarefa
    ADD CONSTRAINT fk_tarefa_usuario FOREIGN KEY (usuario_id) REFERENCES Usuario(id),
    ADD CONSTRAINT fk_tarefa_tabela FOREIGN KEY (tabela_id) REFERENCES Tabela(id);

ALTER TABLE Tabela
    ADD CONSTRAINT fk_tabela_projeto FOREIGN KEY (projeto_id) REFERENCES Projeto(id);


-- Inserção de dados fictícios na tabela Usuario
INSERT INTO Usuario (nome, email, senha) VALUES
    ('João', 'joao@email.com', '123'),
    ('Maria', 'maria@email.com', '123'),
    ('Carlos', 'carlos@email.com', '123'),
    ('Ana', 'ana@email.com', '123'),
    ('Paulo', 'paulo@email.com', '123');

INSERT INTO Projeto (nome, observacoes) VALUES
    ('Desenvolvimento de Aplicativo Móvel', 'Projeto para criar um aplicativo inovador para dispositivos móveis.'),
    ('Migração para a Nuvem', 'Projeto para migrar os sistemas existentes para uma infraestrutura em nuvem.'),
    ('Expansão de Mercado', 'Projeto para expandir a presença da empresa em novos mercados.'),
    ('Atualização de Website', 'Projeto para redesenhar e atualizar o site corporativo.'),
    ('Integração de Sistemas', 'Projeto para integrar sistemas e melhorar a eficiência operacional.');


-- Inserção de dados fictícios na tabela Tabela
INSERT INTO Tabela (nome, observacoes, projeto_id) VALUES
    ('Analise', 'Descrição da Tabela 1', 1),
    ('A fazer', 'Descrição da Tabela 2', 2),
    ('Fazendo', 'Descrição da Tabela 3', 3),
    ('Feito', 'Descrição da Tabela 4', 4),
    ('Revisao', 'Descrição da Tabela 5', 5);
    
-- Inserção de dados fictícios na tabela Tarefa
INSERT INTO Tarefa (observacaoTarefa, data, dataEntrega, usuario_id, tabela_id) VALUES
    ('Design de Interface do Usuário', '2023-01-05', '2023-01-15', 1, 1),
    ('Configuração de Serviços na Nuvem', '2023-02-10', '2023-02-28', 2, 2),
    ('Análise de Mercado', '2023-03-15', '2023-04-10', 3, 3),
    ('Desenvolvimento Frontend', '2023-04-20', '2023-05-10', 4, 4),
    ('Implementação de APIs', '2023-05-15', '2023-06-05', 5, 5),
    ('Testes de Usabilidade', '2023-06-10', '2023-06-30', 1, 1),
    ('Configuração de Segurança na Nuvem', '2023-07-05', '2023-07-20', 2, 2),
    ('Estratégia de Marketing', '2023-08-01', '2023-08-20', 3, 3),
    ('Otimização de Desempenho', '2023-09-01', '2023-09-15', 4, 4),
    ('Documentação de Sistemas', '2023-09-20', '2023-10-10', 5, 5);
