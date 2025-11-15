package states;

import core.*;

public class EstadoDesligado extends ReactorState {

    public EstadoDesligado(NuclearReactor reator) { super(reator); }

    @Override
    public StateType getType() { return StateType.DESLIGADA; }

    @Override
    public void avaliarEstado(ReactorData dados) {
        if (dados.getTemperatura() > 50) {
            System.out.println("Ligando para operação normal...");
            mudarEstado(StateType.OPERACAO_NORMAL);
        }
    }
}
