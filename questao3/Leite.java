import java.math.BigDecimal;

public class Leite extends Complemento {

    @Override
    public String getNome() {
        return "Leite";
    }

    @Override
    public BigDecimal getValor() {
        return new BigDecimal("2.00");
    }
}
