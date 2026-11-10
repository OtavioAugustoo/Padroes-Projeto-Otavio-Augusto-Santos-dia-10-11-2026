import java.util.HashMap;
import java.util.Map;


public final class Cardapio {
    private static Cardapio instancia;

    private final Map<String, Bebida> bebidas = new HashMap<>();
    private final Map<String, Complemento> complementos = new HashMap<>();

    private Cardapio() {
    }

    public static synchronized Cardapio getInstancia() {
        if (instancia == null) {
            instancia = new Cardapio();
        }
        return instancia;
    }

    public void registrarBebida(String codigo, Bebida prototipo) {
        bebidas.put(codigo, prototipo);
    }

    public void registrarComplemento(String codigo, Complemento prototipo) {
        complementos.put(codigo, prototipo);
    }

    public Bebida novaBebida(String codigo) {
        Bebida prototipo = bebidas.get(codigo);
        if (prototipo == null) {
            throw new IllegalArgumentException("Bebida não cadastrada: " + codigo);
        }
        return prototipo.clone();
    }

    public Complemento novoComplemento(String codigo) {
        Complemento prototipo = complementos.get(codigo);
        if (prototipo == null) {
            throw new IllegalArgumentException("Complemento não cadastrado: " + codigo);
        }
        return prototipo.clone();
    }
}
