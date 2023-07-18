import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String palavra;
        int posicao;

        System.out.printf("Escreva uma palavra: ");
        palavra = scanner.next();

        posicao = primeiroCaractereUnico(palavra);

        System.out.println("Ex: ");
        System.out.println("Entrada: " + palavra);
        System.out.println("Saída: " + posicao);

        scanner.close();
    }
    public static int primeiroCaractereUnico(String input) {
        int[] contadorCaracter = new int[256];
        for (int i = 0; i < input.length(); i++) {
            char caracter = input.charAt(i);
            contadorCaracter[caracter]++;
        }

        for (int i = 0; i < input.length(); i++) {
            char caracter = input.charAt(i);
            if (contadorCaracter[caracter] == 1){
                return i;
            }
        }
        return -1;
    }
}