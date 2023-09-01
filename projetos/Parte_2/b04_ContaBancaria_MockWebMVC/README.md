# Documentação de Testes - Projeto Conta Bancária

## Introdução

[Clique para visualizar o Report](https://htmlpreview.github.io/?https://github.com/carloslaczynskizup/ProjetoZero/blob/main/projetos/Parte_2/b04_ContaBancaria_MockWebMVC/htmlReport/index.html)


Este documento descreve os tipos de teste realizados no projeto Conta Bancária, incluindo testes para o 
Controller `ContasController` e testes para as classes DTO `ContaGetDTO` e `ContaPostDTO`. 
O objetivo desses testes é garantir a qualidade e a integridade do sistema, validando seu funcionamento 
correto e apropriado.

## Tipos de Teste

### Testes de Controller

Os testes de Controller têm como foco verificar o comportamento e a integração correta dos endpoints 
disponibilizados pelo `ContasController`.

- **Teste de Listagem de Contas**: Este teste verifica se a listagem de contas retorna um resultado esperado,
incluindo as informações corretas, status HTTP e conteúdo JSON apropriado.

- **Teste de Exibição de Uma Conta por ID**: Este teste valida a funcionalidade de exibir uma conta específica por seu ID. 
Verifica se o endpoint retorna a conta correta e os status HTTP apropriados em diferentes cenários.

- **Teste de Cadastro de Conta**: Este teste verifica se o cadastro de uma nova conta é processado corretamente, retornando o status HTTP 
apropriado e os detalhes da conta criada.

- **Teste de Atualização de Conta**: Testa a funcionalidade de atualização de uma conta existente. Verifica se a alteração é realizada conforme 
esperado e se os status HTTP são retornados corretamente.

- **Teste de Deleção de Conta**: Verifica se a deleção de uma conta é realizada com sucesso e se os status HTTP são tratados apropriadamente.

### Testes de DTO

Os testes de DTO têm como objetivo garantir que as classes DTO `ContaGetDTO` e `ContaPostDTO` estejam corretamente estruturadas e que seus 
atributos possuam os valores corretos.

- **Teste de ContaGetDTO**: Este teste verifica se os atributos do DTO `ContaGetDTO` estão sendo configurados corretamente e se os métodos 
de acesso aos atributos estão funcionando conforme o esperado.

- **Teste de ContaPostDTO**: Verifica se os atributos do DTO `ContaPostDTO` são configurados corretamente e se os métodos de acesso estão 
funcionando apropriadamente.

## Conclusão

Os testes realizados no projeto Conta Bancária têm como objetivo garantir que o sistema esteja funcionando de acordo com as expectativas 
e requisitos definidos. Através da validação dos endpoints do Controller e da estrutura dos DTOs, a integridade e a qualidade do sistema 
são asseguradas, contribuindo para a confiabilidade e eficiência do software.


##### FIM