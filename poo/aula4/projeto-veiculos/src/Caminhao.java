public class Caminhao extends Veiculo{
    private int quantidadeRodas;

    public Caminhao(String placa, String modelo, String cor, int ano, int quantidadeRodas) {
        super(placa, modelo, cor, ano);
        this.quantidadeRodas = quantidadeRodas;
    }

    @Override
    public void exibirDados(){
        super.exibirDados();
        System.out.println("Quantidade de rodas: " + quantidadeRodas);
    }
}
