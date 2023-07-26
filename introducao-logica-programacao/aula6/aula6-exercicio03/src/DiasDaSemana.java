public enum DiasDaSemana {
    DOMINGO("Domingo"),
    SEGUNDA("Segunda-feira"),
    TERCA("Terça-feira"),
    QUARTA("Quarta-feira"),
    QUINTA("Quinta-feira"),
    SEXTA("Sexta-feira"),
    SABADO("Sábado");

    final String nome;

    DiasDaSemana(String nome) {
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public static DiasDaSemana getDiaDaSemana(String nome){
        switch (nome){
            case("Domingo"):
                return DiasDaSemana.DOMINGO;
            case("Segunda-feira"):
                return DiasDaSemana.SEGUNDA;
            case("Terça-feira"):
                return DiasDaSemana.TERCA;
            case("Quarta-feira"):
                return DiasDaSemana.QUARTA;
            case("Quinta-feira"):
                return DiasDaSemana.QUINTA;
            case("Sexta-feira"):
                return DiasDaSemana.SEXTA;
            case("Sábado"):
                return DiasDaSemana.SABADO;
        }
        return null;
    }
}
