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

    public static DiasDaSemana stringParaEnum(String nome) {
        for (DiasDaSemana dia : DiasDaSemana.values()) {
            if (dia.getNome().equalsIgnoreCase(nome)) {
                return dia;
            }
        }
        throw new IllegalArgumentException("Dia inválido!");
    }
}
