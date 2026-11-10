import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Pedido = uma bebida base + uma lista de complementos, em qualquer
 * combinação e quantidade (RQ3.5, RQ3.6). Descrição e preço são calculados
 * aplicando a estratégia de cada complemento (RQ3.4).
 *
 * Também é um PROTOTYPE: um pedido pode ser clonado e personalizado
 * sem alterar o original.
 */
public class Pedido implements ItemPedido, Cloneable {
    private Bebida bebida;
    private List<Complemento> complementos = new ArrayList<>();

    public Pedido(Bebida bebida) {
        if (bebida == null) {
            throw new IllegalArgumentException("O pedido precisa de uma bebida base");
        }
        this.bebida = bebida;
    }

    public Pedido adicionar(Complemento complemento) {
        complementos.add(complemento);
        return this; // permite encadear: pedido.adicionar(a).adicionar(b)
    }

    @Override
    public String getDescricao() {
        String descricao = bebida.getDescricao();
        for (Complemento c : complementos) {
            descricao = c.aplicarDescricao(descricao);
        }
        return descricao;
    }

    @Override
    public BigDecimal getPreco() {
        BigDecimal preco = bebida.getPreco();
        for (Complemento c : complementos) {
            preco = c.aplicarPreco(preco);
        }
        return preco;
    }

    /** Cópia profunda: clona a bebida e cada complemento. */
    @Override
    public Pedido clone() {
        try {
            Pedido copia = (Pedido) super.clone();
            copia.bebida = bebida.clone();
            copia.complementos = new ArrayList<>();
            for (Complemento c : complementos) {
                copia.complementos.add(c.clone());
            }
            return copia;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
