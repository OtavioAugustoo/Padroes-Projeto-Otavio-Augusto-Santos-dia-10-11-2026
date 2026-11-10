import java.math.BigDecimal;

/** Toda bebida e todo pedido fornecem descrição e preço (RQ3.1). */
public interface ItemPedido {
    String getDescricao();

    BigDecimal getPreco();
}
