package core;

public abstract class ReactorState {

    protected NuclearReactor reator;

    public ReactorState(NuclearReactor reator) {
        this.reator = reator;
    }

    public abstract StateType getType();

    public abstract void avaliarEstado(ReactorData dados);

    protected void mudarEstado(StateType novoEstado) {
        reator.setEstado(novoEstado);
    }
}
