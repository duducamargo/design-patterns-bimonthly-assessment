import core.*;

public class App {

    public static void main(String[] args) {

        NFeDocumento doc = new NFeDocumento("<xml>NF-e</xml>", "NF12345");

        doc.setCertificadoValido(true);
        doc.setImpostosCorretos(true);
        doc.setRespostaSefazOk(false);

        ValidationPipeline pipeline = new ValidationPipeline();
        ValidationContext context = pipeline.execute(doc);

        System.out.println("\n=== RESULTADO FINAL ===");
        context.getResults().forEach(r -> System.out.println(r.toString()));

        System.out.println("\nFalhas totais: " + context.getFailuresCount());
        System.out.println("Circuit breaker aberto? " + context.isCircuitOpen());
    }
}
