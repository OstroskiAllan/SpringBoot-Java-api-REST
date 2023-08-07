# SpringBoot-Java-api-REST
Pretendo ir atualizado o projeto para usar o mesmo de back-end no tcc. Sendo o tcc um app de organizar projetos similar ao Trello, servindo apoio pessoal e para aprimorar conhecimentos.		Quanto ao front-end ainda nao foi decidido como vai ser o funcionamento e de quais ferramentas seriam utilizadas...
# Organização do Projeto
- **src/main/java/com/example/organizze/controller:** Contém classes que atuam como controladores para lidar com requisições HTTP. Esses controladores definem endpoints que podem ser acessados por meio de URLs e interagem com as outras partes do aplicativo.

- **src/main/java/com/example/organizze/model:** Contém as classes que representam os modelos de dados da sua aplicação. No seu caso, a classe Usuario é uma representação das informações de usuário.

- **src/main/java/com/example/organizze/repository:** Aqui você tem a interface UsuarioRepository, que estende JpaRepository. Isso fornece métodos predefinidos para realizar operações de CRUD no banco de dados para a entidade Usuario.

- **src/main/resources:** É o diretório onde você pode armazenar recursos não relacionados a código, como arquivos de configuração.

## Dependências Maven
- **Spring Boot Starter Web:** Permite a criação de aplicativos da web usando o Spring MVC.

- **Spring Boot Starter Data JPA:** Simplifica a configuração do Spring Data JPA para acesso a bancos de dados.

- **MySQL Driver:** Biblioteca de driver MySQL para comunicação com o banco de dados.

- **Spring Boot Starter Thymeleaf:** Integração do Thymeleaf para renderização de páginas da web.

## Configuração do Banco de Dados
A configuração do banco de dados é definida no arquivo **application.properties**:

- **spring.datasource.url:** A URL de conexão com o banco de dados.

- **spring.datasource.username:** O nome de usuário para acessar o banco de dados.

- **spring.datasource.password:** A senha para acessar o banco de dados.

- **spring.jpa.properties.hibernate.dialect:** Define o dialeto do Hibernate para o banco de dados.

## Endpoints
**GET /usuario/all:** Retorna uma lista de todos os usuários no banco de dados.

**POST /usuario/save:** Aceita um objeto JSON representando um usuário no corpo da requisição e salva-o no banco de dados.

## Como Usar
1. Clone o repositório.

2. Configure o banco de dados no arquivo application.properties.

3. Execute o aplicativo Spring Boot.

4. Acesse os endpoints através de um cliente HTTP ou navegador.
