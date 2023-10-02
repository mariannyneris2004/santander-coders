import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class LerArquivos {
    public static void main(String[] args) throws IOException {
        //Fazer leitura do arquivo employee.csv
        Path path = Paths.get("src/employee.csv");

        Stream<String> lines = Files.lines(path);

        lines.forEach(System.out::println);
    }
}