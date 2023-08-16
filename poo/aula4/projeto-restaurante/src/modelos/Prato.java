package modelos;

public class Prato {
    private int id;
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

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    @Override
    public String toString() {
        return "\n" +
                nome + " ---------------- R$" + preco + "\n" +
                descricao + "\n" +
                "-----------------------\n";
    }
}
