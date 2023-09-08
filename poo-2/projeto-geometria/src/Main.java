public class Main {
    public static void main(String[] args) {
        Retangulo retangulo = new Retangulo(2, 3);
        Retangulo quadrado = new Quadrado(2);
        System.out.println(retangulo.area());
        System.out.println(quadrado.area());
    }
}