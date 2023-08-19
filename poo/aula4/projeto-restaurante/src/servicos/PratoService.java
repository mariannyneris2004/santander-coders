package servicos;

import exceptions.ListaVaziaException;
import exceptions.ObjetoNaoEcontradoException;
import modelos.Prato;
import modelos.Restaurante;
import repositorio.PratoRepositorio;

import java.util.Map;

public class PratoService {
    private static PratoService uniqueInstance = new PratoService();
    private PratoService() {
    }

    public static PratoService getInstance() {
        return uniqueInstance;
    }

    private PratoRepositorio pratoRepositorio = new PratoRepositorio();
    private RestauranteService restauranteService = RestauranteService.getInstance();

    public void cadastrarPrato(String nome, double preco, String descricao, Restaurante restaurante){
        Prato prato = new Prato(nome, preco, descricao, restaurante);
        pratoRepositorio.add(prato);
        restaurante.adicionarPrato(prato.getId(), prato);
    }

    public Prato getPrato(Integer id) throws ObjetoNaoEcontradoException {
        if (pratoRepositorio.getPrato(id).equals(null)){
            throw new ObjetoNaoEcontradoException("Prato não encontrado!");
        }
        return pratoRepositorio.getPrato(id);
    }

    public Prato getPrato(String nome, Restaurante restaurante) throws ObjetoNaoEcontradoException{
        Prato prato = pratoRepositorio.getPrato(nome);
        if (prato.equals(null)){
            throw new ObjetoNaoEcontradoException("Prato não encontrado!");
        }
        return pratoDoRestaurante(prato, restaurante);
    }

    public Map<Integer, Prato> getPratos() throws ListaVaziaException {
        if (pratoRepositorio.getPratos().isEmpty()){
            throw new ListaVaziaException("Nenhum prato cadastrado!");
        }
        return pratoRepositorio.getPratos();
    }

    public boolean deletePrato(Integer id){
        return pratoRepositorio.delete(id);
    }

    public Prato pratoDoRestaurante(Prato prato, Restaurante restaurante){
        if (prato.getRestaurante().equals(restaurante)){
            return prato;
        }
        return null;
    }
}
