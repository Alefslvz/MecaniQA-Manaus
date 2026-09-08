package modelo;

public class ItemPedido {
    public Peca peca;
    public int quantidade;

    public ItemPedido(Peca peca, int quantidade) {
        this.peca = peca;
        this.quantidade = quantidade;
    }

    public double calcularSubtotal() {
        return peca.precoVenda * quantidade;
    }

    public void exibirDados() {
        System.out.println("Codigo da peca: " + peca.codigo);
        System.out.println("Nome da peca: " + peca.nome);
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Preco unitario: R$ " + peca.precoVenda);
        System.out.println("Subtotal: R$ " + calcularSubtotal());
    }
}