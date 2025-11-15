package validators;

import core.DocumentValidator;
import core.ValidationContext;

public class XmlSchemaValidator extends DocumentValidator {

    public XmlSchemaValidator() {
        super("XML Schema Validator", 2000, false);
    }

    @Override
    protected boolean doValidate(ValidationContext context) {

        String xml = context.getDocumento().getXml();

        if (xml == null || xml.isBlank()) {
            System.out.println("[XML] Documento sem XML válido.");
            return false;
        }

        System.out.println("[XML] Validando XML contra XSD (simulado)...");
        return true;
    }
}
