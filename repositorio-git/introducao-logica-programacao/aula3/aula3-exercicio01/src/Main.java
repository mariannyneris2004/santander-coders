import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("en", "US"));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Escreva 3 lados para um triângulo: ");
        double[] ladosTriangulo = new double[3];
        for (int i = 0; i < ladosTriangulo.length; i++) {
            ladosTriangulo[i] = scanner.nextDouble();
        }

        try {
            double area = formulaArea(ladosTriangulo);
            System.out.println("A área do Triângulo é de " + area);
        } catch (LadosInvalidosException e){
            System.out.println(e.getMessage());
        }

        scanner.close();
    }

    public static double formulaArea(double[] lados){
        double a = lados[0];
        double b = lados[1];
        double c = lados[2];

        validacaoLados(lados);

        double p = (a + b + c) / 2;
        double area = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        area = arredondar(area);

        return area;
    }

    public static boolean validacaoLados (double[] lados) throws LadosInvalidosException{
        double a = lados[0];
        double b = lados[1];
        double c = lados[2];

        if (a + b > c && b + c > a && a + c > b){
            return true;
        } else {
            throw new LadosInvalidosException("Lados Inválidos");
        }
    }

    public static double arredondar(double numero) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return Double.parseDouble(decimalFormat.format(numero));
    }
}