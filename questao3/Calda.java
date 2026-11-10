import java.math.BigDecimal;

/** Complemento concreto com preço próprio (RQ3.3). */
public class Calda extends Complemento {

    @Override
    public String getNome() {
        return "Calda de chocolate";
    }

    @Override
    public BigDecimal getValor() {
        return new BigDecimal("1.50");
    }
}
