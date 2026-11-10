import java.math.BigDecimal;

public abstract class Complemento implements Cloneable {

    public abstract String getNome();

    public abstract BigDecimal getValor();

    public String aplicarDescricao(String descricaoAtual) {
        return descricaoAtual + ", " + getNome();
    }

    public BigDecimal aplicarPreco(BigDecimal precoAtual) {
        return precoAtual.add(getValor());
    }

    @Override
    public Complemento clone() {
        try {
            return (Complemento) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
