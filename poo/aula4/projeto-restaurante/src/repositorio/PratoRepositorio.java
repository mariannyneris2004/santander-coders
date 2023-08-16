package repositorio;

import modelos.Prato;

import java.util.HashMap;
import java.util.Map;

public class PratoRepositorio {
    private Map<Integer, Prato> pratos;

    public PratoRepositorio() {
        this.pratos = new HashMap<>();
    }

    public void add(Prato prato){
        prato.setId(pratos.size() + 1);

        this.pratos.put(prato.getId(), prato);
    }

    public Prato getPrato(String nome) {
        for (Prato prato : pratos.values()) {
            if(prato.getNome().equals(nome)){
                return prato;
            }
        }
        return null;
    }

    public Prato getPrato(Integer id) {
        return pratos.get(id);
    }

    public boolean delete(Integer id) {
        if (pratos.get(id) != null) {
            pratos.remove(id);
            return true;
        }

        return false;
    }

    public Map<Integer, Prato> getPratos() {
        return this.pratos;
    }
}
