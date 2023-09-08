public class Falcao extends Ave implements Voar{
    @Override
    public int bicar() {
        return 10;
    }

    @Override
    public int soltarPena() {
        return 5;
    }

    @Override
    public void voar(int altura) {
        altura = 10;
    }
}
