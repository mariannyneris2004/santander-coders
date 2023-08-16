package entrada_saida.views;

import entrada_saida.Entrada;
import modelos.Cliente;
import servicos.ClienteService;

public class ClienteView {
    public static Cliente cadastrarCliente(){
        ClienteService service = ClienteService.getInstance();

        System.out.println("Informe seu nome: ");
        String nome = Entrada.getStringNextLine();

        String msg = service.cadastrarCliente(nome);
        System.out.println(msg);
        return service.getCliente(nome);
    }

    public static void removerCliente(){
        ClienteService service = ClienteService.getInstance();

        System.out.println("Informe o nome: ");
        String nome = Entrada.getStringNextLine();

        boolean remover = service.deleteCliente(nome);
        if (remover){
            System.out.println("Removido com sucesso");
        }
    }

    public static Cliente buscarCliente(){
        ClienteService service = ClienteService.getInstance();

        System.out.println("Informe o nome: ");
        String nome = Entrada.getStringNextLine();

        return service.getCliente(nome);
    }

    public static void listarClientes(){
        ClienteService service = ClienteService.getInstance();

        for (int i = 1; i <= service.getClientes().size(); i++) {
            System.out.println(i + ")" + service.getClientes().get(i).getNome());
        }
        System.out.println("Escolha o cliente: ");
    }
}
