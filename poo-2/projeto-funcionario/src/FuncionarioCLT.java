public class FuncionarioCLT implements CalcularSalario{
    @Override
    public double calcular(Funcionario funcionario) {
        double salario = funcionario.getHorasMensaisContratuais() * funcionario.getValorHora();
        salario += (funcionario.getHorasMensaisTrabalhadas() - funcionario.getHorasMensaisContratuais()) * 1.5 * funcionario.getValorHora();
        return salario;
    }
}
