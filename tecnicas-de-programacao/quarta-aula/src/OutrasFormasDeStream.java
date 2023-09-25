import java.util.Collections;
import java.util.stream.Stream;

public class OutrasFormasDeStream {
    public static void main(String[] args) {
        //Coleção vazia
        Collections.emptyList();

        //Stream vazia
        Stream.empty().map(n -> n +"").forEach(n-> System.out.println(n));
    }
}
