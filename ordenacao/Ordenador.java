package ordenacao;

import enums.CriterioOrdenacao;
import modelo.Peca;
import modelo.Servico;

public class Ordenador {
    public static void ordenarPecas(Peca[] pecas, int totalPecas,
            CriterioOrdenacao criterio) {

        for (int i = 0; i < totalPecas - 1; i++) {
            for (int j = 0; j < totalPecas - 1 - i; j++) {
                if (deveTrocarPeca(pecas[j], pecas[j + 1], criterio)) {
                    Peca auxiliar = pecas[j];
                    pecas[j] = pecas[j + 1];
                    pecas[j + 1] = auxiliar;
                }
            }
        }
    }

    public static void ordenarServicos(Servico[] servicos, int totalServicos,
            CriterioOrdenacao criterio) {

        for (int i = 0; i < totalServicos - 1; i++) {
            for (int j = 0; j < totalServicos - 1 - i; j++) {
                if (deveTrocarServico(servicos[j], servicos[j + 1], criterio)) {
                    Servico auxiliar = servicos[j];
                    servicos[j] = servicos[j + 1];
                    servicos[j + 1] = auxiliar;
                }
            }
        }
    }

    private static boolean deveTrocarPeca(Peca pecaAtual, Peca proximaPeca,
            CriterioOrdenacao criterio) {

        if (criterio == CriterioOrdenacao.NOME) {
            return pecaAtual.nome.compareToIgnoreCase(proximaPeca.nome) > 0;
        }

        return pecaAtual.codigo > proximaPeca.codigo;
    }

    private static boolean deveTrocarServico(Servico servicoAtual,
            Servico proximoServico, CriterioOrdenacao criterio) {

        if (criterio == CriterioOrdenacao.NOME) {
            return servicoAtual.descricao
                    .compareToIgnoreCase(proximoServico.descricao) > 0;
        }

        return servicoAtual.codigo > proximoServico.codigo;
    }
}