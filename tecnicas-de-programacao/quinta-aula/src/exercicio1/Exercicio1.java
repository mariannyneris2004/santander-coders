package exercicio1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Exercicio1 {
    public static void main(String[] args) {
        List<Produto> produtos = Arrays.asList(
                new Produto("Notebook", 2500.0, 10),
                new Produto("Impressora", 800.0, 5),
                new Produto("Mouse", 50.0, 20),
                new Produto("Teclado", 100.0, 15)
        );

        System.out.println("Produtos com preço acima de R$500,00: ");
        produtos.stream().filter(p -> p.getPreco() > 500).forEach(p -> System.out.println(p.getNome()));
        System.out.println();

        System.out.println("Lista de preço dos produtos: ");
        produtos.stream().map(p -> p.getPreco()).forEach(p -> System.out.println(p));
        System.out.println();

        System.out.println("Produto mais barato: ");
        System.out.println(produtos.stream().min(Comparator.comparing(p -> p.getPreco())).toString());
        System.out.println();

        System.out.println("Produtos cuja quantidade seja menor que 10: ");
        produtos.stream().filter(p -> p.getQuantidade() < 10).forEach(p -> System.out.println(p.getNome()));
        System.out.println();
    }
}
