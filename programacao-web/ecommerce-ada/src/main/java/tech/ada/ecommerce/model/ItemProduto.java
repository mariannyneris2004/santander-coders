package tech.ada.ecommerce.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class ItemProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
//    @JoinColumn(name = "compra_valor_produtos", referencedColumnName = "valor_produtos")
    private Compra compra;

    @ManyToOne
    private Produto produto;

    private long qtd;

    private double valorTotalProduto;

    public ItemProduto() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public long getQtd() {
        return qtd;
    }

    public void setQtd(long qtd) {
        this.qtd = qtd;
    }

    public double getValorTotalProduto() {
        return valorTotalProduto;
    }

    public void setValorTotalProduto(double valorTotalProduto) {
        this.valorTotalProduto = valorTotalProduto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemProduto that = (ItemProduto) o;
        return Objects.equals(id, that.id) && Objects.equals(compra, that.compra) && Objects.equals(produto, that.produto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, compra, produto);
    }
}
