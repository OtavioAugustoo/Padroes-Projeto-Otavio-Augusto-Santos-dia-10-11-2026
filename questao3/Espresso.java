import java.math.BigDecimal;

public class Espresso extends Bebida {

    @Override
    public String getDescricao() {
        return "Espresso";
    }

    @Override
    public BigDecimal getPreco() {
        return new BigDecimal("6.00");
    }
}
