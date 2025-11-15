package validators;

import core.DocumentValidator;
import core.ValidationContext;

public class CertificadoDigitalValidator extends DocumentValidator {

    public CertificadoDigitalValidator() {
        super("Certificado Digital Validator", 1500, false);
    }

    @Override
    protected boolean doValidate(ValidationContext context) {

        boolean valido = context.getDocumento().isCertificadoValido();

        if (!valido) {
            System.out.println("[CERTIFICADO] Certificado inválido, expirado ou revogado.");
            return false;
        }

        System.out.println("[CERTIFICADO] Certificado digital válido.");
        return true;
    }
}
