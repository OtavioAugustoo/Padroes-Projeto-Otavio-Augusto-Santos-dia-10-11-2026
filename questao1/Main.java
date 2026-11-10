package questao1;

public class Main {
    public static void main(String[] args) {
        AreaInteressada compras = new AreaCompras();
        AreaInteressada vendas = new AreaVendas();
        AreaInteressada auditoria = new AreaAuditoria();

        Produto notebook = new Produto("Notebook", 10);
        Produto mouse = new Produto("Mouse", 20);

        System.out.println("=== Cadastro das áreas interessadas ===");
        notebook.adicionarArea(compras);
        notebook.adicionarArea(vendas);
        notebook.adicionarArea(auditoria);
        mouse.adicionarArea(compras);
        mouse.adicionarArea(auditoria);

        System.out.println("\n>> Notebook: 10 -> 7");
        notebook.setQuantidade(7);

        System.out.println("\n>> Notebook: 7 -> 3 (abaixo de 5)");
        notebook.setQuantidade(3);

        System.out.println("\n>> Notebook: 3 -> 0 (zerou)");
        notebook.setQuantidade(0);

        System.out.println("\n>> Notebook: 0 -> 0 (mesmo valor)");
        notebook.setQuantidade(0);

        System.out.println("\n>> Notebook: 0 -> 15 (reposição)");
        notebook.setQuantidade(15);

        System.out.println("\n>> Mouse: 20 -> 4");
        mouse.setQuantidade(4);

        System.out.println("\n=== Removendo a área Compras do Notebook ===");
        notebook.removerArea(compras);

        System.out.println("\n>> Notebook: 15 -> 2 (Compras não deve mais alertar)");
        notebook.setQuantidade(2);

        System.out.println("\n>> Mouse: 4 -> 1 (Compras continua acompanhando o Mouse)");
        mouse.setQuantidade(1);

        
        RegistroAuditoria log1 = RegistroAuditoria.getInstancia();
        RegistroAuditoria log2 = RegistroAuditoria.getInstancia();
        System.out.println("\nMesma instância do registro de auditoria? " + (log1 == log2));

        log1.imprimir();
    }
}
