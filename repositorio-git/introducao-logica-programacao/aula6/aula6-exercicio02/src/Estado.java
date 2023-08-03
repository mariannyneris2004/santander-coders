public enum Estado {
    MG("MG", 0.07),
    SP("SP", 0.12),
    RJ("RJ", 0.15);

    final String nome;
    final double imposto;

    Estado(String nome, double imposto) {
        this.nome = nome;
        this.imposto = imposto;
    }

    public String getNome(){
        return this.nome;
    }

    public double getImposto(){
        return this.imposto;
    }
}
