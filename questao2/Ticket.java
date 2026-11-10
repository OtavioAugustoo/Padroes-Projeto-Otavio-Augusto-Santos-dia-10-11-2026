import java.math.BigDecimal;

public class Ticket {
    private final String placa;
    private final int minutos;
    private PerfilCobranca perfil;

    public Ticket(String placa, int minutos, PerfilCobranca perfil) {
        if (minutos < 0) {
            throw new IllegalArgumentException("Tempo de permanência não pode ser negativo");
        }
        this.placa = placa;
        this.minutos = minutos;
        setPerfil(perfil);
    }

    public String getPlaca() {
        return placa;
    }

    public int getMinutos() {
        return minutos;
    }

    public PerfilCobranca getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilCobranca perfil) {
        if (perfil == null) {
            throw new IllegalArgumentException("O tíquete precisa de um perfil de cobrança");
        }
        this.perfil = perfil;
    }

    public BigDecimal calcularValor() {
        return perfil.calcular(minutos);
    }
}
