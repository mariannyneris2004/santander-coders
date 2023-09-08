public class Retangulo {
    private double altura;
    private double base;

    public Retangulo(double altura, double base) {
        this.altura = altura;
        this.base = base;
    }

    public double area(){
        return base * altura;
    }
}
