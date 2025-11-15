package legado;

public class RespostaLegada {

    private boolean sucesso;
    private String codigo;
    private String mensagem;

    public RespostaLegada(boolean sucesso, String codigo, String mensagem) {
        this.sucesso = sucesso;
        this.codigo = codigo;
        this.mensagem = mensagem;
    }

    public boolean isSucesso() { return sucesso; }
    public String getCodigo() { return codigo; }
    public String getMensagem() { return mensagem; }

    @Override
    public String toString() {
        return "RespostaLegada{" +
                "sucesso=" + sucesso +
                ", codigo='" + codigo + '\'' +
                ", mensagem='" + mensagem + '\'' +
                '}';
    }
}
