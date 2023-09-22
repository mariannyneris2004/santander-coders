package aula.programacaofuncional;

public class OpercaoSomar implements Opercao {
    @Override
    public Integer executar(Integer numero01, Integer numero02) {
        return numero01 + numero02;
    }
}
