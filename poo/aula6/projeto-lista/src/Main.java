import contrato.Lista;
import impl.ArrayLista;
import impl.ListaLigada;
import impl.StringArrayLista;

public class Main {
    public static void main(String[] args) {
        Lista lista = new ArrayLista();

        lista.add("primeiro elemento");
        lista.add("segundo elemento");
        lista.add(3);
        lista.add(4);

        Lista listaString = new StringArrayLista();
        listaString.add("meu nome");
        listaString.add("outro nome");

        Lista listaLigada = new ListaLigada();
        listaLigada.add("primeiro elemento");
        listaLigada.add("segundo elemento");
        listaLigada.add(3);
        listaLigada.add(4);

        /*imprimirLista(lista);
        imprimirLista(listaString);*/
        imprimirLista(listaLigada);

    }

    public static void imprimirLista(Lista lista){
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }
}