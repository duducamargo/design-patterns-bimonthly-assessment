package states;

import core.*;

public class EstadoOperacaoNormal extends ReactorState {

    public EstadoOperacaoNormal(NuclearReactor reator) { super(reator); }

    @Override
    public StateType getType() { return StateType.OPERACAO_NORMAL; }

    @Override
    public void avaliarEstado(ReactorData dados) {

        if (dados.getTemperatura() > 300) {
            mudarEstado(StateType.ALERTA_AMARELO);
        }
    }
}
