import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*- Modele a classe AGENDA que contém um array de contatos como atributo e os seguintes métodos:
        - deletar(Contato);
        - buscar(String);
        - Modele uma classe CONTATO com os devidos atributos e os seguintes métodos:
        - ligar()
        - detalhar()
        - verNumero()
        - crie vários contatos e coloque-os em uma classe Agenda;

        - no método main, faça a impressão usando cada método*/

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int operacao;
        Agenda agenda = new Agenda();
        agenda.contatos = new ArrayList<>();
        Contato contato;
        String nome;
        String numero;

        do {
            System.out.println("1 - Adicionar contato à agenda\n2 - Deletar contato da agenda\n3 - Buscar por nome"
            + "\n4 - Buscar por número\n5 - Ligar\n6 - Detalhar contato\n7 - Imprimir agenda\n0 - Finalizar programa");
            System.out.println("O que deseja fazer?");
            operacao = scanner.nextInt();

            switch (operacao){
                case 1:
                    System.out.println("Escreva o nome: ");
                    nome = scanner.next();
                    System.out.println("Escreva o número: ");
                    numero = scanner.next();
                    agenda.contatos.add(new Contato(nome, numero));
                    System.out.println("Contato criado com sucesso!");
                    break;
                case 2:
                    System.out.println("Escreva o nome do contato a ser deletado: ");
                    nome = scanner.next();
                    contato = agenda.buscarContato(nome);
                    agenda.contatos = agenda.deletar(contato);
                    System.out.println("Contato " + contato.nomeContato + " deletado com sucesso!");
                    break;
                case 3:
                    System.out.println("Escreva o nome para pesquisa: ");
                    nome = scanner.next();
                    System.out.println(agenda.buscarPorNome(nome));
                    break;
                case 4:
                    System.out.println("Escreva o número para pesquisa: ");
                    scanner.nextLine();
                    numero = scanner.next();
                    System.out.println(agenda.buscarPorNumero(numero));
                    break;
                case 5:
                    System.out.println("Escreva para quem deseja ligar: ");
                    nome = scanner.next();
                    contato = agenda.buscarContato(nome);
                    System.out.println(contato.ligar());
                    break;
                case 6:
                    System.out.println("Escreva o contato a ser detalhado: ");
                    nome = scanner.next();
                    contato = agenda.buscarContato(nome);
                    System.out.println(contato.detalhar());
                    break;
                case 7:
                    for (Contato contatoSalvo : agenda.contatos) {
                        System.out.println(contatoSalvo.detalhar());
                    }
                    break;
                default:
                    System.out.println("Obrigado pela preferência!");
                    break;
            }

        } while (operacao != 0);

        scanner.close();
    }
}