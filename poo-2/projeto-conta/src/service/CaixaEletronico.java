package service;

public class CaixaEletronico {
    MenuSeletor menuSeletor;
    public CaixaEletronico(MenuSeletor menuSeletor) {
        this.menuSeletor = menuSeletor;
    }



    public boolean execute() {
        int opcao = menuSeletor.execute();
        boolean resultado;

        return switch (opcao) {
            case 0 -> false;
            case 1 -> true; // ver saldo
            case 2 -> true;// sacar
            case 3 -> true;// depositar
            case 4 -> true;// transferir
            default -> menuSeletor.tryAgain();
        };
    }
}