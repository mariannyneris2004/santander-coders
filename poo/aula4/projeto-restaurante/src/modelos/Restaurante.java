package modelos;

import java.util.List;

public class Restaurante {
    private String nome;
    private String endereco;
    private List<Prato> pratosDisponiveis;

    public Restaurante(String nome, String endereco, List<Prato> pratosDisponiveis) {
        this.nome = nome;
        this.endereco = endereco;
        this.pratosDisponiveis = pratosDisponiveis;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "--------------------------------\n" +
                "Restaurante " + nome + "\n" +
                "Endereço: " + endereco + "\n" +
                "--------------------------------\n";
    }
}
