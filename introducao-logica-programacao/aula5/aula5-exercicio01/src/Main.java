import java.util.Scanner;

//
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fruta;
        int quantidade;
        double precoFinal;

        System.out.println("Informe a fruta da promoção: ");
        fruta = scanner.nextLine();
        System.out.println("Informe a quantidade: ");
        quantidade = scanner.nextInt();

        try {
            precoFinal = calculoPromocao(quantidade);
            System.out.println("O preço final é de R$" + precoFinal);
        } catch (NumeroInvalidoException e){
            System.out.println(e.getMessage());
        }

        scanner.close();
    }

    public static double calculoPromocao(int quantidade) throws NumeroInvalidoException{
        double precoFinal, precoPorUnidade;

        validarValor(quantidade);
        if (quantidade > 10){
            precoPorUnidade = 1.25;
        } else {
            precoPorUnidade = 1.45;
        }

        precoFinal = precoPorUnidade * quantidade;
        return precoFinal;
    }

    /*public static boolean pertenceAPromocao(String fruta){
        String[] frutasDaPromocao = {"Pera",
                "Laranja",
                "Maçã",
                "Tomate",
                "Caqui"};


        return true;
    }*/

    public static void validarValor(int quantidade) throws NumeroInvalidoException{
        if(quantidade == 0){
            throw new NumeroInvalidoException("Não é possível realizar um pedido sem itens.");
        } else if (quantidade < 0) {
            throw new NumeroInvalidoException("Quantidade de itens fornecidos é inválido.");
        }
    }
}