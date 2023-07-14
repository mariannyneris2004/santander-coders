import java.util.Scanner;

public class Main {
    public static double calculoFrutaPreco(Fruta fruta){
        double precoFinalPorFruta, precoNormal = 1.45, precoPromocional = 1.25;

        if (fruta.getQuantidade() > 10){
            precoFinalPorFruta = fruta.getQuantidade() * precoPromocional;
        } else {
            precoFinalPorFruta = fruta.getQuantidade() * precoNormal;
        }

        return precoFinalPorFruta;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Fruta fruta = new Fruta();
        double precoPorTipoDeFruta, precoFinal = 0;

        System.out.printf("FRUTARIA DA MARIA:\n\nFrutas promocionais:\nPera\nLaranja\nMaçã\nTomate\nCaqui");
        System.out.println("\n(Digite 0 na quantidade caso queira encerrar a compra)");

        do {
            System.out.println("\nQual fruta deseja comprar? ");
            fruta.setNome(scanner.next());
            System.out.println("Qual a quantidade desejada? ");
            fruta.setQuantidade(scanner.nextInt());

            if(fruta.getQuantidade() !=0) {
                precoPorTipoDeFruta = calculoFrutaPreco(fruta);

                System.out.printf("A fruta %s sairá a R$%.2f.", fruta.getNome(), precoPorTipoDeFruta);

                precoFinal += precoPorTipoDeFruta;
            }

        } while (fruta.getQuantidade() != 0);

        System.out.printf("A compra final é de R$%.2f", precoFinal);

        scanner.close();
    }
}