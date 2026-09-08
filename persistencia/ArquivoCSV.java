package persistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import enums.EstiloCarro;
import enums.StatusOS;
import modelo.Carro;
import modelo.Cliente;
import modelo.ItemPedido;
import modelo.OrdemServico;
import modelo.Peca;
import modelo.Pedido;
import modelo.Servico;

public class ArquivoCSV {
    public static void salvarPecas(Peca[] pecas, int totalPecas,
            String caminhoArquivo) throws IOException {

        File arquivo = new File(caminhoArquivo);
        File pasta = arquivo.getParentFile();

        if (pasta != null) {
            pasta.mkdirs();
        }

        PrintWriter escritor = new PrintWriter(new FileWriter(arquivo));

        escritor.println("codigo;nome;fabricante;precoCusto;precoVenda;quantidadeEstoque");

        for (int i = 0; i < totalPecas; i++) {
            escritor.println(
                    pecas[i].codigo + ";"
                    + pecas[i].nome + ";"
                    + pecas[i].fabricante + ";"
                    + pecas[i].precoCusto + ";"
                    + pecas[i].precoVenda + ";"
                    + pecas[i].quantidadeEstoque
            );
        }

        escritor.close();
    }

    public static int carregarPecas(Peca[] pecas, String caminhoArquivo)
            throws IOException {

        File arquivo = new File(caminhoArquivo);

        if (!arquivo.exists()) {
            return 0;
        }

        BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
        String linha;
        int totalPecas = 0;

        leitor.readLine();

        while ((linha = leitor.readLine()) != null && totalPecas < pecas.length) {
            String[] dados = linha.split(";");

            Peca peca = new Peca();
            peca.codigo = Integer.parseInt(dados[0]);
            peca.nome = dados[1];
            peca.fabricante = dados[2];
            peca.precoCusto = Double.parseDouble(dados[3]);
            peca.precoVenda = Double.parseDouble(dados[4]);
            peca.quantidadeEstoque = Integer.parseInt(dados[5]);

            Peca.atualizarProximoCodigo(peca.codigo);

            pecas[totalPecas] = peca;
            totalPecas++;
        }

        leitor.close();

        return totalPecas;
    }

    public static void salvarServicos(Servico[] servicos, int totalServicos,
            String caminhoArquivo) throws IOException {

        File arquivo = new File(caminhoArquivo);
        File pasta = arquivo.getParentFile();

        if (pasta != null) {
            pasta.mkdirs();
        }

        PrintWriter escritor = new PrintWriter(new FileWriter(arquivo));

        escritor.println("codigo;descricao;tempoEstimadoMinutos;valorMaoDeObra");

        for (int i = 0; i < totalServicos; i++) {
            escritor.println(
                    servicos[i].codigo + ";"
                    + servicos[i].descricao + ";"
                    + servicos[i].tempoEstimadoMinutos + ";"
                    + servicos[i].valorMaoDeObra
            );
        }

        escritor.close();
    }

    public static int carregarServicos(Servico[] servicos, String caminhoArquivo)
            throws IOException {

        File arquivo = new File(caminhoArquivo);

        if (!arquivo.exists()) {
            return 0;
        }

        BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
        String linha;
        int totalServicos = 0;

        leitor.readLine();

        while ((linha = leitor.readLine()) != null
                && totalServicos < servicos.length) {

            String[] dados = linha.split(";");

            Servico servico = new Servico();
            servico.codigo = Integer.parseInt(dados[0]);
            servico.descricao = dados[1];
            servico.tempoEstimadoMinutos = Integer.parseInt(dados[2]);
            servico.valorMaoDeObra = Double.parseDouble(dados[3]);

            Servico.atualizarProximoCodigo(servico.codigo);

            servicos[totalServicos] = servico;
            totalServicos++;
        }

        leitor.close();

        return totalServicos;
    }

    public static void salvarClientes(Cliente[] clientes, int totalClientes,
            String caminhoArquivo) throws IOException {

        File arquivo = new File(caminhoArquivo);
        File pasta = arquivo.getParentFile();

        if (pasta != null) {
            pasta.mkdirs();
        }

        PrintWriter escritor = new PrintWriter(new FileWriter(arquivo));

        escritor.println("codigo;nome;whatsapp;email");

        for (int i = 0; i < totalClientes; i++) {
            escritor.println(
                    clientes[i].codigo + ";"
                    + clientes[i].nome + ";"
                    + clientes[i].whatsapp + ";"
                    + clientes[i].email
            );
        }

        escritor.close();
    }

    public static int carregarClientes(Cliente[] clientes, String caminhoArquivo)
            throws IOException {

        File arquivo = new File(caminhoArquivo);

        if (!arquivo.exists()) {
            return 0;
        }

        BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
        String linha;
        int totalClientes = 0;

        leitor.readLine();

        while ((linha = leitor.readLine()) != null
                && totalClientes < clientes.length) {

            String[] dados = linha.split(";");

            Cliente cliente = new Cliente(
                    Integer.parseInt(dados[0]),
                    dados[1],
                    dados[2],
                    dados[3]
            );

            clientes[totalClientes] = cliente;
            totalClientes++;
        }

        leitor.close();

        return totalClientes;
    }

