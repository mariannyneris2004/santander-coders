import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] informacoesFuncionario = new double[3];
        double salario;

        System.out.printf("Informe quantos anos trabalhados: ");
        informacoesFuncionario[0] = scanner.nextDouble();
        System.out.printf("Informe o valor da inflação: ");
        informacoesFuncionario[1] = scanner.nextDouble();
        System.out.printf("Informe o salário do funcionário: ");
        informacoesFuncionario[2] = scanner.nextDouble();

        salario = calculoSalario(informacoesFuncionario);

        System.out.println("Ex: ");
        System.out.println("Entrada: " + Arrays.toString(informacoesFuncionario));
        System.out.printf("Saída: %.2f", salario);

        scanner.close();
    }
    public static double calculoSalario( double[] input) {
        double salarioAtual = input[2];
        double imposto = input[1] / 100;
        double anosTrabalhados = input[0];
        double salario, percentualPorAnoTrabalhado;

        if(anosTrabalhados >= 10){
            percentualPorAnoTrabalhado = 0.02;
        } else if (anosTrabalhados >= 5) {
            percentualPorAnoTrabalhado = 0.015;
        } else {
            percentualPorAnoTrabalhado = 0.01;
        }

        salario = salarioAtual + (salarioAtual * (imposto + percentualPorAnoTrabalhado));

        return salario;
    }
}