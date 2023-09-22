package aula.programacaofuncional02;

public class ProgramacaoFuncional02 {
    public static void main(String[] args) {
        String palavra = "Marianny";
        ContarCaracteres<String, Integer> contarCaracteres = p -> p.length();

        Integer resultado = conta(palavra, contarCaracteres);
        System.out.println(resultado);

        ContarCaracteres<String, Integer> contarCaracteres1 = p -> {
            int contador = 0;
            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) == 'n'){
                    contador++;
                }
            }
            return contador;
        };
        Integer resultado2 = conta(palavra, contarCaracteres1);
        System.out.println(resultado2);

        System.out.println(conta(palavra, contarCaracteres));

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Marianny");
        ContarCaracteres<StringBuilder, Integer> contarCaracteres2 = p -> p.length();
        System.out.println(contarCaracteres2.contar(stringBuilder));
    }

    private static Integer conta(String palavra, ContarCaracteres<String, Integer> contarCaracteres) {
        return contarCaracteres.contar(palavra);
    }
}
