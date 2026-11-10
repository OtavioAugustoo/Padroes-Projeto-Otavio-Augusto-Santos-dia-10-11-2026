import java.math.BigDecimal;

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
