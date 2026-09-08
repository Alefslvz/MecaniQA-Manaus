package modelo;

public class Peca {
    private static int proximoCodigo = 1;

    public int codigo;
    public String nome;
    public String fabricante;
    public double precoCusto;
    public double precoVenda;
    public int quantidadeEstoque;

    public Peca() {
        codigo = proximoCodigo;
        proximoCodigo++;
    }

    public static void atualizarProximoCodigo(int ultimoCodigoCarregado) {
        if (ultimoCodigoCarregado >= proximoCodigo) {
            proximoCodigo = ultimoCodigoCarregado + 1;
        }
    }
}