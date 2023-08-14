package repositorio;

import modelos.Prato;

import java.util.ArrayList;
import java.util.List;

public class PratoRepositorio {
    private List<Prato> pratos;

    public PratoRepositorio() {
        this.pratos = new ArrayList<>();
    }

    public void add(Prato prato){
        this.pratos.add(prato);
    }

    public Prato getPrato(String nome) {
        for (Prato prato : pratos) {
            if(prato.getRestaurante().equals(nome)){
                return prato;
            }
        }
        return null;
    }

    public List<Prato> pratosCadastrados(){
        return pratos;
    }
}
