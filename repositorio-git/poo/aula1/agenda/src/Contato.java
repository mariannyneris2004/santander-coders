public class Contato {
    String nomeContato;
    String numero;

    public Contato(){
    }

    public Contato(String nomeContato, String numero){
        this.nomeContato = nomeContato;
        this.numero = numero;
    }

    public String ligar(){
        return "Ligando para " + nomeContato;
    }

    public String detalhar(){
        return "Nome do contato: " + nomeContato + "\nNúmero de contato: " + numero;
    }

    public String verNumero(){
        return numero;
    }
}
