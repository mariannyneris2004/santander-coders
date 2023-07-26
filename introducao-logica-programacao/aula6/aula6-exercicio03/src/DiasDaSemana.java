public enum DiasDaSemana {
    DOMINGO(new String[]{"Domingo", "d", "dom"}),
    SEGUNDA(new String[]{"Segunda-feira","Segunda", "seg"}),
    TERCA(new String[]{"Terça-feira","Terça", "t", "ter"}),
    QUARTA(new String[]{"Quarta-feira","Quarta", "qua"}),
    QUINTA(new String[]{"Quinta-feira","Quinta", "qui"}),
    SEXTA(new String[]{"Sexta-feira","Sexta", "sex"}),
    SABADO(new String[]{"Sábado", "s", "sab"});

    final String[] nomes;

    DiasDaSemana(String[] nomes) {
        this.nomes = nomes;
    }

    public String[] getNomes(){
        return this.nomes;
    }

    public static DiasDaSemana stringParaEnum(String nome) {
        for (DiasDaSemana dia : DiasDaSemana.values()) {
            for (String nomeDia : dia.getNomes()) {
                if (nomeDia.equalsIgnoreCase(nome)) {
                    return dia;
                }
            }
        }
        throw new IllegalArgumentException("Dia inválido!");
    }
}
