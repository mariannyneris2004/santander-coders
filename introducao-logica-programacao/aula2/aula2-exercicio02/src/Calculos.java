import java.util.ArrayList;

public class Calculos {
    public static double calculoFrutaPreco(Fruta fruta){
        double precoFinalPorFruta, precoNormal = 1.45, precoPromocional = 1.25;

        if (fruta.getQuantidade() > 10){
            precoFinalPorFruta = fruta.getQuantidade() * precoPromocional;
        } else {
            precoFinalPorFruta = fruta.getQuantidade() * precoNormal;
        }

        return precoFinalPorFruta;
    }

    public static double calculoTotalAPagar(double[] precoPorFruta){
        double total = 0;
        for (int i = 0; i < precoPorFruta.length; i++) {
            total += precoPorFruta[i];
        }
        return total;
    }
}
