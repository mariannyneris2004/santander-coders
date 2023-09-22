package aula.exercicio02;

import java.util.function.BiFunction;

public class Calculadora {
    public int executar(int a, int b, BiFunction<Integer, Integer, Integer> operacao) {
        return operacao.apply(a, b);
    }
}