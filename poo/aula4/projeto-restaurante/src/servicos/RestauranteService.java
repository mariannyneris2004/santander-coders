package servicos;

import modelos.Prato;
import modelos.Restaurante;
import repositorio.RestauranteRepositorio;

import java.util.ArrayList;
import java.util.List;

public class RestauranteService {
    private RestauranteRepositorio restauranteRepositorio;

    public RestauranteService(RestauranteRepositorio restauranteRepositorio) {
        this.restauranteRepositorio = restauranteRepositorio;
    }

    public void cadastrarRestaurante(String nome, String endereco){
        if (restauranteRepositorio.getRestaurante(nome) == null){
            Restaurante novoRestaurante = new Restaurante(nome, endereco, new ArrayList<Prato>());
            restauranteRepositorio.add(novoRestaurante);
        }
    }

    public List<String> listarRestaurantesCadastrados(){
        List<String> nomes = new ArrayList<>();

        for (Restaurante restaurante:restauranteRepositorio.getListaRestaurantes()) {
            nomes.add(restaurante.getNome());
        }
        return nomes;
    }
}
