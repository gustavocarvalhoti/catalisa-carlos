## Exercícios de Totem Auto-atendimento


- Este é um RASCUNHO de um aplicativo para gerenciamento de um Totem de Auto-atendimento desenvolvido com Spring Boot.


- O objetivo é permitir que os usuários visualizem, selecionam, atualizem e excluam informações sobre os Pedidos desejados em um FAST FOOD via POSTMAN.


- Como ainda estou desenvolvendo e aprendendo na área de JAVA, eu não consegui terminar ou identificar outros quesitos para finalizar a aplicação por causa de não saber (ainda) identificar os erros ou a lógica.


- Acabou que ficou um código tipo Frankenstein :trollface: :eyes: :neckbeard: :sweat_smile:


- Porém o importante foi tenter desenvolver e exercitar a lógica, mesmo que difícil.


#### A minha intenção era desenvolver conforme, a partir, da Visão Geral abaixo.

## Visão Geral 

O Totem de Auto-Atendimento FastFood é uma aplicação desenvolvida em Java utilizando o framework Spring Boot. 
O objetivo da aplicação é modernizar o sistema de uma lanchonete FastFood, permitindo que os clientes façam seus pedidos de forma autônoma através do totem, retirando-os no balcão quando estiverem prontos para consumo.

## Etapas do Processo

### 1. Menu Inicial

O cliente acessa o totem de autoatendimento e é apresentado ao "Menu Inicial".

No "Menu Inicial", o cliente pode escolher entre:
    
    "Lanches" (opção 1) ou "Bebidas" (opção 2).

### 2. Escolha da Opção

O cliente seleciona uma das opções apresentadas no "Menu Inicial".

Se o cliente escolher "Lanches", o totem exibe as opções de lanches disponíveis ("X-Burguer" ou "X-Salada").

Se o cliente escolher "Bebidas", o totem exibe as opções de bebidas disponíveis ("Refrigerante" ou "Suco").


### 3. Escolha do Lanche ou Bebida

Dependendo da opção escolhida anteriormente, o cliente é solicitado a escolher um lanche ou bebida específico.
O cliente insere o número correspondente à opção desejada:

    (por exemplo, 1 para "X-Burguer", 2 para "X-Salada").
O totem solicita que o cliente indique a quantidade desejada do lanche ou bebida selecionado.

### 4. Adicionar ao Carrinho

Após o cliente selecionar o lanche ou bebida e informar a quantidade desejada, o totem adiciona o item ao carrinho de compras.
O valor total do pedido é atualizado com base nos itens adicionados ao carrinho.

### 5. Continuação do Processo

O cliente pode optar por continuar adicionando mais itens (voltando para a escolha do lanche ou bebida) ou finalizar o pedido.

### 6. Finalização do Pedido

Quando o cliente decide finalizar o pedido, o totem exibe um resumo do carrinho de compras com os itens selecionados e o valor total do pedido até o momento.
O totem solicita ao cliente que escolha a forma de pagamento:

    1 para Cartão de Crédito
    2 para Cartão de Débito
    3 para Vale Refeição
    4 para Dinheiro

### 7. Realizar Pagamento

Com base na forma de pagamento escolhida, o totem conclui o pedido:
Para Cartão de Crédito ou Cartão de Débito, exibe uma mensagem de "Compra finalizada com sucesso! Boa refeição!".
Para Vale Refeição, exibe uma mensagem semelhante de finalização do pedido.
Para Dinheiro, o totem solicita ao cliente o valor em dinheiro fornecido para o pagamento.
Se o valor em dinheiro for maior que o valor total do pedido, o totem calcula o troco e exibe uma mensagem com o valor do troco.

### 8. Edição e Remoção de Itens do Carrinho

O cliente também tem a opção de editar a quantidade de itens ou remover itens do carrinho antes de finalizar o pedido.


###### FIM





