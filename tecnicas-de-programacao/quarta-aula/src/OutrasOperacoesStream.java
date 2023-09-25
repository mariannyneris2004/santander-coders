import java.util.Comparator;
import java.util.stream.Stream;

public class OutrasOperacoesStream {
    public static void main(String[] args) {
        //remover elementos iguais dentro da stream
        Stream<String> stream = Stream.of("feijão", "arroz", "feijão", "macarrão");

        stream.distinct().forEach(n -> System.out.println(n));

        //ordenação de valores
        Stream<Integer> streamNumerico = Stream.of(5, 32, 1, 0);

        streamNumerico.sorted().forEach(n -> System.out.println(n));

        //ordenação pelo forEachOrdered
        Stream<Integer> novaStream = Stream.of(5, 32, 1, 0);
        novaStream.sorted().forEachOrdered(n -> System.out.println(n));

        //maior elemento da stream
        Stream<Integer> maiorElemento = Stream.of(5, 32, 1, 0);
        System.out.println(maiorElemento.max(Comparator.naturalOrder()).get());

        //menor elemento da stream
        Stream<Integer> menorElemento = Stream.of(5, 32, 1, 0);
        System.out.println(menorElemento.min(Comparator.naturalOrder()).get());

    }
}
