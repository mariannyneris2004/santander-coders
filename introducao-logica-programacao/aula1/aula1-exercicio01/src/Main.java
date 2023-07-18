import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double fahrenheit, celsius;
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Escreva uma temperatura em ºF: ");
        fahrenheit = scanner.nextDouble();

        celsius = calculoFahrenheit(fahrenheit);

        System.out.printf("A temperatura %.2fºF equilave a %.2fºC", fahrenheit, celsius);
        scanner.close();
    }

    public static double calculoFahrenheit(double fahrenheit){
        double celsius;
        celsius = 5 * ((fahrenheit - 32)/9);
        return celsius;
    }
}