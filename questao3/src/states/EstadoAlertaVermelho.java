package states;

import core.*;

public class EstadoAlertaVermelho extends ReactorState {

    public EstadoAlertaVermelho(NuclearReactor reator) { super(reator); }

    @Override
    public StateType getType() { return StateType.ALERTA_VERMELHO; }

    @Override
    public void avaliarEstado(ReactorData dados) {

        if (!dados.isSistemaResfriamentoOk()) {
            mudarEstado(StateType.EMERGENCIA);
        }

        if (dados.getTemperatura() < 350) {
            mudarEstado(StateType.ALERTA_AMARELO);
        }
    }
}
