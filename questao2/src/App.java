import adapter.ProcessadorTransacoesAdapter;
import moderno.RespostaTransacao;
import legado.SistemaBancarioLegado;

public class App {

    public static void main(String[] args) {

        ProcessadorTransacoesAdapter adapter =
                new ProcessadorTransacoesAdapter(new SistemaBancarioLegado());

        System.out.println("\n=== TESTE DE INTEGRAÇÃO COM LEGADO (Adapter Pattern) ===\n");

        RespostaTransacao r1 = adapter.autorizar("1234-5678-9999-0000", 2500.00, "USD");
        System.out.println("Resposta (moderna): " + r1);

        RespostaTransacao r2 = adapter.autorizar("1234-5678-9999-0000", 9000.00, "BRL");
        System.out.println("Resposta (moderna): " + r2);
    }
}
