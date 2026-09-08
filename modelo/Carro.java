package modelo;

import enums.EstiloCarro;

public class Carro {
    public String modelo;
    public String placa;
    public int ano;
    public EstiloCarro estilo;

    public Carro(String modelo, String placa, int ano, EstiloCarro estilo) {
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
        this.estilo = estilo;
    }

    public void exibirDados() {
        System.out.println("Modelo: " + modelo);
        System.out.println("Placa: " + placa);
        System.out.println("Ano: " + ano);
        System.out.println("Estilo: " + estilo);
    }
}