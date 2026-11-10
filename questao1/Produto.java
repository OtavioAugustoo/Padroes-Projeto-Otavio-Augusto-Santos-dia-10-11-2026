package questao1;

import java.util.ArrayList;
import java.util.List;

public class Produto {
    private final String nome;
    private int quantidade;
    private final List<AreaInteressada> areas = new ArrayList<>();

    public Produto(String nome, int quantidadeInicial) {
        if (quantidadeInicial < 0) {
            throw new IllegalArgumentException("Quantidade não pode ser negativa");
        }
        this.nome = nome;
        this.quantidade = quantidadeInicial;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }


    public void adicionarArea(AreaInteressada area) {
        if (!areas.contains(area)) {
            areas.add(area);
            System.out.println("  + Área " + area.getNome() + " passou a acompanhar '" + nome + "'");
        }
    }

    
    public void removerArea(AreaInteressada area) {
        if (areas.remove(area)) {
            System.out.println("  - Área " + area.getNome() + " deixou de acompanhar '" + nome + "'");
        }
    }

    
    public void setQuantidade(int novaQuantidade) {
        if (novaQuantidade < 0) {
            throw new IllegalArgumentException("Quantidade não pode ser negativa");
        }
        
        if (novaQuantidade == this.quantidade) {
            System.out.println("  (sem mudança em '" + nome + "': continua " + quantidade
                    + " un. - nenhuma área notificada)");
            return;
        }
        this.quantidade = novaQuantidade;
        notificarAreas();
    }

    
    private void notificarAreas() {
        
        for (AreaInteressada area : new ArrayList<>(areas)) {
            area.notificar(nome, quantidade);
        }
    }
}