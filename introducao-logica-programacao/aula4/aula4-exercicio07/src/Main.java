public class Main {
    public static void main(String[] args) {
        int[][] entradas = {
                {2, 2, 5},
                {3, 3, 5},
                {2, 2, 2},
                {2, 5, 2},
                {2, 4, 3},
                {150, 120, 220},
                {122, 252, 130},
                {152, 200, 351},
                {1232, 2200, 120},
                {1, 2, 1},
                {2, 1, 2}
        };

        String[] saidas = {
                "LadosInvalidosException",
                "true",
                "true",
                "LadosInvalidosException",
                "true",
                "true",
                "LadosInvalidosException",
                "true",
                "LadosInvalidosException",
                "LadosInvalidosException",
                "true"
        };

        for (int i = 0; i < entradas.length; i++) {
            String resultado = "true";

            try {
                eUmTriangulo(entradas[i]);
            } catch (LadosInvalidosException e) {
                resultado = "LadosInvalidosException";
            }
            String esperado = saidas[i];

            System.out.println("Resultado: " + resultado);
            System.out.println("Esperado: " + esperado);
            System.out.println(resultado == esperado);
            System.out.println();
        }
    }

    public static boolean eUmTriangulo(int[] input) throws LadosInvalidosException {
        double a = input[0];
        double b = input[1];
        double c = input[2];

        if(a + b > c && a + c > b && b + c > a){
            return true;
        } else {
            throw new LadosInvalidosException("Lados Inválidos!");
        }
    }
}