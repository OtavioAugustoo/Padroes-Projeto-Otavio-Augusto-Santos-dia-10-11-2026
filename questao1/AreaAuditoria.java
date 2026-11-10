package questao1;

public class AreaAuditoria implements AreaInteressada {
    @Override
    public String getNome() {
        return "AuditLog []";
    }

    @Override
    public void notificar(String nomeProduto, int quantidade) {
        System.out.println("Audit Log: Produto " + nomeProduto + " com quantidade " + quantidade);
    }
    
}
