import core.*;

public class App {

    public static void main(String[] args) throws InterruptedException {

        NuclearReactor reator = new NuclearReactor();

        ReactorData dados = reator.getDados();

        System.out.println("\n--- Simulação Iniciada ---\n");

        dados.setTemperatura(100);
        reator.atualizar();

        dados.setTemperatura(350);
        reator.atualizar();

        Thread.sleep(31_000);
        dados.setTemperatura(450);
        reator.atualizar();

        dados.setSistemaResfriamentoOk(false);
        reator.atualizar();

        System.out.println("\n--- Fim da Simulação ---");
    }
}
