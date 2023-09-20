package exercicios.emAula;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class FusoHorarioEmJava {
    public static void main(String[] args) {
        for (String zoneId: ZoneId.getAvailableZoneIds()) {
            System.out.println(zoneId);
        }

        System.out.println(ZoneId.getAvailableZoneIds().size());

        //data e hora com fuso horario
        ZonedDateTime dataHoraEmSaoPaulo = ZonedDateTime.now();
        System.out.println(dataHoraEmSaoPaulo);
        ZonedDateTime dataHoraEmParis = dataHoraEmSaoPaulo.withZoneSameInstant(ZoneId.of("Europe/Paris"));
        System.out.println(dataHoraEmParis);
    }
}
