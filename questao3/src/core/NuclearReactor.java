package core;

import states.*;

public class NuclearReactor {

    private ReactorState estadoAtual;
    private ReactorData dados;
    private MaintenanceMode maintenance;

    private boolean passouPorVermelho = false;

    public NuclearReactor() {
        this.dados = new ReactorData();
        this.maintenance = new MaintenanceMode();
        setEstado(StateType.DESLIGADA);
    }

    public ReactorData getDados() { return dados; }

    public void setEstado(StateType tipo) {

        if (maintenance.isAtivo() && tipo != StateType.MANUTENCAO) {
            System.out.println("Estado ignorado: Sistema em MANUTENÇÃO.");
            return;
        }

        switch (tipo) {
            case DESLIGADA -> estadoAtual = new EstadoDesligado(this);
            case OPERACAO_NORMAL -> estadoAtual = new EstadoOperacaoNormal(this);
            case ALERTA_AMARELO -> estadoAtual = new EstadoAlertaAmarelo(this);
            case ALERTA_VERMELHO -> {
                estadoAtual = new EstadoAlertaVermelho(this);
                passouPorVermelho = true;
            }
            case EMERGENCIA -> {
                if (!passouPorVermelho) {
                    System.out.println("⚠ ERRO: Estado EMERGENCIA só pode ser ativado após ALERTA_VERMELHO!");
                    return;
                }
                estadoAtual = new EstadoEmergencia(this);
            }
            case MANUTENCAO -> maintenance.ativar();
        }

        System.out.println("Estado atual: " + estadoAtual.getType());
    }

    public void atualizar() {
        estadoAtual.avaliarEstado(dados);
    }

    public void ativarModoManutencao() { maintenance.ativar(); }
    public void desativarModoManutencao() { maintenance.desativar(); }
}
