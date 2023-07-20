import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("en", "US"));

        double[] lados = {9, 7, 14};
        double area;

        area = formulaArea(lados);

        System.out.println(area);
    }

    public static double formulaArea(double[] lados){
        double a = lados[0];
        double b = lados[1];
        double c = lados[2];
        double area, p;

        p = formulaDeP(lados);

        area = Math.sqrt(p * (p - a) * (p - b) * (p - c));

        area = arredondar(area);

        return area;
    }

    public static double formulaDeP (double[] lados){
        double a = lados[0];
        double b = lados[1];
        double c = lados[2];
        double p;

        p = (a + b + c) / 2;

        return p;
    }

    public static double arredondar(double numero) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return Double.parseDouble(decimalFormat.format(numero));
    }
}