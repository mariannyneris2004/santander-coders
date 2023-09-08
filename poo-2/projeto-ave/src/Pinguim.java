public class Pinguim extends Ave implements Nadar, Andar{
    @Override
    public int bicar() {
        return 2;
    }

    @Override
    public int soltarPena() {
        return 2;
    }

    @Override
    public void andar(int distancia) {
        distancia = 5;
    }

    @Override
    public void nadar(int profundidade) {
        profundidade = 5;
    }
}
