import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Banco {
    ArrayList<Conta> contas;

    public Banco(){}

    public Banco(ArrayList<Conta> contas){
        this.contas = contas;
    }

    public ArrayList<Conta> getContas() {
        return contas;
    }

    public void setContas(ArrayList<Conta> contas) {
        this.contas = contas;
    }

    public Conta criarConta(){
        Random gerador = new Random();

        Cliente cliente = new Cliente();
        System.out.println("Informe o nome: ");
        cliente.setNome(Entrada.getStringNextLine());
        System.out.println("Informe o CPF: ");
        cliente.setCpf(Entrada.getStringNext());
        System.out.println("Informe o email: ");
        cliente.setEmail(Entrada.getStringNext());

        Conta conta = new Conta(cliente, gerador.nextInt(100000));

        System.out.println(conta);

        return conta;
    }

    public Conta buscarConta() throws OperacoesException{
        System.out.println("Escreva o número da conta: ");
        int contaABuscar = Entrada.getInt();
        for (Conta conta : getContas()) {
            if (conta.getNumeroDaConta() == contaABuscar){
                return conta;
            }
        }
        throw new OperacoesException("Conta não encontrada.");
    }

    public Cliente buscarCliente() throws OperacoesException{
        System.out.println("Escreva o número do cpf: ");
        String clienteABuscar = Entrada.getStringNext();
        for (Conta conta : getContas()) {
            if (conta.getCliente().getCpf().equals(clienteABuscar)){
                return conta.getCliente();
            }
        }
        throw new OperacoesException("Cliente não encontrado.");
    }

    public void depositar(){
        Conta contaABuscar = buscarConta();
        System.out.println("Escreva a quantia a ser depositada: ");
        double quantiaADepositar = Entrada.getDouble();
        contaABuscar.depositar(quantiaADepositar);
        System.out.println(contaABuscar);
    }

    public void sacar(){
        Conta contaABuscar = buscarConta();
        System.out.println("Escreva a quantia a ser depositada: ");
        double quantiaASacar = Entrada.getDouble();
        contaABuscar.sacar(quantiaASacar);
        System.out.println(contaABuscar);
    }
}
