package modelo;

public class Pedido {
    private static int proximoCodigo = 1;

    public int codigo;
    public ItemPedido[] itens;
    public int totalItens;
    public double percentualDesconto;
    public boolean finalizado;

    public Pedido() {
        codigo = proximoCodigo;
        proximoCodigo++;

        itens = new ItemPedido[50];
        totalItens = 0;
        percentualDesconto = 0;
        finalizado = false;
    }

    public static void atualizarProximoCodigo(int ultimoCodigoCarregado) {
        if (ultimoCodigoCarregado >= proximoCodigo) {
            proximoCodigo = ultimoCodigoCarregado + 1;
        }
    }

    public boolean adicionarItem(Peca peca, int quantidade) {
        if (finalizado) {
            System.out.println("Nao e possivel adicionar itens: o pedido ja foi finalizado.");
            return false;
        }

        if (peca == null || quantidade <= 0) {
            System.out.println("Peca ou quantidade invalida.");
            return false;
        }

        if (totalItens >= itens.length) {
            System.out.println("Limite de itens do pedido atingido.");
            return false;
        }

        itens[totalItens] = new ItemPedido(peca, quantidade);
        totalItens++;

        return true;
    }

    public boolean aplicarDesconto(double novoPercentualDesconto) {
        if (finalizado) {
            System.out.println("Nao e possivel alterar o desconto: o pedido ja foi finalizado.");
            return false;
        }

        if (novoPercentualDesconto < 0 || novoPercentualDesconto > 100) {
            System.out.println("O desconto deve estar entre 0 e 100.");
            return false;
        }

        percentualDesconto = novoPercentualDesconto;

        return true;
    }

    public double calcularValorBruto() {
        double valorBruto = 0;

        for (int i = 0; i < totalItens; i++) {
            valorBruto += itens[i].calcularSubtotal();
        }

        return valorBruto;
    }

    public double calcularValorDesconto() {
        return calcularValorBruto() * percentualDesconto / 100;
    }

    public double calcularValorTotal() {
        return calcularValorBruto() - calcularValorDesconto();
    }

    public boolean finalizarPedido() {
        if (finalizado) {
            System.out.println("O pedido ja esta finalizado.");
            return false;
        }

        if (totalItens == 0) {
            System.out.println("Nao e possivel finalizar um pedido sem itens.");
            return false;
        }

        finalizado = true;

        return true;
    }

    public void gerarRelatorio() {
        System.out.println("====================================");
        System.out.println("RELATORIO DO PEDIDO");
        System.out.println("Codigo do pedido: " + codigo);
        System.out.println("Status: " + (finalizado ? "FINALIZADO" : "EM ABERTO"));
        System.out.println("------------------------------------");

        for (int i = 0; i < totalItens; i++) {
            itens[i].exibirDados();
            System.out.println("------------------------------------");
        }

        System.out.println("Valor bruto: R$ " + calcularValorBruto());
        System.out.println("Desconto: " + percentualDesconto + "%");
        System.out.println("Valor do desconto: R$ " + calcularValorDesconto());
        System.out.println("Valor total: R$ " + calcularValorTotal());
        System.out.println("====================================");
    }
}