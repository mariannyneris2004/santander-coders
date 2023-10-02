import java.util.stream.Stream;

public class AprendendoStream {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 3, 5, 7, 9);

        //Stream<Integer> streamEmDobro = stream.map(n -> n * 2);
        //System.out.println(streamEmDobro);

        stream.map(n -> n * 2).forEach(n -> System.out.println(n));
    }
}