import contrato.Lista;
import impl.ArrayLista;
import impl.ListaLigada;
import impl.StringArrayLista;

public class Main {
    public static void main(String[] args) {

        Lista listaArray = new ArrayLista();

        listaArray.add("primeiro elemento");
        listaArray.add("segundo elemento");
        listaArray.add(1);
        listaArray.add(2);

        imprimirLista(listaArray);

        System.out.println();

        listaArray.remove(3);

        imprimirLista(listaArray);

        System.out.println();

        Lista listaString = new StringArrayLista();
        listaString.add("meu nome");
        listaString.add("outro nome");

        imprimirLista(listaString);

        System.out.println();

        Lista listaLigada = new ListaLigada();
        listaLigada.add("primeiro elemento");
        listaLigada.add("segundo elemento");
        listaLigada.add(1);
        listaLigada.add(2);

        imprimirLista(listaLigada);

        System.out.println();

        listaLigada.remove(3);

        imprimirLista(listaLigada);
    }

    public static void imprimirLista(Lista lista) {
        for (int i = 0 ; i < lista.size() ; i++) {
            System.out.println(lista.get(i));
        }
    }

}