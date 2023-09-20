package exercicios;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> datasString = new ArrayList<>();
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String data = "";

        do {
            System.out.println("Escreva uma data(yyyy-MM-dd) ou pressione 0 para parar: ");
            data = scanner.next();

            if (!data.equals("0")){
                datasString.add(data);
            }
        } while (!data.equals("0"));

        for (String dataStr:datasString) {
            System.out.println(LocalDate.parse(dataStr));
        }

        scanner.close();
    }
}
