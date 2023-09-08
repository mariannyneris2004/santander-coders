public class FuncionarioPJ implements CalcularSalario{
    @Override
    public double calcular(Funcionario funcionario) {
        double salario = funcionario.getHorasMensaisContratuais() * funcionario.getValorHora();
        return salario;
    }
}
