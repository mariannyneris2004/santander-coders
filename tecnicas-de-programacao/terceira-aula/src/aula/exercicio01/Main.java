package aula.exercicio01;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        List<Produto> carrinho = new ArrayList<>();
        carrinho.add(new Produto("Produto 1", 10.0));
        carrinho.add(new Produto("Produto 2", 20.0));
        carrinho.add(new Produto("Produto 3", 30.0));
        carrinho.add(new Produto("Produto 4", 10.0));
        carrinho.add(new Produto("Produto 5", 20.0));
        carrinho.add(new Produto("Produto 6", 30.0));

        Function<List<Produto>, Double> calcularTotal = (listaProdutos) -> {
            double total = 0;
            for (Produto produto : listaProdutos) {
                total += produto.getPreco();
            }
            return total;
        };

        double total = calcular(carrinho, calcularTotal);

        System.out.println("Total do carrinho: " + total);
    }

    public static double calcular(List<Produto> carrinho, Function<List<Produto>, Double> calcularTotal) {
        return calcularTotal.apply(carrinho);
    }
}
