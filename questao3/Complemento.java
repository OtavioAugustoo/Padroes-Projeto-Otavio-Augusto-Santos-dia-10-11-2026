import java.math.BigDecimal;

/**
 * STRATEGY: cada complemento é uma estratégia que sabe como alterar a
 * descrição e o preço do pedido (RQ3.4). O Pedido só conhece esta classe
 * abstrata, então um novo complemento é apenas uma nova subclasse (RQ3.7).
 *
 * PROTOTYPE: o cardápio guarda um exemplar de cada complemento e entrega
 * clones, permitindo repetir o mesmo complemento no pedido (RQ3.5).
 */
public abstract class Complemento implements Cloneable {

    public abstract String getNome();

    public abstract BigDecimal getValor();

    /** Estratégia de alteração da descrição. */
    public String aplicarDescricao(String descricaoAtual) {
        return descricaoAtual + ", " + getNome();
    }

    /** Estratégia de alteração do preço. */
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
