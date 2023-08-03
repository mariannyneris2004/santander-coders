import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        double[][] entradas = {
                {1, 5.0, 2000.00},
                {11, 4.5,2500.00},
                {5.1, 6.7, 4500.0},
                {1, 5.7, 4800.0},
                {10.1, 4.7, 4100.0},
                {15, 5.3, 6100.0},
                {2, 8.3, 9500.0},
                {20, 9.3, 10500.0},
                {0.5, 11.3, 4800.0},
                {5, 12.5, 6800.0},
                {10, 9.1, 8200.0}
        };

        double[] saidas = {
                2120.00,
                2662.50,
                4869.00,
                5121.60,
                4374.70,
                6545.30,
                10383.50,
                11686.50,
                5342.4,
                7752.00,
                9110.20
        };

        for (int i = 0; i < entradas.length; i++) {
            double resultado = calculoSalario(entradas[i]);
            double esperado = saidas[i];

            System.out.println("Resultado: " + resultado);
            System.out.println("Esperado: " + esperado);
            System.out.println(resultado == esperado);
            System.out.println();
        }
    }

    public static double calculoSalario(double[] input) {
        double anosTrabalhados = input[0];
        double inflacao = input[1] / 100;
        double salarioAntigo = input[2];
        double porcentagemAumento;
        double aumento, salarioFinal;

        if (anosTrabalhados >= 10){
            porcentagemAumento = 0.02;
        } else if (anosTrabalhados >= 5) {
            porcentagemAumento = 0.015;
        } else if (anosTrabalhados >= 1){
            porcentagemAumento = 0.01;
        } else {
            porcentagemAumento = 0;
        }

        aumento = (porcentagemAumento + inflacao) * salarioAntigo;
        salarioFinal = salarioAntigo + aumento;
        arredondar(salarioFinal);

        return salarioFinal;
    }

    public static double arredondar(double numero) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat decimalFormat = new DecimalFormat("#.##", symbols);
        return Double.parseDouble(decimalFormat.format(numero));
    }
}