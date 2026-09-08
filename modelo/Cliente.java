package modelo;

public class Cliente {
    public int codigo;
    public String nome;
    public String whatsapp;
    public String email;

    public Carro[] carros;
    public int totalCarros;

    public Cliente(int codigo, String nome, String whatsapp, String email) {
        this.codigo = codigo;
        this.nome = nome;
        this.whatsapp = whatsapp;
        this.email = email;

        carros = new Carro[10];
        totalCarros = 0;
    }

    public boolean adicionarCarro(Carro novoCarro) {
        if (totalCarros < carros.length) {
            carros[totalCarros] = novoCarro;
            totalCarros++;

            return true;
        }

        return false;
    }

    public void exibirDados() {
        System.out.println("Codigo: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("WhatsApp: " + whatsapp);
        System.out.println("E-mail: " + email);
        System.out.println("Quantidade de carros: " + totalCarros);
    }

    public void exibirCarros() {
        System.out.println("Carros do cliente:");

        if (totalCarros == 0) {
            System.out.println("Nenhum carro cadastrado.");
            return;
        }

        for (int i = 0; i < totalCarros; i++) {
            System.out.println("------------------------------------");
            carros[i].exibirDados();
        }
    }
}