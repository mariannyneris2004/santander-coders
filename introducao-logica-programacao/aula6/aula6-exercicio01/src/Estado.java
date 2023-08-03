public enum Estado {
    MG(0.07),
    SP(0.12),
    RJ(0.15);

    final double imposto;

    Estado(double imposto) {
        this.imposto = imposto;
    }

    public double getImposto() {
        return imposto;
    }
}
