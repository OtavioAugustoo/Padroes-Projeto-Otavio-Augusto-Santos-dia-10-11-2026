import java.math.BigDecimal;

/** Complemento concreto com preço próprio (RQ3.3). */
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
