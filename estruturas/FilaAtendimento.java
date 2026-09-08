package estruturas;

import enums.StatusOS;
import modelo.OrdemServico;

public class FilaAtendimento {
    public OrdemServico[] fila;
    public int inicio;
    public int fim;
    public int total;

    public FilaAtendimento(int capacidade) {
        fila = new OrdemServico[capacidade];
        inicio = 0;
        fim = 0;
        total = 0;
    }

    public boolean estaVazia() {
        return total == 0;
    }

    public boolean estaCheia() {
        return total == fila.length;
    }

    public boolean enfileirar(OrdemServico ordemServico) {
        if (ordemServico == null) {
            System.out.println("Ordem de servico invalida.");
            return false;
        }

        if (ordemServico.status == StatusOS.FINALIZADA) {
            System.out.println("Nao e possivel colocar uma OS finalizada na fila.");
            return false;
        }

        if (estaCheia()) {
            System.out.println("A fila de atendimento esta cheia.");
            return false;
        }

        ordemServico.alterarStatus(StatusOS.AGUARDANDO_EXECUCAO);

        fila[fim] = ordemServico;
        fim = (fim + 1) % fila.length;
        total++;

        return true;
    }

    public OrdemServico desenfileirar() {
        if (estaVazia()) {
            System.out.println("A fila de atendimento esta vazia.");
            return null;
        }

        OrdemServico ordemServico = fila[inicio];
        fila[inicio] = null;
        inicio = (inicio + 1) % fila.length;
        total--;

        ordemServico.alterarStatus(StatusOS.EM_EXECUCAO);

        return ordemServico;
    }

    public void exibirFila() {
        System.out.println("====================================");
        System.out.println("FILA DE ATENDIMENTO");
        System.out.println("------------------------------------");

        if (estaVazia()) {
            System.out.println("Nenhuma OS aguardando atendimento.");
        } else {
            for (int i = 0; i < total; i++) {
                int indice = (inicio + i) % fila.length;

                System.out.println((i + 1) + " - OS "
                        + fila[indice].identificador
                        + " | Status: " + fila[indice].status);
            }
        }

        System.out.println("====================================");
    }
}