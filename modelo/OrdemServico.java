package modelo;

import enums.StatusOS;

public class OrdemServico {
    private static int proximoIdentificador = 1;

    public int identificador;
    public Servico[] servicos;
    public int totalServicos;
    public StatusOS status;

    public OrdemServico() {
        identificador = proximoIdentificador;
        proximoIdentificador++;

        servicos = new Servico[50];
        totalServicos = 0;
        status = StatusOS.EM_ABERTO;
    }

    public static void atualizarProximoIdentificador(
            int ultimoIdentificadorCarregado) {

        if (ultimoIdentificadorCarregado >= proximoIdentificador) {
            proximoIdentificador = ultimoIdentificadorCarregado + 1;
        }
    }

    public boolean adicionarServico(Servico novoServico) {
        if (status == StatusOS.FINALIZADA) {
            System.out.println("Nao e possivel adicionar servicos: a OS esta finalizada.");
            return false;
        }

        if (novoServico == null) {
            System.out.println("Servico invalido.");
            return false;
        }

        if (totalServicos >= servicos.length) {
            System.out.println("Limite de servicos da OS atingido.");
            return false;
        }

        servicos[totalServicos] = novoServico;
        totalServicos++;

        return true;
    }

    public boolean removerServico(int codigoServico) {
        if (status == StatusOS.FINALIZADA) {
            System.out.println("Nao e possivel remover servicos: a OS esta finalizada.");
            return false;
        }

        int indice = -1;

        for (int i = 0; i < totalServicos; i++) {
            if (servicos[i].codigo == codigoServico) {
                indice = i;
                break;
            }
        }

        if (indice == -1) {
            System.out.println("Servico nao encontrado na OS.");
            return false;
        }

        for (int i = indice; i < totalServicos - 1; i++) {
            servicos[i] = servicos[i + 1];
        }

        servicos[totalServicos - 1] = null;
        totalServicos--;

        return true;
    }

    public int quantidadeServicos() {
        return totalServicos;
    }

    public double valorTotal() {
        double total = 0;

        for (int i = 0; i < totalServicos; i++) {
            total += servicos[i].valorMaoDeObra;
        }

        return total;
    }

    public void tabelaServicos() {
        System.out.println("====================================");
        System.out.println("ORDEM DE SERVICO: " + identificador);
        System.out.println("Status: " + status);
        System.out.println("------------------------------------");

        if (totalServicos == 0) {
            System.out.println("Nenhum servico adicionado.");
        } else {
            for (int i = 0; i < totalServicos; i++) {
                System.out.println("Codigo: " + servicos[i].codigo);
                System.out.println("Descricao: " + servicos[i].descricao);
                System.out.println("Tempo estimado: "
                        + servicos[i].tempoEstimadoMinutos + " minutos");
                System.out.println("Valor: R$ " + servicos[i].valorMaoDeObra);
                System.out.println("------------------------------------");
            }
        }

        System.out.println("Quantidade de servicos: " + quantidadeServicos());
        System.out.println("Valor total: R$ " + valorTotal());
        System.out.println("====================================");
    }

    public boolean alterarStatus(StatusOS novoStatus) {
        if (status == StatusOS.FINALIZADA) {
            System.out.println("Nao e possivel alterar o status: a OS esta finalizada.");
            return false;
        }

        if (novoStatus == null) {
            System.out.println("Status invalido.");
            return false;
        }

        status = novoStatus;

        return true;
    }

    public boolean finalizarOS() {
        if (status == StatusOS.FINALIZADA) {
            System.out.println("A OS ja esta finalizada.");
            return false;
        }

        status = StatusOS.FINALIZADA;

        return true;
    }
}