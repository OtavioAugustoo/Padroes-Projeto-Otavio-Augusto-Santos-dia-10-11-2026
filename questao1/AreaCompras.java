package questao1;

public class AreaCompras implements AreaInteressada {
    private static final int LIMITE_MINIMO = 5;

    @Override
    public String getNome() {
        return "Compras";
    }

    @Override
    public void notificar(String nomeProduto, int novaQuantidade) {
        if (novaQuantidade < LIMITE_MINIMO) {
            System.out.println("  [COMPRAS]   ALERTA: estoque baixo de '" + nomeProduto
                    + "' (" + novaQuantidade + " un.). Providenciar reposição.");
        }
    }
}

