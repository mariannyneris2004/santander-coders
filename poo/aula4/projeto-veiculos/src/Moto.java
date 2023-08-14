public class Moto extends Veiculo{
    private int cilindradas;
    public Moto(String placa, String modelo, String cor, int ano, int cilindradas) {
        super(placa, modelo, cor, ano);
        this.cilindradas = cilindradas;
    }

    @Override
    public void exibirDados(){
        super.exibirDados();
        System.out.println("Cilindradas: " + cilindradas);
    }
}
