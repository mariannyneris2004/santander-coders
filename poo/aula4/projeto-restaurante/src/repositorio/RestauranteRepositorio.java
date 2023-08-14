package repositorio;

import modelos.Restaurante;

import java.util.ArrayList;
import java.util.List;

public class RestauranteRepositorio {
    private List<Restaurante> restaurantes;

    public RestauranteRepositorio() {
        this.restaurantes = new ArrayList<>();
    }

    public void add(Restaurante restaurante){
        this.restaurantes.add(restaurante);
    }

    public Restaurante getRestaurante(String nome) {
        for (Restaurante restaurante : restaurantes) {
            if(restaurante.getNome().equals(nome)){
                return restaurante;
            }
        }
        return null;
    }

    public List<Restaurante> getListaRestaurantes(){
        return restaurantes;
    }
}
