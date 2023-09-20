package exercicios;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Exercicio2 {
    public static void main(String[] args) {
        List<LocalDate> datas = new ArrayList<>();
        datas.add(LocalDate.of(2023, 8, 10));
        datas.add(LocalDate.of(2022, 5, 20));
        datas.add(LocalDate.of(2021, 11, 30));

        DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (LocalDate data:datas) {
            System.out.println(data.format(formatarData));
        }
    }
}
