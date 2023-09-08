public class RoboCortadorDePizza {

    public void setObjetoCortante(ObjetoCortante objetoCortante) {
        this.objetoCortante = objetoCortante;
    }

    private ObjetoCortante objetoCortante;

    public void cortar(String saborDaPizza) {
        objetoCortante = new CortadorDePizza();
        objetoCortante.cortar();
        System.out.println("Repetir isso nos demais pedaços");
        System.out.println("A pizza de " + saborDaPizza + " está cortada.");

    }
}