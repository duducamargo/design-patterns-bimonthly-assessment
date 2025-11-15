package validators;

import core.DocumentValidator;
import core.ValidationContext;

public class RegrasFiscaisValidator extends DocumentValidator {

    public RegrasFiscaisValidator() {
        super("Regras Fiscais Validator", 3000, true);
    }

    @Override
    protected boolean doValidate(ValidationContext context) {

        boolean impostosOk = context.getDocumento().isImpostosCorretos();

        if (!impostosOk) {
            System.out.println("[FISCAL] Erro no cálculo dos impostos.");
            return false;
        }

        System.out.println("[FISCAL] Regras fiscais validadas com sucesso.");
        return true;
    }
}
