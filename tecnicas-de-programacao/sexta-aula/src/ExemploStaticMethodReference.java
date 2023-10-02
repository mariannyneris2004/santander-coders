public class ExemploStaticMethodReference {
    public boolean verifica2(Integer numero){
        return numero%2==0;
    }
    public static boolean verifica(Integer numero){
        return numero%2==0;
    }
    public static void main(String[] args) {
        Verfificador verfificadorPorLambda = n -> n%2==0;
        System.out.println(verfificadorPorLambda.verificaSeEPar(57));

        //método static
        Verfificador verfificadorPorMethodReference = ExemploStaticMethodReference::verifica;
        System.out.println(verfificadorPorMethodReference.verificaSeEPar(8));

        //método não estático
        ExemploStaticMethodReference instance = new ExemploStaticMethodReference();
        Verfificador verfificadorPorLambda2 = instance::verifica2;
        System.out.println(verfificadorPorLambda2.verificaSeEPar(37));

        BaseDeDados usuario = (lg, se) -> new Usuario(lg, se);
        System.out.println(usuario.getUsuario("Marianny", "senha").getLogin());

        BaseDeDados usuario2 = Usuario::new;
    }
}
