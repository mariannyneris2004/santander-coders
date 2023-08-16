package modelos;

import java.util.HashMap;
import java.util.Map;

public class Restaurante {
    private int id;
    private String nome;
    private String endereco;
    private Map<Integer, Prato> pratosDisponiveis;

    public Restaurante(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.pratosDisponiveis = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void adicionarPrato(Integer id, Prato prato){
        this.pratosDisponiveis.put(id, prato);
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
