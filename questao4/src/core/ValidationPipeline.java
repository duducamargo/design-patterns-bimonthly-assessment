package core;

import validators.*;

public class ValidationPipeline {

    public ValidationContext execute(NFeDocumento documento) {

        ValidationContext context = new ValidationContext(documento);

        DocumentValidator v1 = new XmlSchemaValidator();
        DocumentValidator v2 = new CertificadoDigitalValidator();
        DocumentValidator v3 = new RegrasFiscaisValidator();
        DocumentValidator v4 = new BancoDadosValidator();
        DocumentValidator v5 = new SefazServiceValidator();

        v1.linkWith(v2)
          .linkWith(v3)
          .linkWith(v4)
          .linkWith(v5);

        v1.handle(context);

        if (context.hasFailures()) {
            context.rollbackAll();
        }

        return context;
    }
}
