import java.math.BigDecimal;

/** Bebida base com preço próprio (RQ3.2). */
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
