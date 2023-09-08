public class FuncionarioTerceirizado implements CalcularSalario{

    @Override
    public double calcular(Funcionario funcionario) {
        double salario = funcionario.getHorasMensaisTrabalhadas() * funcionario.getValorHora();
        return salario;
    }
}
