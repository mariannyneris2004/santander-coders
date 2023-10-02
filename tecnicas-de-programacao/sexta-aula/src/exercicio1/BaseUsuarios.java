package exercicio1;

import java.util.List;
import java.util.Optional;

public class BaseUsuarios {
    private List<Usuario> usuarios;

    public BaseUsuarios() {
        this.usuarios = List.of(
                new Usuario("Nome"),
                new Usuario("Completo", Optional.of("completo@gmail.com"), Optional.of(22)),
                new Usuario("SemIdade", Optional.of("email@gmail.com"), Optional.empty()),
                new Usuario("SemEmail", Optional.empty(), Optional.of(31))
        );
    }

    public List<Usuario> getUsuarios() {
        return this.usuarios;
    }
}
