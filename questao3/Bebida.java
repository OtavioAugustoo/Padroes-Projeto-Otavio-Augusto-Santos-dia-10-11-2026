import java.math.BigDecimal;


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
