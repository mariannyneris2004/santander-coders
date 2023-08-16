package servicos;

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

    public void cadastrarPrato(String nome, double preco, String descricao, Restaurante restaurante){
        Prato prato = new Prato(nome, preco, descricao, restaurante);
        pratoRepositorio.add(prato);
        restaurante.adicionarPrato(prato.getId(), prato);
    }

    public Prato getPrato(Integer id){
        return pratoRepositorio.getPrato(id);
    }

    public Prato getPrato(String nome){
        return pratoRepositorio.getPrato(nome);
    }

    public Map<Integer, Prato> getPratos(){
        return pratoRepositorio.getPratos();
    }

    public boolean deletePrato(Integer id){
        return pratoRepositorio.delete(id);
    }

    public boolean deletePrato(String nome){
        Prato prato = pratoRepositorio.getPrato(nome);
        return pratoRepositorio.delete(prato.getId());
    }
}
