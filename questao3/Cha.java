import java.math.BigDecimal;

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
