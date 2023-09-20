package aula;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataParaString {
    public static void main(String[] args) {
        LocalDate data = LocalDate.now();
        LocalDateTime dataHora = LocalDateTime.now();

        DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("dd/MM/u G");
        DateTimeFormatter formatarData2 = DateTimeFormatter.ofPattern("dd 'de' MM 'de' yyyy");
        DateTimeFormatter formatarDataHota = DateTimeFormatter.ofPattern("hh:mm:ss a");

        System.out.println("Data da segunda dose: " + data.format(formatarData));
        System.out.println("Data da segunda dose: " + data.format(formatarData2));
        System.out.println("Data da terceira dose: " + dataHora.format(formatarDataHota));
    }
}
