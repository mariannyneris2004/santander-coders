public class Main {
    public static void main(String[] args) {
        RoboCortadorDePizza roboCortadorDePizza = new RoboCortadorDePizza();
        roboCortadorDePizza.setObjetoCortante(new CortadorDePizza());

        roboCortadorDePizza.cortar("mussarela");
    }
}