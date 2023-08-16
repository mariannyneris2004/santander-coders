package repositorio;

import modelos.Restaurante;

import java.util.HashMap;
import java.util.Map;

public class RestauranteRepositorio {
    private Map<Integer, Restaurante> restaurantes;

    public RestauranteRepositorio() {
        this.restaurantes = new HashMap<>();
    }

    public void add(Restaurante restaurante){
        restaurante.setId(restaurantes.size() + 1);

        this.restaurantes.put(restaurante.getId(), restaurante);
    }

    public Restaurante getRestaurante(String nome) {
        for (Restaurante restaurante : restaurantes.values()) {
            if(restaurante.getNome().equals(nome)){
                return restaurante;
            }
        }
        return null;
    }

    public Restaurante getRestaurante(Integer id) {
        return restaurantes.get(id);
    }

    public boolean delete(Integer id) {
        if (restaurantes.get(id) != null) {
            restaurantes.remove(id);
            return true;
        }

        return false;
    }

    public Map<Integer, Restaurante> getRestaurantes() {
        return this.restaurantes;
    }
}
