public class Pato extends Ave implements Voar, Nadar, Andar{
    @Override
    public void andar(int distancia) {
        distancia = 7;
    }

    @Override
    public int bicar() {
        return 7;
    }

    @Override
    public int soltarPena() {
        return 3;
    }

    @Override
    public void nadar(int profundidade) {
        profundidade = 2;
    }

    @Override
    public void voar(int altura) {
        altura = 5;
    }
}
