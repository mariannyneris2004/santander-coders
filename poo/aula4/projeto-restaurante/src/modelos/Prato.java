package modelos;

import java.util.ArrayList;

public class Prato {
    private String nome;
    private double preco;
    private String descricao;
    private Restaurante restaurante;

    public Prato(String nome, double preco, String descricao, Restaurante restaurante) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.restaurante = restaurante;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    @Override
    public String toString() {
        return "-----------------------\n" +
                nome + " ---------------- R$" + preco + "\n" +
                descricao + "\n" +
                "-----------------------\n";
    }
}
