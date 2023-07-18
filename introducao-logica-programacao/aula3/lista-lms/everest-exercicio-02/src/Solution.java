import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] compraCarro = new double[3];
        double[] percentuais = new double[2];

        System.out.println("Escreva o valor do carro: ");
        compraCarro[0] = scanner.nextDouble();
        System.out.println("Escreva o valor do custo com o distribuidor: ");
        compraCarro[1] = scanner.nextDouble();
        System.out.println("Escreva o valor do preço dos impostos: ");
        compraCarro[2] = scanner.nextDouble();

        percentuais = custosCarro(compraCarro);

        System.out.println(Arrays.toString(compraCarro));
        System.out.println(Arrays.toString(percentuais));
        scanner.close();
    }
    public static double[] custosCarro(double[] input) {
        double[] percentuais = new double[2];

        percentuais[0] = (input[1] / input[0]) * 100.00;
        percentuais[1] = (input[2] / input[0]) * 100.00;

        percentuais[0] = formatacao(percentuais[0]);
        percentuais[1] = formatacao(percentuais[1]);

        return percentuais;
    }
    public static double formatacao(double valor) {
        int valorInteiro = (int) (valor * 1000.00);
        double valorFormatado = Math.round(valor * 100.00) / 100.00;

        if(valorInteiro % 5 == 0) {
            valorFormatado = Math.floor(valor * 100.00) / 100.00;
        }

        return valorFormatado;
    }
}
