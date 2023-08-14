public class Carro extends Veiculo{
    private int quantidadePortas;
    private String tipoCombustivel;
    public Carro(String placa, String modelo, String cor, int ano, int quantidadePortas, String tipoCombustivel) {
        super(placa, modelo, cor, ano);
        this.quantidadePortas = quantidadePortas;
        this.tipoCombustivel = tipoCombustivel;
    }

    @Override
    public void exibirDados(){
        super.exibirDados();
        System.out.println("Quantidade de portas: " + quantidadePortas);
        System.out.println("Tipo de combustível: " + tipoCombustivel);
    }
}
