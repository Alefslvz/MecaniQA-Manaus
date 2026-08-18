# MecaniQA-Manager
# MecaniQA Manager

Projeto desenvolvido para a disciplina de Estrutura de Dados, com o objetivo de implementar um MVP de gerenciamento de peças e serviços automotivos utilizando Java e arrays estáticos.

## Objetivo
O sistema tem como objetivo simular o controle inicial de estoque e serviços de uma oficina automotiva, aplicando conceitos de Tipos Abstratos de Dados (TAD), arrays unidimensionais, busca linear, inserção e remoção de registros.

## Tecnologias Utilizadas
- Java
- VS Code
- Extension Pack for Java

## Estrutura do Projeto
```text
mecaniqa-manager/
├── Main.java
├── Gerenciador.java
├── Peca.java
├── Servico.java
└── README.md
```

## Entidades

### Peça
A entidade `Peca` representa uma peça automotiva cadastrada no sistema.

Atributos:
- Código
- Nome
- Fabricante
- Preço de custo
- Preço de venda
- Quantidade em estoque

## Serviço
A entidade Servico representa um serviço automotivo cadastrado no sistema.
Atributos:

- Código
- Descrição
- Tempo estimado em minutos
- Valor da mão de obra

## Funcionalidades Implementadas

### Peças
- Inserção de peça
- Busca linear de peça por código
- Remoção de peça com reorganização do array

### Serviços
- Inserção de serviço
- Busca linear de serviço por código
- Remoção de serviço com reorganização do array

## Estrutura de Dados Utilizada
O projeto utiliza arrays unidimensionais de tamanho fixo para armazenar os dados em memória:

```java
Peca[] pecas = new Peca[100];
Servico[] servicos = new Servico[50];
```

Também são utilizadas variáveis auxiliares para controlar a quantidade de registros ativos:
```java
int totalPecas = 0;
int totalServicos = 0;
```

## Lógica de Inserção
A inserção é feita na próxima posição livre do array, controlada pela variável de quantidade.
Exemplo:

pecas[totalPecas] = novaPeca;
totalPecas++;

## Lógica de Busca Linear
A busca linear percorre o array do início até a quantidade atual de registros cadastrados, comparando o código informado com o código de cada item.
Caso encontre o registro, retorna o índice. Caso não encontre, retorna -1.

## Lógica de Remoção
A remoção utiliza a técnica de reorganização dos elementos.
Quando um item é removido, os elementos posteriores são deslocados uma posição para a esquerda, evitando espaços vazios no meio do array.

## Classe Gerenciador
A classe Gerenciador concentra a lógica principal do sistema por meio de métodos estáticos.

Métodos implementados:
- `inserirPeca()`
- `buscarPecaPorCodigo()`
- `removerPeca()`
- `inserirServico()`
- `buscarServicoPorCodigo()`
- `removerServico()`

## Status do Projeto
- Projeto em desenvolvimento para fins acadêmicos.
- Funcionalidades da entrega atual:
- Inserção de peças e serviços
- Busca linear por código
- Remoção com reorganização dos arrays
- Testes executados no Main.java

## Autores
Álef Silva
Pablo Cezar Kluge dos Santos
Luis Henrique Souza Alves
