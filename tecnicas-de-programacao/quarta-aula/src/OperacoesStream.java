import java.util.stream.Stream;

public class OperacoesStream {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);

        stream.map(n -> n*2)
                .filter(n -> n.equals(2))
                .map(n -> n * 10)
//              .filter(n -> n < 10)
                .forEach(n -> System.out.println(n));
    }
}
