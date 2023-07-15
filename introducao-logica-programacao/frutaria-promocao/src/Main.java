import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Fruta fruta = new Fruta();

        String[] frutasCadastradas = {"Pera", "Laranja", "Maçã", "Tomate", "Caqui"};
        double precoPorTipoDeFruta, precoFinal = 0;
        double[] precosPorTipoDeFruta = new double[frutasCadastradas.length];

        System.out.printf("FRUTARIA DA MARIA:\n");
        for (int i = 0; i < frutasCadastradas.length; i++) {
            fruta.setNome(frutasCadastradas[i]);
            System.out.println("Qual a quantidade desejada de " + frutasCadastradas[i] + "? ");
            fruta.setQuantidade(scanner.nextInt());
            precoPorTipoDeFruta = Calculos.calculoFrutaPreco(fruta);
            precosPorTipoDeFruta[i] = precoPorTipoDeFruta;
        }

        precoFinal = Calculos.calculoTotalAPagar(precosPorTipoDeFruta);

        System.out.printf("A compra final é de R$%.2f", precoFinal);

        scanner.close();
    }
}