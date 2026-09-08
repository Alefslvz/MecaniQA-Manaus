import enums.CriterioOrdenacao;
import estruturas.FilaAtendimento;
import modelo.Cliente;
import modelo.OrdemServico;
import modelo.Peca;
import modelo.Pedido;
import modelo.Servico;
import ordenacao.Ordenador;

public class Gerenciador {
    public static int inserirPeca(Peca[] pecas, int totalPecas, Peca novaPeca) {
        pecas[totalPecas] = novaPeca;
        totalPecas++;

        return totalPecas;
    }

    public static int buscarPecaPorCodigo(Peca[] pecas, int totalPecas, int codigo) {
        for (int i = 0; i < totalPecas; i++) {
            if (pecas[i].codigo == codigo) {
                return i;
            }
        }

        return -1;
    }

    public static int removerPeca(Peca[] pecas, int totalPecas, int codigo) {
        int indice = buscarPecaPorCodigo(pecas, totalPecas, codigo);

        if (indice == -1) {
            return totalPecas;
        }

        for (int i = indice; i < totalPecas - 1; i++) {
            pecas[i] = pecas[i + 1];
        }

        pecas[totalPecas - 1] = null;
        totalPecas--;

        return totalPecas;
    }

    public static void listarPecas(Peca[] pecas, int totalPecas) {
        if (totalPecas == 0) {
            System.out.println("Nenhuma peca cadastrada.");
            return;
        }

        for (int i = 0; i < totalPecas; i++) {
            System.out.println("Codigo: " + pecas[i].codigo);
            System.out.println("Nome: " + pecas[i].nome);
            System.out.println("Fabricante: " + pecas[i].fabricante);
            System.out.println("Preco custo: R$ " + pecas[i].precoCusto);
            System.out.println("Preco venda: R$ " + pecas[i].precoVenda);
            System.out.println("Quantidade: " + pecas[i].quantidadeEstoque);
            System.out.println("------------------------------------");
        }
    }

    public static boolean atualizarPeca(Peca[] pecas, int totalPecas, int codigo,
            String nome, String fabricante, double precoCusto,
            double precoVenda, int quantidadeEstoque) {

        int indice = buscarPecaPorCodigo(pecas, totalPecas, codigo);

        if (indice == -1) {
            return false;
        }

        pecas[indice].nome = nome;
        pecas[indice].fabricante = fabricante;
        pecas[indice].precoCusto = precoCusto;
        pecas[indice].precoVenda = precoVenda;
        pecas[indice].quantidadeEstoque = quantidadeEstoque;

        return true;
    }

    public static int inserirServico(Servico[] servicos, int totalServicos,
            Servico novoServico) {

        servicos[totalServicos] = novoServico;
        totalServicos++;

        return totalServicos;
    }

    public static int buscarServicoPorCodigo(Servico[] servicos,
            int totalServicos, int codigo) {

        for (int i = 0; i < totalServicos; i++) {
            if (servicos[i].codigo == codigo) {
                return i;
            }
        }

        return -1;
    }

    public static int removerServico(Servico[] servicos, int totalServicos,
            int codigo) {

        int indice = buscarServicoPorCodigo(servicos, totalServicos, codigo);

        if (indice == -1) {
            return totalServicos;
        }

        for (int i = indice; i < totalServicos - 1; i++) {
            servicos[i] = servicos[i + 1];
        }

        servicos[totalServicos - 1] = null;
        totalServicos--;

        return totalServicos;
    }

    public static void listarServicos(Servico[] servicos, int totalServicos) {
        if (totalServicos == 0) {
            System.out.println("Nenhum servico cadastrado.");
            return;
        }

        for (int i = 0; i < totalServicos; i++) {
            System.out.println("Codigo: " + servicos[i].codigo);
            System.out.println("Descricao: " + servicos[i].descricao);
            System.out.println("Tempo estimado: "
                    + servicos[i].tempoEstimadoMinutos + " minutos");
            System.out.println("Valor mao de obra: R$ " + servicos[i].valorMaoDeObra);
            System.out.println("------------------------------------");
        }
    }

    public static boolean atualizarServico(Servico[] servicos, int totalServicos,
            int codigo, String descricao, int tempoEstimadoMinutos,
            double valorMaoDeObra) {

        int indice = buscarServicoPorCodigo(servicos, totalServicos, codigo);

        if (indice == -1) {
            return false;
        }

        servicos[indice].descricao = descricao;
        servicos[indice].tempoEstimadoMinutos = tempoEstimadoMinutos;
        servicos[indice].valorMaoDeObra = valorMaoDeObra;

        return true;
    }

    public static int inserirCliente(Cliente[] clientes, int totalClientes,
            Cliente novoCliente) {

        clientes[totalClientes] = novoCliente;
        totalClientes++;

        return totalClientes;
    }

    public static int buscarClientePorCodigo(Cliente[] clientes,
            int totalClientes, int codigo) {

        for (int i = 0; i < totalClientes; i++) {
            if (clientes[i].codigo == codigo) {
                return i;
            }
        }

        return -1;
    }

    public static int removerCliente(Cliente[] clientes, int totalClientes,
            int codigo) {

        int indice = buscarClientePorCodigo(clientes, totalClientes, codigo);

        if (indice == -1) {
            return totalClientes;
        }

        for (int i = indice; i < totalClientes - 1; i++) {
            clientes[i] = clientes[i + 1];
        }

        clientes[totalClientes - 1] = null;
        totalClientes--;

        return totalClientes;
    }

    public static int inserirPedido(Pedido[] pedidos, int totalPedidos,
            Pedido novoPedido) {

        pedidos[totalPedidos] = novoPedido;
        totalPedidos++;

        return totalPedidos;
    }

    public static int buscarPedidoPorCodigo(Pedido[] pedidos,
            int totalPedidos, int codigo) {

        for (int i = 0; i < totalPedidos; i++) {
            if (pedidos[i].codigo == codigo) {
                return i;
            }
        }

        return -1;
    }
    public static int inserirOrdemServico(OrdemServico[] ordensServico,
            int totalOrdensServico, OrdemServico novaOrdemServico) {

        ordensServico[totalOrdensServico] = novaOrdemServico;
        totalOrdensServico++;

        return totalOrdensServico;
    }

    public static int buscarOrdemServicoPorIdentificador(
            OrdemServico[] ordensServico, int totalOrdensServico,
            int identificador) {

        for (int i = 0; i < totalOrdensServico; i++) {
            if (ordensServico[i].identificador == identificador) {
                return i;
            }
        }

        return -1;
    }

    public static boolean adicionarOSNaFila(FilaAtendimento filaAtendimento,
            OrdemServico ordemServico) {

        return filaAtendimento.enfileirar(ordemServico);
    }

    public static OrdemServico atenderProximaOS(
            FilaAtendimento filaAtendimento) {

        return filaAtendimento.desenfileirar();
    }

    public static void ordenarPecas(Peca[] pecas, int totalPecas,
            CriterioOrdenacao criterio) {

        Ordenador.ordenarPecas(pecas, totalPecas, criterio);
    }

    public static void ordenarServicos(Servico[] servicos, int totalServicos,
            CriterioOrdenacao criterio) {

        Ordenador.ordenarServicos(servicos, totalServicos, criterio);
    }
}