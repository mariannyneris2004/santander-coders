import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        //imprime data atual
        LocalDate dataAtual = LocalDate.now();
        System.out.println(dataAtual);
        System.out.println();

        //imprime hora atual
        LocalTime horaAtual = LocalTime.now();
        System.out.println(horaAtual);
        System.out.println();

        //imprime data e hora atual
        LocalDateTime diaHora = LocalDateTime.now();
        System.out.println(diaHora);
        System.out.println();

        //imprime data passada
        LocalDate dataPassada = LocalDate.of(2023, 9, 1);
        System.out.println(dataPassada);
        LocalDate dataPassadaEnum = LocalDate.of(2023, Month.SEPTEMBER, 15);
        System.out.println(dataPassadaEnum);
        LocalDate dataPassadaDiaDoAno = LocalDate.ofYearDay(2023, 50);
        System.out.println(dataPassadaDiaDoAno);
        System.out.println();

        //imprime hora
        LocalTime horaMinuto = LocalTime.of(12, 50);
        System.out.println(horaMinuto);
        LocalTime horaMinutoSegundo = LocalTime.of(12, 50, 30);
        System.out.println(horaMinutoSegundo);
        //erro
        /*LocalTime horaMinutoTesteErro = LocalTime.of(24, 50);
        System.out.println(horaMinutoTesteErro);*/
        /*LocalTime horaMinutoTesteErro2 = LocalTime.of(23, 60);
        System.out.println(horaMinutoTesteErro2);*/
        System.out.println();
        LocalDateTime dataCompleta = LocalDateTime.of(2023, Month.SEPTEMBER, 15, 17, 55, 36);
        System.out.println(dataCompleta);
        System.out.println();

        LocalDateTime dataHoraPersonalizada = LocalDateTime.of(dataAtual, horaAtual);
        System.out.println(dataHoraPersonalizada);
        System.out.println();

        //comparações
        LocalDate dataFutura = LocalDate.of(2023, Month.DECEMBER, 02);
        LocalDate hoje = LocalDate.now();
        System.out.println("A data futura é depois da data atual: " + dataFutura.isAfter(hoje));
        System.out.println("A data atual é anterior à data futura: " + hoje.isBefore(dataFutura));
        System.out.println();

        LocalDateTime dataHoraFutura = LocalDateTime.of(2023, Month.SEPTEMBER, 19, 22, 00);
        LocalDateTime dataHoraAtual = LocalDateTime.now();
        System.out.println("A data futura é depois da data atual: " + dataHoraFutura.isAfter(dataHoraAtual));
        System.out.println("A data atual é anterior à data futura: " + dataHoraAtual.isBefore(dataHoraFutura));
        System.out.println();
    }
}