import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        ArrayList numerosLista = new ArrayList<>();
        boolean repetido;

        System.out.printf("Escreva um conjunto de números decimais: ");
        numerosLista.add(scanner.nextDouble());

        System.out.println(numerosLista);

        double[] numeros = new double[numerosLista.size()];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = scanner.nextDouble();
        }

        repetido = elementosRepetidos(numeros);

        System.out.println("Ex: ");
        System.out.println("Entrada: " + Arrays.toString(numeros));
        System.out.println("Saída: " + repetido);

        scanner.close();
    }
    public static boolean elementosRepetidos(double[] input) {
        int contador = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                if (input[i] == input[j]){
                    contador++;
                }
            }
        }

        if(contador > input.length){
            return true;
        }

        return false;
    }
}