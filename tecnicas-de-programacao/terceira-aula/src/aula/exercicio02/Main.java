package aula.exercicio02;

import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        // Soma
        BiFunction<Integer, Integer, Integer> soma = (a, b) -> a + b;
        int resultadoSoma = calculadora.executar(10, 5, soma);
        System.out.println("Soma: " + resultadoSoma);

        // Subtração
        BiFunction<Integer, Integer, Integer> subtracao = (a, b) -> a - b;
        int resultadoSubtracao = calculadora.executar(10, 5, subtracao);
        System.out.println("Subtração: " + resultadoSubtracao);

        // Multiplicação
        BiFunction<Integer, Integer, Integer> multiplicacao = (a, b) -> a * b;
        int resultadoMultiplicacao = calculadora.executar(10, 5, multiplicacao);
        System.out.println("Multiplicação: " + resultadoMultiplicacao);

        // Divisão
        BiFunction<Integer, Integer, Integer> divisao = (a, b) -> a / b;
        int resultadoDivisao = calculadora.executar(10, 5, divisao);
        System.out.println("Divisão: " + resultadoDivisao);
    }
}
