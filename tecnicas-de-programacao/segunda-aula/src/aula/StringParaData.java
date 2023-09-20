package aula;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StringParaData {
    public static void main(String[] args) {
        String dataString = "2023-08-16";
        String dataHoraString = "2023-08-16 14:50:36";

        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatoDataHora = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        try {
            LocalDate data = LocalDate.parse(dataString, formatoData);
            System.out.println(data);
            LocalDateTime dataHora = LocalDateTime.parse(dataHoraString, formatoDataHora);
            System.out.println(dataHora);
        } catch (Exception e){
            e.getCause();
        }
    }
}
