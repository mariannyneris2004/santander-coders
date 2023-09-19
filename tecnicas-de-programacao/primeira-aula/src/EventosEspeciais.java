import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class EventosEspeciais {
    public static LocalDate evento1(){
        return LocalDate.of(2022, 5, 7);
    }

    public static LocalTime evento2(){
        return LocalTime.of(13, 30);
    }

    public static LocalDateTime evento3(){
        return LocalDateTime.of(2004, 8, 16, 8, 5);
    }

    public static void main(String[] args) {
        System.out.println("Eventos especiais");
        System.out.println("Data de pedido de namoro: " + EventosEspeciais.evento1());
        System.out.println("Horário do almoço em família: " + EventosEspeciais.evento2());
        System.out.println("Data e horário de nascimento: " + EventosEspeciais.evento3());
    }
}