    public static void salvarCarros(Cliente[] clientes, int totalClientes,
            String caminhoArquivo) throws IOException {

        File arquivo = new File(caminhoArquivo);
        File pasta = arquivo.getParentFile();

        if (pasta != null) {
            pasta.mkdirs();
        }

        PrintWriter escritor = new PrintWriter(new FileWriter(arquivo));

        escritor.println("codigoCliente;modelo;placa;ano;estilo");

        for (int i = 0; i < totalClientes; i++) {
            for (int j = 0; j < clientes[i].totalCarros; j++) {
                Carro carro = clientes[i].carros[j];

                escritor.println(
                        clientes[i].codigo + ";"
                        + carro.modelo + ";"
                        + carro.placa + ";"
                        + carro.ano + ";"
                        + carro.estilo
                );
            }
        }

        escritor.close();
    }

    public static void carregarCarros(Cliente[] clientes, int totalClientes,
            String caminhoArquivo) throws IOException {

        File arquivo = new File(caminhoArquivo);

        if (!arquivo.exists()) {
            return;
        }

        BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
        String linha;

        leitor.readLine();

        while ((linha = leitor.readLine()) != null) {
            String[] dados = linha.split(";");

            int codigoCliente = Integer.parseInt(dados[0]);
            Cliente cliente = buscarClientePorCodigo(
                    clientes, totalClientes, codigoCliente
            );

            if (cliente != null) {
                Carro carro = new Carro(
                        dados[1],
                        dados[2],
                        Integer.parseInt(dados[3]),
                        EstiloCarro.valueOf(dados[4])
                );

                cliente.adicionarCarro(carro);
            }
        }

        leitor.close();
    }

    public static void salvarPedidos(Pedido[] pedidos, int totalPedidos,
            String caminhoArquivo) throws IOException {

        File arquivo = new File(caminhoArquivo);
        File pasta = arquivo.getParentFile();

        if (pasta != null) {
            pasta.mkdirs();
        }

        PrintWriter escritor = new PrintWriter(new FileWriter(arquivo));

        escritor.println("codigo;percentualDesconto;finalizado");

        for (int i = 0; i < totalPedidos; i++) {
            escritor.println(
                    pedidos[i].codigo + ";"
                    + pedidos[i].percentualDesconto + ";"
                    + pedidos[i].finalizado
            );
        }

        escritor.close();
    }

    public static int carregarPedidos(Pedido[] pedidos, String caminhoArquivo)
            throws IOException {

        File arquivo = new File(caminhoArquivo);

        if (!arquivo.exists()) {
            return 0;
        }

        BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
        String linha;
        int totalPedidos = 0;

        leitor.readLine();

        while ((linha = leitor.readLine()) != null
                && totalPedidos < pedidos.length) {

            String[] dados = linha.split(";");

            Pedido pedido = new Pedido();
            pedido.codigo = Integer.parseInt(dados[0]);
            pedido.percentualDesconto = Double.parseDouble(dados[1]);
            pedido.finalizado = Boolean.parseBoolean(dados[2]);

            Pedido.atualizarProximoCodigo(pedido.codigo);

            pedidos[totalPedidos] = pedido;
            totalPedidos++;
        }

        leitor.close();

        return totalPedidos;
    }

    public static void salvarItensPedidos(Pedido[] pedidos, int totalPedidos,
            String caminhoArquivo) throws IOException {

        File arquivo = new File(caminhoArquivo);
        File pasta = arquivo.getParentFile();

        if (pasta != null) {
            pasta.mkdirs();
        }

        PrintWriter escritor = new PrintWriter(new FileWriter(arquivo));

        escritor.println("codigoPedido;codigoPeca;quantidade");

        for (int i = 0; i < totalPedidos; i++) {
            for (int j = 0; j < pedidos[i].totalItens; j++) {
                ItemPedido item = pedidos[i].itens[j];

                escritor.println(
                        pedidos[i].codigo + ";"
                        + item.peca.codigo + ";"
                        + item.quantidade
                );
            }
        }

        escritor.close();
    }

    public static void carregarItensPedidos(Pedido[] pedidos, int totalPedidos,
            Peca[] pecas, int totalPecas, String caminhoArquivo)
            throws IOException {

        File arquivo = new File(caminhoArquivo);

        if (!arquivo.exists()) {
            return;
        }

        BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
        String linha;

        leitor.readLine();

        while ((linha = leitor.readLine()) != null) {
            String[] dados = linha.split(";");

            Pedido pedido = buscarPedidoPorCodigo(
                    pedidos, totalPedidos, Integer.parseInt(dados[0])
            );

            Peca peca = buscarPecaPorCodigo(
                    pecas, totalPecas, Integer.parseInt(dados[1])
            );

            if (pedido != null && peca != null) {
                boolean estavaFinalizado = pedido.finalizado;

                pedido.finalizado = false;
                pedido.adicionarItem(peca, Integer.parseInt(dados[2]));
                pedido.finalizado = estavaFinalizado;
            }
        }

        leitor.close();
    }

