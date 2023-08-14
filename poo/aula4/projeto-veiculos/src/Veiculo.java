public class Veiculo {
    private String placa;
    private String modelo;
    private String cor;
    private int ano;

    public Veiculo(String placa, String modelo, String cor, int ano) {
        this.placa = placa;
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void exibirDados(){
        System.out.println("Placa: " + placa);
        System.out.println("Cor: " + cor);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano: " + ano);
    }
}
