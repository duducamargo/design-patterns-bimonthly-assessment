package states;

import core.*;

public class EstadoEmergencia extends ReactorState {

    public EstadoEmergencia(NuclearReactor reator) { super(reator); }

    @Override
    public StateType getType() { return StateType.EMERGENCIA; }

    @Override
    public void avaliarEstado(ReactorData dados) {
        System.out.println("🚨 REATOR EM EMERGÊNCIA! PROCEDIMENTOS IMEDIATOS NECESSÁRIOS!");
    }
}
