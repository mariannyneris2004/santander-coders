package exercicios;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Exercicio3 {
    public static void main(String[] args) {
        ZonedDateTime hoje = ZonedDateTime.now();

        System.out.println(hoje.withZoneSameInstant(ZoneId.of("America/New_York")));
        System.out.println(hoje.withZoneSameInstant(ZoneId.of("Europe/Paris")));
        System.out.println(hoje.withZoneSameInstant(ZoneId.of("Asia/Tokyo")));
    }
}
