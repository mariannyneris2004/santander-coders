import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BancoDeDados {
    List<Usuario> usuarios = new ArrayList<>();
    {
        usuarios = List.of(new Usuario("Teste", "senha"),
                           new Usuario("login", "sen"));
    }

    public Optional<Usuario> getByLogin(String login){
        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login)) {
                return Optional.of(usuario);
            }
        }
        return Optional.empty();
    }
}
