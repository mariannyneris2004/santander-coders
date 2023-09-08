public class EstudanteDeJava extends Pessoa implements Estudante{

    @Override
    public void estudar() {
        System.out.println("Estudando Java");
    }

    @Override
    Number getIdade() {
        return null;
    }
}
