import java.text.NumberFormat;
import java.util.Locale;


public class Main {
    private static final NumberFormat REAL =
            NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"));

    public static void main(String[] args) {
        
        Cardapio cardapio = Cardapio.getInstancia();

        // PROTOTYPE
        cardapio.registrarBebida("espresso", new Espresso());
        cardapio.registrarBebida("cha", new Cha());
        cardapio.registrarComplemento("leite", new Leite());
        cardapio.registrarComplemento("chantilly", new Chantilly());
        cardapio.registrarComplemento("calda", new Calda());

        //pedido : Espresso + Leite
        Pedido pedido1 = new Pedido(cardapio.novaBebida("espresso"))
                .adicionar(cardapio.novoComplemento("leite"));

        //Pedido 2 Cha + calda + chantily
        Pedido pedido2 = new Pedido(cardapio.novaBebida("cha"))
                .adicionar(cardapio.novoComplemento("calda"))
                .adicionar(cardapio.novoComplemento("chantilly"));

        // Pedido3 Espresso + Leite + Chantilly + Chantilly
        Pedido pedido3 = new Pedido(cardapio.novaBebida("espresso"))
                .adicionar(cardapio.novoComplemento("leite"))
                .adicionar(cardapio.novoComplemento("chantilly"))
                .adicionar(cardapio.novoComplemento("chantilly"));

        // Pedido 4só a bebida base
        Pedido pedido4 = new Pedido(cardapio.novaBebida("cha"));

        // PROTOTYPE de pedido clona o pedido 3 e acrescenta Calda
        Pedido pedido5 = pedido3.clone().adicionar(cardapio.novoComplemento("calda"));

        imprimir("Pedido 1", pedido1);
        imprimir("Pedido 2", pedido2);
        imprimir("Pedido 3", pedido3);
        imprimir("Pedido 4", pedido4);
        imprimir("Pedido 5 (clone do 3 + Calda)", pedido5);

        System.out.println("\nCardápio é instância única? "
                + (cardapio == Cardapio.getInstancia()));
        System.out.println("Pedido 3 continua intacto após o clone? "
                + pedido3.getDescricao().equals("Espresso, Leite, Chantilly, Chantilly"));
    }

    private static void imprimir(String rotulo, ItemPedido item) {
        System.out.println(rotulo + ": " + item.getDescricao()
                + " -> " + REAL.format(item.getPreco()));
    }
}
