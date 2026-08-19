public class Main {
    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("        MECANIQA MANAGER");
        System.out.println("   Estoque e Servicos Automotivos");
        System.out.println("====================================");

        Peca[] pecas = new Peca[100];
        Servico[] servicos = new Servico[50];

        int totalPecas = 0;
        int totalServicos = 0;

        Peca pecaTeste = new Peca();

        pecaTeste.codigo = 1;
        pecaTeste.nome = "Filtro de oleo";
        pecaTeste.fabricante = "Bosch";
        pecaTeste.precoCusto = 20.00;
        pecaTeste.precoVenda = 35.90;
        pecaTeste.quantidadeEstoque = 10;

        totalPecas = Gerenciador.inserirPeca(pecas, totalPecas, pecaTeste);

        System.out.println("Peca cadastrada:");
        System.out.println("Codigo: " + pecas[0].codigo);
        System.out.println("Nome: " + pecas[0].nome);
        System.out.println("Fabricante: " + pecas[0].fabricante);
        System.out.println("Preco venda: R$ " + pecas[0].precoVenda);
        System.out.println("Quantidade: " + pecas[0].quantidadeEstoque);

        int indiceEncontrado = Gerenciador.buscarPecaPorCodigo(pecas, totalPecas, 1);

        System.out.println("Indice encontrado: " + indiceEncontrado);

        totalPecas = Gerenciador.removerPeca(pecas, totalPecas, 1);

        System.out.println("Total de pecas apos remocao: " + totalPecas);

        System.out.println("------------------------------------");

        Servico servicoTeste = new Servico();

        servicoTeste.codigo = 1;
        servicoTeste.descricao = "Troca de oleo";
        servicoTeste.tempoEstimadoMinutos = 40;
        servicoTeste.valorMaoDeObra = 80.00;

        totalServicos = Gerenciador.inserirServico(servicos, totalServicos, servicoTeste);

        System.out.println("Servico cadastrado:");
        System.out.println("Codigo: " + servicos[0].codigo);
        System.out.println("Descricao: " + servicos[0].descricao);
        System.out.println("Tempo estimado: " + servicos[0].tempoEstimadoMinutos + " minutos");
        System.out.println("Valor mao de obra: R$ " + servicos[0].valorMaoDeObra);

        int indiceServicoEncontrado = Gerenciador.buscarServicoPorCodigo(servicos, totalServicos, 1);

        System.out.println("Indice do servico encontrado: " + indiceServicoEncontrado);

        totalServicos = Gerenciador.removerServico(servicos, totalServicos, 1);

        System.out.println("Total de servicos apos remocao: " + totalServicos);
    }
}