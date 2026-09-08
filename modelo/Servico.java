package modelo;

public class Servico {
    private static int proximoCodigo = 1;

    public int codigo;
    public String descricao;
    public int tempoEstimadoMinutos;
    public double valorMaoDeObra;

    public Servico() {
        codigo = proximoCodigo;
        proximoCodigo++;
    }

    public static void atualizarProximoCodigo(int ultimoCodigoCarregado) {
        if (ultimoCodigoCarregado >= proximoCodigo) {
            proximoCodigo = ultimoCodigoCarregado + 1;
        }
    }
}