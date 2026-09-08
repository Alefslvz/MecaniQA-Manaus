# MecaniQA Manager

Projeto desenvolvido para a disciplina de **Estruturas de Dados**, com o objetivo de implementar um sistema de gerenciamento de peças, serviços, clientes, veículos, pedidos e ordens de serviço para uma oficina automotiva utilizando Java.

## Objetivo

O sistema tem como objetivo simular o gerenciamento de uma oficina automotiva, aplicando conceitos de **Estruturas de Dados**, **Tipos Abstratos de Dados (TAD)**, arrays, busca, ordenação, fila FIFO e persistência de dados em arquivos CSV.

A aplicação permite realizar operações relacionadas ao cadastro e gerenciamento de peças, serviços, clientes, veículos, pedidos e ordens de serviço.

## Tecnologias Utilizadas

- Java
- Visual Studio Code
- Extension Pack for Java
- Git
- GitHub
- Arquivos CSV

## Estrutura do Projeto

```text
MecaniQA-Manager/
├── Main.java
├── Gerenciador.java
│
├── modelo/
│   ├── Peca.java
│   ├── Servico.java
│   ├── Cliente.java
│   ├── Carro.java
│   ├── OrdemServico.java
│   ├── Pedido.java
│   └── ItemPedido.java
│
├── enums/
│   ├── EstiloCarro.java
│   ├── StatusOS.java
│   └── CriterioOrdenacao.java
│
├── estruturas/
│   └── FilaAtendimento.java
│
├── ordenacao/
│   └── Ordenador.java
│
├── persistencia/
│   └── ArquivoCSV.java
│
└── README.md
Entidades
Peça
A entidade Peca representa uma peça automotiva cadastrada no sistema.
Atributos:
- Código
- Nome
- Fabricante
- Preço de custo
- Preço de venda
- Quantidade em estoque
Serviço
A entidade Servico representa um serviço automotivo cadastrado no sistema.
Atributos:
- Código
- Descrição
- Tempo estimado em minutos
- Valor da mão de obra
Cliente
A entidade Cliente representa um cliente da oficina.
Atributos:
- Código
- Nome
- WhatsApp
- E-mail
- Lista de carros
Um cliente pode possuir mais de um carro cadastrado.
Carro
A entidade Carro representa um veículo pertencente a um cliente.
Atributos:
- Modelo
- Placa
- Ano
- Estilo do carro
O estilo do carro é definido pelo enum EstiloCarro, que possui as opções:
- HATCH
- SEDAN
- SUV
Ordem de Serviço
A entidade OrdemServico representa uma ordem de serviço da oficina.
Cada ordem possui:
- Identificador único gerado pelo sistema
- Lista de serviços
- Status da ordem de serviço
Os status possíveis são definidos pelo enum StatusOS:
- EM_ABERTO
- AGUARDANDO_EXECUCAO
- EM_EXECUCAO
- FINALIZADA
A Ordem de Serviço possui funcionalidades para:
- Consultar a quantidade de serviços
- Calcular o valor total
- Exibir uma tabela detalhada dos serviços
- Controlar o ciclo de status da ordem
- Impedir alterações após a finalização
Pedido
A entidade Pedido representa um pedido de peças.
Cada pedido possui um código único gerado pelo sistema e utiliza a entidade ItemPedido para relacionar uma peça à quantidade solicitada.
Funcionalidades:
- Adicionar peças ao pedido
- Calcular o valor total
- Aplicar descontos
- Exibir relatório das peças e quantidades
- Finalizar o pedido
- Impedir alterações após a finalização
ItemPedido
A entidade ItemPedido representa a relação entre uma peça e sua quantidade dentro de um pedido.
Atributos:
- Peça
- Quantidade
Enums
O projeto utiliza enums para representar informações com opções previamente definidas.
EstiloCarro
Define os estilos de carro aceitos pelo sistema:
- HATCH
- SEDAN
- SUV
StatusOS
Define os estados possíveis de uma Ordem de Serviço:
- EM_ABERTO
- AGUARDANDO_EXECUCAO
- EM_EXECUCAO
- FINALIZADA
CriterioOrdenacao
Define o critério utilizado pelo algoritmo de ordenação.
A ordenação pode utilizar informações como:
- Nome
- Código identificador
Funcionalidades Implementadas
Peças
- Inserção de peça
- Busca linear de peça por código
- Atualização de peça
- Remoção de peça com reorganização do array
- Gerenciamento das informações da peça
Serviços
- Inserção de serviço
- Busca linear de serviço por código
- Remoção de serviço com reorganização do array
- Gerenciamento das informações do serviço
Clientes e Carros
- Cadastro de clientes
- Cadastro de múltiplos carros para um cliente
- Associação entre cliente e seus carros
- Classificação do estilo do carro por meio de enum
Ordens de Serviço
- Criação de Ordem de Serviço
- Geração de identificador único
- Adição de serviços
- Controle de status
- Cálculo da quantidade de serviços
- Cálculo do valor total
- Exibição dos serviços
- Bloqueio de alterações após a finalização
- Encaminhamento dos serviços para a fila de atendimento
Pedidos
- Criação de pedidos
- Geração de código único
- Associação entre peças e quantidades por meio de ItemPedido
- Cálculo do valor total
- Aplicação de descontos
- Relatório dos itens
- Finalização do pedido
- Bloqueio de alterações após a finalização
Fila de Atendimento
O projeto utiliza uma fila de atendimento baseada no princípio FIFO (First In, First Out).
Isso significa que o primeiro serviço a entrar na fila é o primeiro a ser atendido.
A implementação utiliza um buffer circular para controlar as posições da fila, permitindo o gerenciamento eficiente dos elementos.
Exemplo conceitual:
Entrada
   ↓
[ Serviço 1 ]
[ Serviço 2 ]
[ Serviço 3 ]
   ↓
Atendimento
Quando uma Ordem de Serviço passa para o status AGUARDANDO_EXECUCAO, seus serviços são encaminhados para a fila de atendimento respeitando a ordem de chegada.
Dessa forma, os serviços são processados seguindo o princípio FIFO.
Ordenação
O projeto possui um algoritmo de Bubble Sort implementado do zero.
A classe Ordenador permite utilizar diferentes critérios de ordenação por meio do enum CriterioOrdenacao.
Os registros podem ser organizados por:
- Nome
- Código identificador
A ordenação é utilizada para gerar relatórios organizados de peças e serviços.
Persistência de Dados
O projeto utiliza arquivos CSV para armazenar os dados gerados pelo sistema.
O delimitador utilizado nos arquivos é:
;
A classe ArquivoCSV é responsável pela escrita e leitura dos dados.
A persistência permite armazenar e reconstruir os dados relacionados às principais entidades do sistema, incluindo:
- Clientes
- Peças
- Serviços
- Pedidos
- Ordens de Serviço
Os objetos são convertidos para uma representação textual e podem posteriormente ser reconstruídos a partir dos dados armazenados nos arquivos.
Classe Gerenciador
A classe Gerenciador concentra parte da lógica de gerenciamento dos dados do sistema por meio de métodos estáticos.
Entre as operações estão:
- Inserção de peças
- Busca de peças
- Atualização de peças
- Remoção de peças
- Inserção de serviços
- Busca de serviços
- Remoção de serviços
- Operações relacionadas ao gerenciamento do sistema
Estruturas de Dados Utilizadas
O projeto utiliza diferentes estruturas e algoritmos estudados na disciplina:
- Arrays
- Busca linear
- Reorganização de arrays
- Fila FIFO
- Buffer circular
- Bubble Sort
- Enums
- Persistência em arquivos CSV
Organização do Código
O projeto foi organizado em pacotes de acordo com a responsabilidade de cada classe.
modelo
Contém as principais entidades do sistema:
- Peca
- Servico
- Cliente
- Carro
- OrdemServico
- Pedido
- ItemPedido
enums
Contém os enums utilizados para representar opções e estados do sistema:
- EstiloCarro
- StatusOS
- CriterioOrdenacao
estruturas
Contém as estruturas de dados utilizadas pelo sistema:
- FilaAtendimento
ordenacao
Contém a implementação dos algoritmos de ordenação:
- Ordenador
persistencia
Contém as classes responsáveis pela persistência dos dados:
- ArquivoCSV
Como Executar
1. Abra o projeto no Visual Studio Code.
2. Certifique-se de possuir o Java instalado.
3. Abra a pasta do projeto MecaniQA-Manager.
4. Certifique-se de que as extensões Java necessárias estão instaladas.
5. Execute a classe Main.java.
O Main.java contém testes e demonstrações das funcionalidades desenvolvidas no projeto.
Status do Projeto
Projeto acadêmico em desenvolvimento para a disciplina de Estruturas de Dados.
A versão atual contempla as funcionalidades desenvolvidas para a OAT2, incluindo:
- Modelagem de entidades e relacionamentos
- Enums
- Gerenciamento de clientes e veículos
- Ordens de Serviço
- Pedidos e itens de pedido
- Fila FIFO
- Buffer circular
- Bubble Sort
- Persistência em arquivos CSV
- Leitura e reconstrução de dados a partir de arquivos
Autores
- Álef Silva
- Eduardo Santana Alves
- Pablo Cezar Kluge dos Santos
- Luis Henrique Souza Alves
```
