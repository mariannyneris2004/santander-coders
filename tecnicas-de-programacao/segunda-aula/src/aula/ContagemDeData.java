package aula;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class ContagemDeData {
    public static void main(String[] args) {
        LocalDate hoje = LocalDate.now();
        LocalDate ontem = LocalDate.of(2023, Month.SEPTEMBER, 19);

        //conta os dias entre datas
        System.out.println(ChronoUnit.DAYS.between(hoje, ontem));
        System.out.println(ChronoUnit.DAYS.between(ontem, hoje));

        LocalDateTime diaHoraOntem = LocalDateTime.of(ontem, LocalTime.of(20, 0));
        LocalDateTime diaHoraHoje = LocalDateTime.now();

        System.out.println(ChronoUnit.DAYS.between(diaHoraOntem, diaHoraHoje));
    }
}
