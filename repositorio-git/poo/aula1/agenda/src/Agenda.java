import java.util.ArrayList;

public class Agenda {
    ArrayList<Contato> contatos;

    public Agenda(){
    }

    public Agenda(ArrayList<Contato> contatos){
        this.contatos = contatos;
    }

    public ArrayList<Contato> deletar(Contato contatoDeletar){
        for (Contato contato : this.contatos) {
            if (contato.equals(contatoDeletar)){
                this.contatos.remove(contatoDeletar);
                return this.contatos;
            }
        }
        return this.contatos;
    }

    public Contato buscarContato(String contatoBusca){

        for (int i = 0; i < contatos.size(); i++) {
            if (contatos.get(i).nomeContato.equals(contatoBusca)){
                return contatos.get(i);
            }
        }
        return null;
    }

    public String buscarPorNome(String contatoBusca){

        for (int i = 0; i < contatos.size(); i++) {
            if (contatos.get(i).nomeContato.equals(contatoBusca)){
                return "O contato " + contatos.get(i).nomeContato + " está na posição " + i + " e seu número é "
                        + contatos.get(i).numero;
            }
        }
        return "Contato não encontrado";
    }

    public String buscarPorNumero(String contatoBusca){

        for (int i = 0; i < contatos.size(); i++) {
            if (contatos.get(i).numero.equals(contatoBusca)){
                return "O contato de número " + contatos.get(i).verNumero() + " é o de "+ contatos.get(i).nomeContato +
                        ", que está na posição " + i;
            }
        }
        return "Contato não encontrado";
    }

    public ArrayList<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(ArrayList<Contato> contatos) {
        this.contatos = contatos;
    }
}
