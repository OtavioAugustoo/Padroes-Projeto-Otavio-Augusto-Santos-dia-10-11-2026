import java.math.BigDecimal;
import java.math.RoundingMode;

public class PerfilConveniado implements PerfilCobranca {
    public static final int MINUTOS_GRATUITOS = 30;
    public static final BigDecimal VALOR_HORA = new BigDecimal("8.00");
    public static final BigDecimal PERCENTUAL_DESCONTO = new BigDecimal("20"); // 20%

    @Override
    public String getNome() {
        return "Conveniado";
    }

    @Override
    public BigDecimal calcular(int minutos) {
        int minutosCobrados = Math.max(0, minutos - MINUTOS_GRATUITOS);
        int horas = PerfilCobranca.horasIniciadas(minutosCobrados);

        BigDecimal fatorDesconto = BigDecimal.ONE.subtract(
                PERCENTUAL_DESCONTO.divide(new BigDecimal("100")));
        BigDecimal valorHoraComDesconto = VALOR_HORA.multiply(fatorDesconto);

        return valorHoraComDesconto.multiply(BigDecimal.valueOf(horas))
                .setScale(2, RoundingMode.HALF_UP);
    }
}
