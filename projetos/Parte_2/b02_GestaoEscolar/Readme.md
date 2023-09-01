## Documentação do Sistema de Gestão Escolar

### Introdução

A documentação a seguir descreve o projeto do Sistema de Gestão Escolar, um aplicativo desenvolvido em Java usando o Spring Framework para gerenciar alunos, cursos, professores e matrículas em uma escola.

### Funcionalidades

#### 1. Cadastro de Alunos

Permite o cadastro de novos alunos com informações como nome, idade e e-mail.

#### 2. Cadastro de Cursos

Permite o cadastro de novos cursos com informações como nome e carga horária.

#### 3. Cadastro de Professores

Permite o cadastro de novos professores com informações como nome, idade, curso associado e salário.

#### 4. Listagem de Alunos

Apresenta a lista de todos os alunos cadastrados no sistema.

#### 5. Listagem de Cursos

Apresenta a lista de todos os cursos cadastrados no sistema.

#### 6. Listagem de Professores

Apresenta a lista de todos os professores cadastrados no sistema.

#### 7. Matrícula de Alunos em Cursos

Permite realizar a matrícula de um aluno em um curso específico, associando a data da matrícula.

#### 8. Atualização de Curso de Aluno

Permite atualizar o curso associado a um aluno.

#### 9. Exclusão de Aluno

Permite a exclusão de um aluno do sistema.

#### 10. Exclusão de Curso

Permite a exclusão de um curso do sistema.

#### 11. Exclusão de Professor

Permite a exclusão de um professor do sistema.

### Entidades e DTOs

O sistema utiliza as seguintes entidades e DTOs:

- Aluno: ID, nome, idade, e-mail.
- Curso: ID, nome, carga horária.
- Professor: ID, nome, idade, curso associado, salário.
- Matrícula: ID, data da matrícula, aluno, curso. (Não implementada por completo, ainda em desenvolvimento)

### Estrutura do Projeto

O projeto é dividido em várias classes:

- **Controllers**: Lidam com as requisições HTTP, chamando os métodos apropriados nos serviços.
- **Services**: Contêm a lógica de negócios e interagem com os repositórios.
- **Repositories**: Responsáveis por interagir com o banco de dados.
- **Entidades**: Classes que representam as tabelas do banco de dados.
- **DTOs**: Classes que representam objetos de transferência de dados.

### Configuração do Projeto

O projeto utiliza o Spring Framework com as dependências Spring Web, Spring Data JPA, e outras. O banco de dados pode ser configurado de acordo com a preferência (por exemplo, H2 Database, POSTMAN).

### Como Utilizar

1. Clone o repositório.
2. Configure as propriedades do banco de dados no arquivo `application.properties` ou `application.yml`.
3. Execute o aplicativo.
4. Acesse os endpoints HTTP para realizar as operações do sistema.

### Considerações Finais

Esta documentação fornece um resumo das funcionalidades e estrutura do Sistema de Gestão Escolar. 

É recomendado analisar o código-fonte para obter detalhes completos sobre as implementações ou até incremento de novas funcionalidades e melhorias.

Certifique-se de ajustar, expandir, alterar estes códigos do repositório de acordo com as necessidades específicas do seu projeto.

---

###### FIM