    public static void salvarOrdensServico(OrdemServico[] ordensServico,
            int totalOrdensServico, String caminhoArquivo) throws IOException {

        File arquivo = new File(caminhoArquivo);
        File pasta = arquivo.getParentFile();

        if (pasta != null) {
            pasta.mkdirs();
        }

        PrintWriter escritor = new PrintWriter(new FileWriter(arquivo));

        escritor.println("identificador;status");

        for (int i = 0; i < totalOrdensServico; i++) {
            escritor.println(
                    ordensServico[i].identificador + ";"
                    + ordensServico[i].status
            );
        }

        escritor.close();
    }

    public static int carregarOrdensServico(OrdemServico[] ordensServico,
            String caminhoArquivo) throws IOException {

        File arquivo = new File(caminhoArquivo);

        if (!arquivo.exists()) {
            return 0;
        }

        BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
        String linha;
        int totalOrdensServico = 0;

        leitor.readLine();

        while ((linha = leitor.readLine()) != null
                && totalOrdensServico < ordensServico.length) {

            String[] dados = linha.split(";");

            OrdemServico ordemServico = new OrdemServico();
            ordemServico.identificador = Integer.parseInt(dados[0]);
            ordemServico.status = StatusOS.valueOf(dados[1]);

            OrdemServico.atualizarProximoIdentificador(
                    ordemServico.identificador
            );

            ordensServico[totalOrdensServico] = ordemServico;
            totalOrdensServico++;
        }

        leitor.close();

        return totalOrdensServico;
    }

    public static void salvarServicosOrdensServico(
            OrdemServico[] ordensServico, int totalOrdensServico,
            String caminhoArquivo) throws IOException {

        File arquivo = new File(caminhoArquivo);
        File pasta = arquivo.getParentFile();

        if (pasta != null) {
            pasta.mkdirs();
        }

        PrintWriter escritor = new PrintWriter(new FileWriter(arquivo));

        escritor.println("identificadorOS;codigoServico");

        for (int i = 0; i < totalOrdensServico; i++) {
            for (int j = 0; j < ordensServico[i].totalServicos; j++) {
                escritor.println(
                        ordensServico[i].identificador + ";"
                        + ordensServico[i].servicos[j].codigo
                );
            }
        }

        escritor.close();
    }

    public static void carregarServicosOrdensServico(
            OrdemServico[] ordensServico, int totalOrdensServico,
            Servico[] servicos, int totalServicos, String caminhoArquivo)
            throws IOException {

        File arquivo = new File(caminhoArquivo);

        if (!arquivo.exists()) {
            return;
        }

        BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
        String linha;

        leitor.readLine();

        while ((linha = leitor.readLine()) != null) {
            String[] dados = linha.split(";");

            OrdemServico ordemServico = buscarOrdemServicoPorIdentificador(
                    ordensServico, totalOrdensServico,
                    Integer.parseInt(dados[0])
            );

            Servico servico = buscarServicoPorCodigo(
                    servicos, totalServicos, Integer.parseInt(dados[1])
            );

            if (ordemServico != null && servico != null) {
                StatusOS statusAnterior = ordemServico.status;

                ordemServico.status = StatusOS.EM_ABERTO;
                ordemServico.adicionarServico(servico);
                ordemServico.status = statusAnterior;
            }
        }

        leitor.close();
    }

    private static Cliente buscarClientePorCodigo(Cliente[] clientes,
            int totalClientes, int codigo) {

        for (int i = 0; i < totalClientes; i++) {
            if (clientes[i].codigo == codigo) {
                return clientes[i];
            }
        }

        return null;
    }

    private static Peca buscarPecaPorCodigo(Peca[] pecas, int totalPecas,
            int codigo) {

        for (int i = 0; i < totalPecas; i++) {
            if (pecas[i].codigo == codigo) {
                return pecas[i];
            }
        }

        return null;
    }

    private static Servico buscarServicoPorCodigo(Servico[] servicos,
            int totalServicos, int codigo) {

        for (int i = 0; i < totalServicos; i++) {
            if (servicos[i].codigo == codigo) {
                return servicos[i];
            }
        }

        return null;
    }

    private static Pedido buscarPedidoPorCodigo(Pedido[] pedidos,
            int totalPedidos, int codigo) {

        for (int i = 0; i < totalPedidos; i++) {
            if (pedidos[i].codigo == codigo) {
                return pedidos[i];
            }
        }

        return null;
    }

    private static OrdemServico buscarOrdemServicoPorIdentificador(
            OrdemServico[] ordensServico, int totalOrdensServico,
            int identificador) {

        for (int i = 0; i < totalOrdensServico; i++) {
            if (ordensServico[i].identificador == identificador) {
                return ordensServico[i];
            }
        }

        return null;
    }
}