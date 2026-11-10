import java.math.BigDecimal;

public class Chantilly extends Complemento {

    @Override
    public String getNome() {
        return "Chantilly";
    }

    @Override
    public BigDecimal getValor() {
        return new BigDecimal("2.50");
    }
}
