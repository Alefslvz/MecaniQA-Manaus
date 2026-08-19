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

    public static int inserirServico(Servico[] servicos, int totalServicos, Servico novoServico) {
        servicos[totalServicos] = novoServico;
        totalServicos++;

        return totalServicos;
    }

    public static int buscarServicoPorCodigo(Servico[] servicos, int totalServicos, int codigo) {
        for (int i = 0; i < totalServicos; i++) {
            if (servicos[i].codigo == codigo) {
                return i;
            }
        }

        return -1;
    }

    public static int removerServico(Servico[] servicos, int totalServicos, int codigo) {
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
}