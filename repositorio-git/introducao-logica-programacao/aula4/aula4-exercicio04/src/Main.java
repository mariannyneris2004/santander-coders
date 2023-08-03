public class Main {
    public static void main(String[] args) {
        int[][] entradas = {
                {5, 6, 12},
                {10, 8, 13},
                {21, 10, 25},
                {0, 10, 2},
                {102, 0, 10},
                {28, 11, 10},
                {55, 1, 15},
                {78, 8, 0},
                {0, 0, 15}
        };

        int[] saidas = {
                2017,
                3903,
                7990,
                302,
                37240,
                10560,
                20120,
                28710,
                15
        };

        for (int i = 0; i < entradas.length; i++) {
            int resultado = idadeEmDias(entradas[i]);
            int esperado = saidas[i];

            System.out.println("Resultado: " + resultado);
            System.out.println("Esperado: " + esperado);
            System.out.println(resultado == esperado);
            System.out.println();
        }
    }

    public static int idadeEmDias(int[] input) {
        int anos = input[0];
        int meses = input[1];
        int dias = input[2];
        int totalDias;

        totalDias = anos * 365 + meses * 30 + dias;

        return totalDias;
    }
}