import com.sun.source.tree.TryTree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dia;
        DiasDaSemana diasDaSemana;

        System.out.println("Escreva um dia da semana");
        dia = scanner.next();

        try {
            diasDaSemana = diaDaSemana(dia.toUpperCase());
            System.out.println(diasDaSemana);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        scanner.close();
    }

    public static DiasDaSemana diaDaSemana(String nome){
        DiasDaSemana dia = DiasDaSemana.stringParaEnum(nome);
        return dia;
    }
}