package servicos;

import modelos.Prato;
import modelos.Restaurante;
import repositorio.PratoRepositorio;
import repositorio.RestauranteRepositorio;

import java.util.ArrayList;
import java.util.List;

public class PratoService {
    private PratoRepositorio pratoRepositorio;
    private List<Prato> pratosCadastrados;

    public PratoService(PratoRepositorio pratoRepositorio) {
        this.pratoRepositorio = pratoRepositorio;
        this.pratosCadastrados = new ArrayList<>();
    }

    public void cadastrarPrato(String nome, double preco, String descricao, Restaurante restaurante){
        Prato novoPrato = new Prato(nome, preco, descricao, restaurante);
        pratosCadastrados.add(novoPrato);
    }

    public String listarRestaurantesCadastrados(Restaurante restaurante){
        for (Prato prato : pratosCadastrados) {
            if (prato.getRestaurante().equals(restaurante)){
                return prato.toString();
            }
        }
        return null;
    }
}
