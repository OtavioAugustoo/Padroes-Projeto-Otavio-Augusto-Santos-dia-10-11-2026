import java.math.BigDecimal;

/** Bebida base com preço próprio (RQ3.2). */
public class Cha extends Bebida {

    @Override
    public String getDescricao() {
        return "Chá";
    }

    @Override
    public BigDecimal getPreco() {
        return new BigDecimal("4.50");
    }
}
