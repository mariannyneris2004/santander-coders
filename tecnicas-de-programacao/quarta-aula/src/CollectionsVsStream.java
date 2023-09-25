import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class CollectionsVsStream {
    public static void main(String[] args) {
        Stream<Integer> streamInteger = Stream.of(1, 2, 3, 4, 5);
        streamInteger.forEach(n -> System.out.println(n));
        //System.out.println(streamInteger.min(Comparator.naturalOrder()).get());

        System.out.println();
        //Utilizando collections com stream
        List<Integer> integers = List.of(2, 1, 3, 5, 8);
        integers.stream().forEach(n -> System.out.println(n));

        System.out.println();

        System.out.println(integers.stream().max(Comparator.naturalOrder()).get());

    }
}
