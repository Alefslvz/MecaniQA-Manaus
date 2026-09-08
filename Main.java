import java.io.IOException;

import enums.CriterioOrdenacao;
import enums.EstiloCarro;
import estruturas.FilaAtendimento;
import modelo.Carro;
import modelo.Cliente;
import modelo.OrdemServico;
import modelo.Peca;
import modelo.Pedido;
import modelo.Servico;
import persistencia.ArquivoCSV;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("====================================");
        System.out.println("        MECANIQA MANAGER");
        System.out.println("   Estoque, Servicos e Atendimento");
        System.out.println("====================================");

        Peca[] pecas = new Peca[100];
        Servico[] servicos = new Servico[50];
        Cliente[] clientes = new Cliente[50];
        Pedido[] pedidos = new Pedido[50];
        OrdemServico[] ordensServico = new OrdemServico[50];

        int totalPecas = 0;
        int totalServicos = 0;
        int totalClientes = 0;
        int totalPedidos = 0;
        int totalOrdensServico = 0;

        Peca filtroOleo = new Peca();
        filtroOleo.nome = "Filtro de oleo";
        filtroOleo.fabricante = "Bosch";
        filtroOleo.precoCusto = 20.00;
        filtroOleo.precoVenda = 35.90;
        filtroOleo.quantidadeEstoque = 10;
        totalPecas = Gerenciador.inserirPeca(pecas, totalPecas, filtroOleo);

        Peca pastilhaFreio = new Peca();
        pastilhaFreio.nome = "Pastilha de freio";
        pastilhaFreio.fabricante = "Fras-le";
        pastilhaFreio.precoCusto = 45.00;
        pastilhaFreio.precoVenda = 79.90;
        pastilhaFreio.quantidadeEstoque = 20;
        totalPecas = Gerenciador.inserirPeca(pecas, totalPecas, pastilhaFreio);

        Peca amortecedor = new Peca();
        amortecedor.nome = "Amortecedor dianteiro";
        amortecedor.fabricante = "Cofap";
        amortecedor.precoCusto = 120.00;
        amortecedor.precoVenda = 189.90;
        amortecedor.quantidadeEstoque = 8;
        totalPecas = Gerenciador.inserirPeca(pecas, totalPecas, amortecedor);

        Servico trocaOleo = new Servico();
        trocaOleo.descricao = "Troca de oleo";
        trocaOleo.tempoEstimadoMinutos = 40;
        trocaOleo.valorMaoDeObra = 80.00;
        totalServicos = Gerenciador.inserirServico(servicos, totalServicos, trocaOleo);

        Servico alinhamento = new Servico();
        alinhamento.descricao = "Alinhamento e balanceamento";
        alinhamento.tempoEstimadoMinutos = 60;
        alinhamento.valorMaoDeObra = 120.00;
        totalServicos = Gerenciador.inserirServico(servicos, totalServicos, alinhamento);

        System.out.println("Pecas e servicos cadastrados (codigo gerado automaticamente): "
                + totalPecas + " pecas, " + totalServicos + " servicos.");
        System.out.println("------------------------------------");

        System.out.println("\n=== LISTAGEM (READ) ===");
        Gerenciador.listarPecas(pecas, totalPecas);
        Gerenciador.listarServicos(servicos, totalServicos);

        System.out.println("=== ATUALIZACAO (UPDATE) ===");
        boolean atualizou = Gerenciador.atualizarPeca(pecas, totalPecas,
                filtroOleo.codigo, "Filtro de oleo (Premium)", "Bosch",
                22.00, 39.90, 15);
        System.out.println("Peca " + filtroOleo.codigo + " atualizada? " + atualizou);
        Gerenciador.listarPecas(pecas, totalPecas);

        System.out.println("\n=== CLIENTES E CARROS ===");

        Cliente joao = new Cliente(1, "Joao Pereira", "77 99999-0001", "joao@email.com");
        totalClientes = Gerenciador.inserirCliente(clientes, totalClientes, joao);

        Carro carroDoJoao = new Carro("Onix", "ABC1D23", 2022, EstiloCarro.HATCH);
        joao.adicionarCarro(carroDoJoao);

        Carro segundoCarroDoJoao = new Carro("Duster", "XYZ9K88", 2021, EstiloCarro.SUV);
        joao.adicionarCarro(segundoCarroDoJoao);

        joao.exibirDados();
        joao.exibirCarros();

        System.out.println("\n=== PEDIDO (VENDA DE PECAS) ===");

        Pedido pedido = new Pedido();
        pedido.adicionarItem(pastilhaFreio, 2);
        pedido.adicionarItem(filtroOleo, 1);
        pedido.aplicarDesconto(10);
        pedido.finalizarPedido();
        pedido.gerarRelatorio();

        totalPedidos = Gerenciador.inserirPedido(pedidos, totalPedidos, pedido);

        System.out.println("\n=== ORDEM DE SERVICO E FILA DE ATENDIMENTO (FIFO) ===");

        OrdemServico osJoao = new OrdemServico();
        osJoao.adicionarServico(trocaOleo);
        osJoao.adicionarServico(alinhamento);
        osJoao.tabelaServicos();

        totalOrdensServico = Gerenciador.inserirOrdemServico(
                ordensServico, totalOrdensServico, osJoao);

        OrdemServico osOutroCliente = new OrdemServico();
        osOutroCliente.adicionarServico(trocaOleo);
        totalOrdensServico = Gerenciador.inserirOrdemServico(
                ordensServico, totalOrdensServico, osOutroCliente);

        FilaAtendimento filaAtendimento = new FilaAtendimento(10);

        Gerenciador.adicionarOSNaFila(filaAtendimento, osJoao);
        Gerenciador.adicionarOSNaFila(filaAtendimento, osOutroCliente);

        filaAtendimento.exibirFila();

        OrdemServico osAtendida = Gerenciador.atenderProximaOS(filaAtendimento);
        System.out.println("\nOS retirada da fila para atendimento: "
                + osAtendida.identificador + " | Novo status: " + osAtendida.status);

        filaAtendimento.exibirFila();

        osAtendida.finalizarOS();
        osAtendida.tabelaServicos();

        System.out.println("\n=== ORDENACAO (BUBBLE SORT) ===");

        System.out.println("Pecas antes de ordenar por nome:");
        for (int i = 0; i < totalPecas; i++) {
            System.out.println(pecas[i].codigo + " - " + pecas[i].nome);
        }

        Gerenciador.ordenarPecas(pecas, totalPecas, CriterioOrdenacao.NOME);

        System.out.println("Pecas depois de ordenar por nome:");
        for (int i = 0; i < totalPecas; i++) {
            System.out.println(pecas[i].codigo + " - " + pecas[i].nome);
        }

        Gerenciador.ordenarServicos(servicos, totalServicos, CriterioOrdenacao.NOME);

        System.out.println("\nServicos ordenados por descricao:");
        for (int i = 0; i < totalServicos; i++) {
            System.out.println(servicos[i].codigo + " - " + servicos[i].descricao);
        }

        System.out.println("\n=== PERSISTENCIA EM CSV ===");

        ArquivoCSV.salvarPecas(pecas, totalPecas, "dados/pecas.csv");
        ArquivoCSV.salvarServicos(servicos, totalServicos, "dados/servicos.csv");
        ArquivoCSV.salvarClientes(clientes, totalClientes, "dados/clientes.csv");
        ArquivoCSV.salvarCarros(clientes, totalClientes, "dados/carros.csv");
        ArquivoCSV.salvarPedidos(pedidos, totalPedidos, "dados/pedidos.csv");
        ArquivoCSV.salvarItensPedidos(pedidos, totalPedidos, "dados/itens_pedidos.csv");
        ArquivoCSV.salvarOrdensServico(ordensServico, totalOrdensServico, "dados/ordens_servico.csv");
        ArquivoCSV.salvarServicosOrdensServico(ordensServico, totalOrdensServico,
                "dados/servicos_ordens_servico.csv");

        System.out.println("Dados salvos na pasta dados/.");

        System.out.println("\n=== RECARREGANDO OS DADOS DO ZERO (PROVA REAL) ===");

        Peca[] pecasRecarregadas = new Peca[100];
        int totalPecasRecarregadas = ArquivoCSV.carregarPecas(pecasRecarregadas, "dados/pecas.csv");
        System.out.println("Pecas recarregadas do CSV: " + totalPecasRecarregadas);

        Servico[] servicosRecarregados = new Servico[50];
        int totalServicosRecarregados = ArquivoCSV.carregarServicos(
                servicosRecarregados, "dados/servicos.csv");
        System.out.println("Servicos recarregados do CSV: " + totalServicosRecarregados);

        Cliente[] clientesRecarregados = new Cliente[50];
        int totalClientesRecarregados = ArquivoCSV.carregarClientes(
                clientesRecarregados, "dados/clientes.csv");
        ArquivoCSV.carregarCarros(clientesRecarregados, totalClientesRecarregados, "dados/carros.csv");

        System.out.println("Clientes recarregados do CSV: " + totalClientesRecarregados);
        for (int i = 0; i < totalClientesRecarregados; i++) {
            clientesRecarregados[i].exibirDados();
            clientesRecarregados[i].exibirCarros();
        }

        Pedido[] pedidosRecarregados = new Pedido[50];
        int totalPedidosRecarregados = ArquivoCSV.carregarPedidos(
                pedidosRecarregados, "dados/pedidos.csv");
        ArquivoCSV.carregarItensPedidos(pedidosRecarregados, totalPedidosRecarregados,
                pecasRecarregadas, totalPecasRecarregadas, "dados/itens_pedidos.csv");

        System.out.println("\nPedidos recarregados do CSV: " + totalPedidosRecarregados);
        for (int i = 0; i < totalPedidosRecarregados; i++) {
            pedidosRecarregados[i].gerarRelatorio();
        }

        OrdemServico[] ordensServicoRecarregadas = new OrdemServico[50];
        int totalOrdensServicoRecarregadas = ArquivoCSV.carregarOrdensServico(
                ordensServicoRecarregadas, "dados/ordens_servico.csv");
        ArquivoCSV.carregarServicosOrdensServico(ordensServicoRecarregadas,
                totalOrdensServicoRecarregadas, servicosRecarregados,
                totalServicosRecarregados, "dados/servicos_ordens_servico.csv");

        System.out.println("\nOrdens de servico recarregadas do CSV: "
                + totalOrdensServicoRecarregadas);
        for (int i = 0; i < totalOrdensServicoRecarregadas; i++) {
            ordensServicoRecarregadas[i].tabelaServicos();
        }
    }
}