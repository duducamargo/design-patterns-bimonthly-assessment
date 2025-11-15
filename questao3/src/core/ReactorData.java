package core;

public class ReactorData {

    private double temperatura;
    private double pressao;
    private double radiacao;
    private boolean sistemaResfriamentoOk;

    private long tempoAlertaAmareloMs;

    public ReactorData() {
        this.sistemaResfriamentoOk = true;
    }

    public double getTemperatura() { return temperatura; }
    public double getPressao() { return pressao; }
    public double getRadiacao() { return radiacao; }
    public boolean isSistemaResfriamentoOk() { return sistemaResfriamentoOk; }
    public long getTempoAlertaAmareloMs() { return tempoAlertaAmareloMs; }

    public void setTemperatura(double temperatura) { this.temperatura = temperatura; }
    public void setPressao(double pressao) { this.pressao = pressao; }
    public void setRadiacao(double radiacao) { this.radiacao = radiacao; }
    public void setSistemaResfriamentoOk(boolean sistemaResfriamentoOk) { this.sistemaResfriamentoOk = sistemaResfriamentoOk; }
    public void setTempoAlertaAmareloMs(long tiempoMs) { this.tempoAlertaAmareloMs = tiempoMs; }
}
