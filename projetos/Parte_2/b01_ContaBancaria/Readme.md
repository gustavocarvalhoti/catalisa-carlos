## Documentação do Aplicativo de Contas Bancárias

Esta documentação descreve o funcionamento do aplicativo de contas bancárias desenvolvido 
usando Spring Boot.

### Funcionalidades

O aplicativo de contas bancárias permite:

1. Exibir todas as contas bancárias cadastradas.
2. Exibir uma conta bancária específica pelo ID.

    2.1 Exibir uma conta bancária específica pelo número da conta. (New Feature)

3. Cadastrar uma nova conta bancária.
4. Deletar uma conta bancária.
5. Atualizar o saldo da conta após depósitos ou saques.

### Endpoints

O aplicativo possui os seguintes endpoints:

- `GET /contas`: Retorna todas as contas bancárias cadastradas.
- `GET /contas/numero/{numero_conta}`: Retorna os detalhes de uma conta específica com base no número da conta.
- `GET /contas/id/{id}`: Retorna os detalhes de uma conta específica com base no ID.
- `POST /contas`: Cadastra uma nova conta bancária.
- `DELETE /contas/id/{id}`: Deleta uma conta bancária com base no número do ID.
- `PUT /contas/id/{id}`: Realiza a atualização na conta bancária com base no ID.

### Estrutura do Projeto

```
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── com
│   │   │   │   ├── example
│   │   │   │   │   ├── controller
│   │   │   │   │   │   ├── ContaController.java
│   │   │   │   │   ├── model
│   │   │   │   │   │   ├── ContaModel.java
│   │   │   │   │   ├── repository
│   │   │   │   │   │   ├── ContaRepository.java
│   │   │   │   │   ├── service
│   │   │   │   │   │   ├── ContaService.java
│   │   │   │   │   │   ├── ContaException.java
│   │   │   │   │   ├── ContaBancariaApplication.java
│   │   ├── resources
│   │   │   ├── application.properties
```

### Executando o Aplicativo

1. Certifique-se de ter o Java e o Maven instalados na sua máquina.
2. Clone o repositório do aplicativo.
3. Configure as informações do banco de dados PostgreSQL no arquivo `application.properties`.
4. Execute o comando `mvn spring-boot:run` na raiz do projeto.
5. O aplicativo estará disponível em `http://localhost:8080` ou através do POSTMAN.

### Uso do Aplicativo

1. Use uma ferramenta como o Postman para testar os endpoints.
2. Consulte a seção anterior ou os códigos para detalhes sobre os endpoints disponíveis e os parâmetros necessários.

### Considerações Finais

Esta é apenas uma documentação básica para fornecer uma visão geral de como o aplicativo de contas bancárias funciona. 

Certifique-se de ajustar, expandir, alterar estes códigos do repositório de acordo com as necessidades específicas do seu projeto.

###### FIM