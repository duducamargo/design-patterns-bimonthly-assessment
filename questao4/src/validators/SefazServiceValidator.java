package validators;

import core.DocumentValidator;
import core.ValidationContext;

public class SefazServiceValidator extends DocumentValidator {

    public SefazServiceValidator() {
        super("SEFAZ Service Validator", 5000, true);
    }

    @Override
    protected boolean doValidate(ValidationContext context) {

        boolean ok = context.getDocumento().isRespostaSefazOk();

        if (!ok) {
            System.out.println("[SEFAZ] Falha na consulta online da NF-e.");
            return false;
        }

        System.out.println("[SEFAZ] Consulta SEFAZ realizada com sucesso.");
        return true;
    }
}
