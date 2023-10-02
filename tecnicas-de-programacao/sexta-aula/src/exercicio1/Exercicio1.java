package exercicio1;

public class Exercicio1 {
    public static void detalhamentoValorPadrao(Usuario usuario) {
        System.out.println("Nome: " + usuario.getNome());

        if(usuario.getEmail().isPresent()) {
            System.out.println("E-mail: " + usuario.getEmail().get());
        } else {
            System.out.println("E-mail: " + usuario.getEmail().orElse("padrao@gmail.com"));
        }

        if(usuario.getIdade().isPresent()) {
            System.out.println("Idade: " + usuario.getIdade().get());
        } else {
            System.out.println("Idade: " + usuario.getIdade().orElse(0));
        }
    }
    public static void main(String[] args) {
        BaseUsuarios base = new BaseUsuarios();

        for (Usuario usuario : base.getUsuarios()) {
            usuario.mostrarDetalhes();
            detalhamentoValorPadrao(usuario);
            System.out.println();
        }
    }
}
