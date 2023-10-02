public class Main {
    public static void getString(String string){
        System.out.println(string);
    }

    public static void main(String[] args) {
        Impressao impressaoPorLambda = s -> System.out.println(s);

        impressaoPorLambda.getNome("Por Lambda");

        Impressao impressaoPorMethodReference = Main::getString;
        impressaoPorMethodReference.getNome("Por Method Reference");
    }
}