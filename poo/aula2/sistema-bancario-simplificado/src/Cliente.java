import java.util.Objects;

public class Cliente {
    String nome;
    String cpf;
    String email;

    public Cliente(){}

    public Cliente(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(cpf, cliente.cpf);
    }

    @Override
    public String toString() {
        return "-----------------------------------------\n" +
                "Dados do Cliente\n" +
                "-----------------------------------------\n" +
                "Nome: " + nome + "\n" +
                "CPF: " + cpf + "\n" +
                "Email: " + email + "\n" +
                "-----------------------------------------";
    }
}
