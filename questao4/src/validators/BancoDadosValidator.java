package validators;

import core.DocumentValidator;
import core.ValidationContext;
import core.NFeDocumento;

import java.util.HashSet;
import java.util.Set;

public class BancoDadosValidator extends DocumentValidator {

    private static final Set<String> NUMEROS_REGISTRADOS = new HashSet<>();

    public BancoDadosValidator() {
        super("Banco de Dados Validator", 2500, false);
    }

    @Override
    protected boolean doValidate(ValidationContext context) {
        NFeDocumento doc = context.getDocumento();
        String numero = doc.getNumero();

        if (NUMEROS_REGISTRADOS.contains(numero)) {
            System.out.println("[DB] Número de NF-e já existe na base. Duplicidade detectada.");
            return false;
        }

        System.out.println("[DB] Inserindo NF-e na base (simulado).");
        NUMEROS_REGISTRADOS.add(numero);

        context.registerRollbackAction(() -> {
            System.out.println("[DB][ROLLBACK] Removendo NF-e da base: " + numero);
            NUMEROS_REGISTRADOS.remove(numero);
        });

        return true;
    }
}
