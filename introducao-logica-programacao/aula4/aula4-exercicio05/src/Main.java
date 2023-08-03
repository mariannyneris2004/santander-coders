public class Main {
    public static void main(String[] args) {
        String[] entradas = {
                "amor",
                "cocada",
                "mora",
                "ovo",
                "cachorro",
                "kaka",
                "saudades",
                "palalelepipedo",
                "fofocalizando",
                "papagaio",
                "ateiaateiab"
        };

        int[] saidas = {
                0,
                1,
                0,
                1,
                1,
                -1,
                2,
                9,
                4,
                4,
                10
        };

        for (int i = 0; i < entradas.length; i++) {
            double resultado = primeiroCaractereUnico(entradas[i]);
            double esperado = saidas[i];

            System.out.println("Resultado: " + resultado);
            System.out.println("Esperado: " + esperado);
            System.out.println(resultado == esperado);
            System.out.println();
        }
    }

    public static int primeiroCaractereUnico(String input) {
        int[] contadorCaracter = new int[256];
        for (int i = 0; i < input.length(); i++) {
            char caracter = input.charAt(i);
            contadorCaracter[caracter]++;
        }

        for (int i = 0; i < input.length(); i++) {
            char caracter = input.charAt(i);
            if (contadorCaracter[caracter] == 1){
                return i;
            }
        }
        return -1;
    }

}