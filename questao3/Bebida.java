import java.math.BigDecimal;

/**
 * Bebida base. É um PROTOTYPE: o cardápio guarda um exemplar de cada
 * bebida e entrega clones dele para cada pedido.
 */
public abstract class Bebida implements ItemPedido, Cloneable {

    @Override
    public Bebida clone() {
        try {
            return (Bebida) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
