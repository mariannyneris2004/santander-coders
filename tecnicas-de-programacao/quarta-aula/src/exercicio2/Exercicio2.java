package exercicio2;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        List<Produto> produtos = List.of(
                new Produto("Notebook", 2500.0),
                new Produto("Camisa", 50.0),
                new Produto("Smartphone", 1200.0),
                new Produto("Tênis", 150.0)
        );

        System.out.println("O produto mais caro é: ");

        System.out.println(produtos.stream().max(Comparator.comparing(Produto::getPreco)));
    }
}
