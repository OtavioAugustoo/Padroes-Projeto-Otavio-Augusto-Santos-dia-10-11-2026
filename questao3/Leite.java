import java.math.BigDecimal;

/** Complemento concreto com preço próprio (RQ3.3). */
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
