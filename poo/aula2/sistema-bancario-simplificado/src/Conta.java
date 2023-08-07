import java.util.Objects;

public class Conta {
    Cliente cliente;
    int numeroDaConta;
    double saldo;

    public Conta(Cliente cliente, int numeroDaConta) {
        this.cliente = cliente;
        this.numeroDaConta = numeroDaConta;
        this.saldo = 0;
    }

    public double depositar(double valorADepositar){
        return this.saldo += valorADepositar;
    }

    public double sacar(double valorASacar) throws OperacoesException {
        if (valorASacar <= saldo){
            return saldo -= valorASacar;
        } else {
            throw new OperacoesException("Saldo insuficiente.");
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getNumeroDaConta() {
        return numeroDaConta;
    }

    public void setNumeroDaConta(int numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Conta conta)) return false;
        return getNumeroDaConta() == conta.getNumeroDaConta();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumeroDaConta());
    }

    @Override
    public String toString() {
        return /*"-----------------------------------------" +
                "Dados do Conta\n" +*/
                "-----------------------------------------\n" +
                "Cliente: " + cliente.getNome() + "\n" +
                "Número da conta: " + numeroDaConta + "\n" +
                "Saldo: " + saldo + "\n" +
                "-----------------------------------------";
    }
}
