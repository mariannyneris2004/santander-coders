package aula.programacaofuncional;

public class ProgramacaoFuncional {
    public static void main(String[] args) {
        Integer numero01 = 2;
        Integer numero02 = 4;

        Integer resultado = calcular(numero01, numero02);
        System.out.println(resultado);

        Opercao operacaoSomar = new OpercaoSomar();

        Integer resultadoSoma = calcular(numero01, numero02, operacaoSomar);
        System.out.println(resultadoSoma);

        Opercao opercaoSubtrair = new OperacaoSubtrair();

        Integer resultadoSubtracao = calcular(numero01, numero02, opercaoSubtrair);
        System.out.println(resultadoSubtracao);

        //Opercao operacaoLambdaSomar = (Integer a, Integer b) -> {return a + b;};
        Opercao operacaoLambdaSomar = (a, b) -> a + b;
        System.out.println(calcular(numero01, numero02, operacaoLambdaSomar));

    }

    private static Integer calcular(Integer numero01, Integer numero02, Opercao opercao){
        return opercao.executar(numero01, numero02);
    }

    private static Integer calcular(Integer numero01, Integer numero02){
        return numero01 + numero02;
    }
}