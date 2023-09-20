package exercicios.emAula;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DataDosesDaVacina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Escreva a data em que você tomou a vacina (dd/mm/aaaa): ");
        String dataDose = scanner.next();

        try {
            LocalDate dataPrimeiraDose = LocalDate.parse(dataDose, formatar);
            LocalDate dataSegundaDose = dataPrimeiraDose.plusMonths(1);
            LocalDate dataTerceiraDose = dataPrimeiraDose.plusMonths(2);

            System.out.println("Data da segunda dose: " + dataSegundaDose.format(formatar));
            System.out.println("Data da terceira dose: " + dataTerceiraDose.format(formatar));
        } catch (Exception e){
            e.getCause();
        }

        scanner.close();
    }
}
