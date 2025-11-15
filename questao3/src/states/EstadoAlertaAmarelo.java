package states;

import core.*;

public class EstadoAlertaAmarelo extends ReactorState {

    private long inicio = System.currentTimeMillis();

    public EstadoAlertaAmarelo(NuclearReactor reator) { super(reator); }

    @Override
    public StateType getType() { return StateType.ALERTA_AMARELO; }

    @Override
    public void avaliarEstado(ReactorData dados) {

        long agora = System.currentTimeMillis();
        long tempo = agora - inicio;

        if (dados.getTemperatura() > 400 && tempo > 30_000) {
            mudarEstado(StateType.ALERTA_VERMELHO);
        }

        if (dados.getTemperatura() < 250) {
            mudarEstado(StateType.OPERACAO_NORMAL);
        }
    }
}
