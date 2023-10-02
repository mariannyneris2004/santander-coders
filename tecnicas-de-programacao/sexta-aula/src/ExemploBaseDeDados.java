import java.util.Optional;

public class ExemploBaseDeDados {
    public static void main(String[] args) {
        BancoDeDados bancoDeDados = new BancoDeDados();
        Optional<Usuario> usuarioBuscado = bancoDeDados.getByLogin("Teste");
        //imprimirLoginUsuario(usuario);

        //usuarioBuscado.ifPresentOrElse(usuario -> imprimirLoginUsuario(usuario), () -> System.out.println("Usuário não encontrado!"));
/*        Usuario usuario = usuarioBuscado.orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
        imprimirLoginUsuario(usuario);*/

        /*String login = usuarioBuscado.map(usuario -> usuario.getLogin()).get();
        System.out.println(login);*/

        String login = usuarioBuscado.filter(usuario -> usuario.getSenha().length() > 3)
                .map(usuario -> usuario.getLogin())
                .orElse("Usuário não encontrado!");
        System.out.println(login);
    }

    private static void imprimirLoginUsuario(Usuario usuario) {
/*        if (usuario.isPresent()){
            System.out.println(usuario.get().getLogin());
        } else {
            System.out.println("Usuário não encontrado!");
        }

        if (usuario.isEmpty()){
            System.out.println("Usuário não encontrado!");
        } else {
            System.out.println(usuario.get().getLogin());
        }*/
        System.out.println(usuario.getLogin());
    }
}
