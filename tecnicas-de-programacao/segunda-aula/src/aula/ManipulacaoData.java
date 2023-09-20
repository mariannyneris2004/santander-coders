package aula;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class ManipulacaoData {
    public static void main(String[] args) {
        //somar valores às datas
        LocalDate hoje = LocalDate.now();
        var depoisDeAmanha = hoje.plusDays(2);
        System.out.println(depoisDeAmanha);

        var umaSemanaDepois = hoje.plusWeeks(1);
        System.out.println(umaSemanaDepois);

        var umMesDepois = hoje.plusMonths(1);
        System.out.println(umMesDepois);

        //subtrair valores das datas
        LocalDateTime dataAtual = LocalDateTime.now();
        var ontem = dataAtual.minusDays(1);
        System.out.println(ontem);

        var umaHoraAtras = dataAtual.minusHours(1);
        System.out.println(umaHoraAtras);

        System.out.println(umaHoraAtras.minusHours(3).minusDays(1).plusMinutes(30));

        //período (soma e subtração)
        Period umAnoETresMeses = Period.of(1, 3, 0);
        System.out.println(dataAtual.plus(umAnoETresMeses));
        System.out.println(dataAtual.minus(umAnoETresMeses));


    }
}
