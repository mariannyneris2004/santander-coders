public class Main {
    public static void main(String[] args) {
        System.out.println(soma(3));
        System.out.println(somatorio(5));
        System.out.println(multiplica(5));
    }

    public static int soma(int limite){
        int soma = 0;

        for (int i = 1; i <= limite; i++) {
            soma+=i;
        }

        return soma;
    }

    public static int somatorio(int limite){
        if(limite == 0){
            return 0;
        }

        return limite + somatorio(limite - 1);
    }

    public static int multiplica(int limite){
        if (limite == 0){
            return 1;
        }

        return limite * multiplica(limite - 1);
    }
}