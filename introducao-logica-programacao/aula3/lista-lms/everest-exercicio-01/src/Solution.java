import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int quantidadeDeFrutas;
        double precoFinal;

        System.out.println("FRUTA\nPera\nLaranja\nMaçã\nTomate\nCaqui");

        System.out.println("Qual a quantidade desejada da fruta: ");
        quantidadeDeFrutas = scanner.nextInt();

        precoFinal = custoCompra(quantidadeDeFrutas);

        System.out.println("Ex:");
        System.out.println("Entrada: " + quantidadeDeFrutas);
        System.out.printf("Saída: %.2f", precoFinal);

        scanner.close();
    }
    public static double custoCompra(double input) {
        double precoFinal;
        final double precoPromocao = 1.25;
        final double precoNormal = 1.45;

        if(input > 10){
            precoFinal = input * precoPromocao;
        } else {
            precoFinal = input * precoNormal;
        }

        return precoFinal;
    }
}