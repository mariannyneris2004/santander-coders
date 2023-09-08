import service.CaixaEletronico;
import service.MenuSeletorBR;
import service.MenuSeletorEUA;

public class Main {

    public static void main(String[] args) {
        CaixaEletronico caixaEletronico;
        if (args.length > 0) {
            if ("BR".equalsIgnoreCase(args[0])) {
                caixaEletronico = new CaixaEletronico(new MenuSeletorBR());

            } else if ("EUA".equalsIgnoreCase(args[0])) {
                caixaEletronico = new CaixaEletronico(new MenuSeletorEUA());
            } else {
                System.out.println("Adotando linguagem padrão");
                caixaEletronico = new CaixaEletronico(new MenuSeletorBR());
            }
        } else {
            caixaEletronico = new CaixaEletronico(new MenuSeletorBR());
        }
        boolean continua = true;
        System.out.println("Bem vindo ao Santander");
        while (continua) {
            continua = caixaEletronico.execute();
        }
        System.out.println("Volte sempre!");
    }


}