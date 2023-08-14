import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Veiculo veiculo = null;

        System.out.println("1 - Carro\n2 - Moto\n3 - Caminhão");
        System.out.println("Informe o tipo de veículo: ");
        String opcao = scanner.next();

        System.out.println("Informe a placa: ");
        String placa = scanner.next();

        System.out.println("Informe a cor: ");
        String cor = scanner.next();

        System.out.println("Informe o ano do veículo: ");
        int ano = scanner.nextInt();

        System.out.println("Informe o modelo: ");
        String modelo = scanner.next();

        if (opcao.equals("1")){
            System.out.println("Informe o tipo de combustível: ");
            String tipoCombustivel = scanner.next();

            System.out.println("Informe a quantidade de portas: ");
            int quantidadePortas = scanner.nextInt();

            veiculo = new Carro(placa, modelo, cor, ano, quantidadePortas, tipoCombustivel);

        } else if (opcao.equals("2")) {
            System.out.println("Informe as cilindradas: ");
            int cilindradas = scanner.nextInt();

            veiculo = new Moto(placa, modelo, cor, ano, cilindradas);

        } else if (opcao.equals("3")) {
            System.out.println("Informe a quantidade de rodas: ");
            int quantidadeRodas = scanner.nextInt();

            veiculo = new Caminhao(placa, modelo, cor, ano, quantidadeRodas);
        }

        imprimirDados(veiculo);

        aplicandoMulta(veiculo);

        scanner.close();
    }

    public static void aplicandoMulta(Veiculo veiculo){
        System.out.println("Aplicando multa para " + veiculo.getModelo() + " de placa " + veiculo.getPlaca());
    }

    public static void imprimirDados(Veiculo veiculo){
        veiculo.exibirDados();
    }
}