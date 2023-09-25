package exercicio1;

import java.util.List;
import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Produtos> produtos = List.of(
                new Produtos("Notebook", "Eletrônicos"),
                new Produtos("Camisa", "Vestuário"),
                new Produtos("Smartphone", "Eletrônicos"),
                new Produtos("Tênis", "Calçados") );

        System.out.println("Escreva a categoria que deseja pesquisar: ");
        String categoria = scanner.next();

        produtos.stream().filter(n -> n.getCategoria().equals(categoria))
                .forEach(n -> System.out.println(n.toString()));

        scanner.close();
    }
}
