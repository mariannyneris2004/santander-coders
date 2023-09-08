public class CalcularRecebimento {

    public double calculaSalario(Funcionario funcionario) {
        double salario = 0;
        CalcularSalario calcular;

        if ("CLT".equalsIgnoreCase(funcionario.getTipo())) {
            calcular = new FuncionarioCLT();
            salario = calcular.calcular(funcionario);
        } else if("PJ".equalsIgnoreCase(funcionario.getTipo())) {
            calcular = new FuncionarioPJ();
            salario = calcular.calcular(funcionario);
        } else if("TERCEIRIZADO".equalsIgnoreCase(funcionario.getTipo())) {
            calcular = new FuncionarioTerceirizado();
            salario = calcular.calcular(funcionario);
        } else {
            System.err.println("Tipo inválido!");
        }

        return salario;
    }
}