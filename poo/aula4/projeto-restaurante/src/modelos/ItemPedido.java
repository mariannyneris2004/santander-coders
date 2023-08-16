package modelos;

public class ItemPedido {
    private int id;
    private Prato prato;
    private int quantidade;
    private double valorUnitario;

    public ItemPedido(Prato prato, int quantidade, double valorUnitario) {
        this.prato = prato;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Prato getPrato() {
        return prato;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public double valorTotal(){
        return quantidade * valorUnitario;
    }

    @Override
    public String toString() {
        return "\nPrato: " + getPrato().getNome() + "\n" +
                "Quantidade: " + getQuantidade() + "\n" +
                "Valor Unitário: R$" + getValorUnitario() + "\n" +
                "Valor total: R$" + valorTotal() + "\n";
    }
}
