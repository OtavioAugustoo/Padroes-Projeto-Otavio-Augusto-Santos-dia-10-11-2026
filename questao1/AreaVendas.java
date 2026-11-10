package questao1;

public class AreaVendas implements AreaInteressada {
    @Override
    public String getNome() {
        return "AreaVendas []";
    }

    @Override
    public void notificar(String nomeProduto, int quantidade) {
        System.out.println("Notificação para a área de vendas: Produto " + nomeProduto + " com quantidade " + quantidade);
    }
    
}
