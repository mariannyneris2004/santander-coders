package tech.ada.ecommerce.model;

import jakarta.persistence.*;
import tech.ada.ecommerce.model.enums.StatusEnum;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    private Date dataCompra;

    private double valorProdutos;

    private double desconto;

    private double valorFrete;

    private double valorTotal;

    @OneToMany
    private List<ItemProduto> itens;

    @Enumerated(value = EnumType.STRING)
    private StatusEnum status;

    public Compra() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public double getValorProdutos() {
        return valorProdutos;
    }

    public void setValorProdutos(double valorProdutos) {
        this.valorProdutos = valorProdutos;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(double valorFrete) {
        this.valorFrete = valorFrete;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<ItemProduto> getItens() {
        return itens;
    }

    public void setItens(List<ItemProduto> itens) {
        this.itens = itens;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Compra compra = (Compra) o;
        return Objects.equals(id, compra.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
