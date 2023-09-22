package aula.programacaofuncional02;
@FunctionalInterface
public interface ContarCaracteres<T, U> {
    U contar(T palavra);
}
