import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        int tamanhoLista;

        System.out.println("Digite quantos números deseja digitar: ");
        tamanhoLista = scanner.nextInt();
        System.out.println("Digite a lista de número inteiros maiores que 0: ");
        for (int i = 0; i < tamanhoLista; i++) {
            numbers.add(i, scanner.nextInt());
        }

        ArrayList<Integer> ascendingOrder = sortAscendingOrder(numbers);
        ArrayList<Integer> descendingOrder = sortDescendingOrder(numbers);
        ArrayList<Integer> pares = pares(sortAscendingOrder(numbers));
        ArrayList<Integer> impares = impares(sortAscendingOrder(numbers));

        System.out.println(numbers);
        System.out.println(ascendingOrder);
        System.out.println(descendingOrder);
        System.out.println(pares);
        System.out.println(impares);

        scanner.close();
    }

    public static ArrayList<Integer> sortAscendingOrder(ArrayList<Integer> numbers){
        ArrayList<Integer> listaCrescente = new ArrayList<Integer>();
        for (int i = 0; i < numbers.size(); i++) {
            listaCrescente.add(numbers.get(i));
        }
        Collections.sort(listaCrescente);
        return listaCrescente;
    }

    public static ArrayList<Integer> sortDescendingOrder(ArrayList<Integer> numbers){
        ArrayList<Integer> listaDecrescente = new ArrayList<Integer>();
        for (int i = 0; i < numbers.size(); i++) {
            listaDecrescente.add(numbers.get(i));
        }
        Collections.sort(listaDecrescente, Collections.reverseOrder());
        return listaDecrescente;
    }

    public static ArrayList<Integer> pares(ArrayList<Integer> numbers){
        ArrayList<Integer> numerosPares = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            if(numbers.get(i) % 2 == 0){
                numerosPares.add(numbers.get(i));
            }
        }

        return numerosPares;
    }

    public static ArrayList<Integer> impares(ArrayList<Integer> numbers){
        ArrayList<Integer> numerosImpares = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            if(numbers.get(i) % 2 != 0){
                numerosImpares.add(numbers.get(i));
            }
        }

        return numerosImpares;
    }
}