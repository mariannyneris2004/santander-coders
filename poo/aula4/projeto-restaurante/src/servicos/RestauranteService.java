package servicos;

import modelos.Restaurante;
import repositorio.RestauranteRepositorio;

import java.util.Map;

public class RestauranteService {
    private static RestauranteService uniqueInstance = new RestauranteService();

    private RestauranteService() {
    }

    public static RestauranteService getInstance() {
        return uniqueInstance;
    }

    private RestauranteRepositorio restauranteRepositorio = new RestauranteRepositorio();

    public String cadastrarRestaurante(String nome, String endereco){
        Restaurante restaurante = new Restaurante(nome, endereco);
        restauranteRepositorio.add(restaurante);
        return "Código do restaurante: " + restaurante.getId();
    }

    public Restaurante getRestaurante(Integer id){
        return restauranteRepositorio.getRestaurante(id);
    }

    public Restaurante getRestaurante(String nome){
        return restauranteRepositorio.getRestaurante(nome);
    }

    public Map<Integer, Restaurante> getRestaurantes(){
        return restauranteRepositorio.getRestaurantes();
    }

    public boolean deleteRestaurante(Integer id){
        return restauranteRepositorio.delete(id);
    }

    public boolean deleteRestaurante(String nome){
        Restaurante restaurante = restauranteRepositorio.getRestaurante(nome);
        return restauranteRepositorio.delete(restaurante.getId());
    }
}
