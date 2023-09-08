public abstract class Pessoa<T extends Number> {
    String nome;

    abstract T getIdade();
}
