import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;


public class Main {
    private static final NumberFormat REAL =
            NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"));

    public static void main(String[] args) {
        List<PerfilCobranca> perfis = List.of(
                new PerfilRotativo(), new PerfilMensalista(), new PerfilConveniado());

        int tempo = 135; // 
        System.out.println("=== Mesmo tempo (" + tempo + " min) nos três perfis ===");
        for (PerfilCobranca perfil : perfis) {
            Ticket t = new Ticket("ABC1D23", tempo, perfil);
            System.out.println(String.format("%-11s -> %s", perfil.getNome(),
                    REAL.format(t.calcularValor())));
        }

        System.out.println("\n=== Outros tempos, para conferir as regras ===");
        System.out.println(String.format("%-8s %-12s %-12s %-12s",
                "Minutos", "Rotativo", "Mensalista", "Conveniado"));
        for (int minutos : new int[] {20, 30, 31, 60, 61, 90, 91}) {
            StringBuilder linha = new StringBuilder(String.format("%-8d", minutos));
            for (PerfilCobranca perfil : perfis) {
                linha.append(String.format(" %-12s", REAL.format(perfil.calcular(minutos))));
            }
            System.out.println(linha);
        }

        System.out.println("\n=== Troca de perfil no mesmo tíquete ===");
        Ticket ticket = new Ticket("XYZ9K87", 100, new PerfilRotativo());
        imprimir(ticket);

        ticket.setPerfil(new PerfilConveniado());
        imprimir(ticket);

        ticket.setPerfil(new PerfilMensalista());
        imprimir(ticket);
    }

    private static void imprimir(Ticket t) {
        BigDecimal valor = t.calcularValor();
        System.out.println("Placa " + t.getPlaca() + " | " + t.getMinutos() + " min | perfil "
                + t.getPerfil().getNome() + " -> " + REAL.format(valor));
    }
}
