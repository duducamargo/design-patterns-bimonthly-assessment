package moderno;

public class RespostaTransacao {

    private boolean sucesso;
    private String codigoAutorizacao;
    private String mensagem;

    public RespostaTransacao(boolean sucesso, String codigoAutorizacao, String mensagem) {
        this.sucesso = sucesso;
        this.codigoAutorizacao = codigoAutorizacao;
        this.mensagem = mensagem;
    }

    public boolean isSucesso() { return sucesso; }
    public String getCodigoAutorizacao() { return codigoAutorizacao; }
    public String getMensagem() { return mensagem; }

    @Override
    public String toString() {
        return "RespostaTransacao{" +
                "sucesso=" + sucesso +
                ", codigoAutorizacao='" + codigoAutorizacao + '\'' +
                ", mensagem='" + mensagem + '\'' +
                '}';
    }
}
