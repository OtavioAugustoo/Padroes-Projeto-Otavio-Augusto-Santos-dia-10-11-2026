import java.math.BigDecimal;

public class PerfilRotativo implements PerfilCobranca {
    public static final BigDecimal VALOR_HORA = new BigDecimal("8.00");

    @Override
    public String getNome() {
        return "Rotativo";
    }

    @Override
    public BigDecimal calcular(int minutos) {
        int horas = PerfilCobranca.horasIniciadas(minutos);
        return VALOR_HORA.multiply(BigDecimal.valueOf(horas));
    }
}
