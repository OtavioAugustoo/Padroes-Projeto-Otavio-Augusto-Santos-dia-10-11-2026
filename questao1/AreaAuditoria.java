package questao1;

public class AreaAuditoria implements AreaInteressada {
    @Override
    public String getNome() {
        return "AuditLog []";
    }

    @Override
    public void notificar(String nomeProduto, int quantidade) {
        String mensagem = "Produto " + nomeProduto + " com quantidade " + quantidade;
        RegistroAuditoria.getInstancia().registrar(mensagem);
        System.out.println("Audit Log: " + mensagem);
    }
    
}
