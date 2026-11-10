package questao1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public final class RegistroAuditoria {
    private static RegistroAuditoria instancia;
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("HH:mm:ss");

    private final List<String> registros = new ArrayList<>();

    
    private RegistroAuditoria() {
    }

    public static synchronized RegistroAuditoria getInstancia() {
        if (instancia == null) {
            instancia = new RegistroAuditoria();
        }
        return instancia;
    }

    public void registrar(String mensagem) {
        registros.add(LocalDateTime.now().format(FORMATO) + " - " + mensagem);
    }

    public List<String> getRegistros() {
        return Collections.unmodifiableList(registros);
    }

    public void imprimir() {
        System.out.println("\n===== LOG DE AUDITORIA (" + registros.size() + " registros) =====");
        for (int i = 0; i < registros.size(); i++) {
            System.out.println((i + 1) + ". " + registros.get(i));
        }
    }
}
