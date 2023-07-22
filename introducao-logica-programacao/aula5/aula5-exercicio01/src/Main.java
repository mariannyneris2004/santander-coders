import java.util.Scanner;

//Exercício com validação se a fruta pertence a promoção ou não.
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
            precoFinal = calculoPromocao(fruta, quantidade);
            System.out.println("O preço final é de R$" + precoFinal);
        } catch (NumeroInvalidoException e){
            System.out.println(e.getMessage());
        }

        scanner.close();
    }

    public static double calculoPromocao(String fruta, int quantidade) throws NumeroInvalidoException{
        double precoFinal, precoPorUnidade;
        boolean temNaPromocao = pertenceAPromocao(fruta);

        validarValor(quantidade);
        if (temNaPromocao == true){
            if (quantidade > 10){
                precoPorUnidade = 1.25;
            } else {
                precoPorUnidade = 1.45;
            }
        } else {
            precoPorUnidade = 1.45;
            System.out.println(fruta + " não pertence à promoção!");
        }

        precoFinal = precoPorUnidade * quantidade;

        return precoFinal;
    }

    public static boolean pertenceAPromocao(String fruta){
        String[] frutasDaPromocao = {"Pera",
                "Laranja",
                "Maçã",
                "Tomate",
                "Caqui"};

        for (int i = 0; i < frutasDaPromocao.length; i++) {
            if (frutasDaPromocao[i].toUpperCase().equals(fruta.toUpperCase())){
                return true;
            }
        }

        return false;
    }

    public static void validarValor(int quantidade) throws NumeroInvalidoException{
        if(quantidade == 0){
            throw new NumeroInvalidoException("Não é possível realizar um pedido sem itens.");
        } else if (quantidade < 0) {
            throw new NumeroInvalidoException("Quantidade de itens fornecidos é inválido.");
        }
    }
}