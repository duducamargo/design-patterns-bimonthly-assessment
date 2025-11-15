package moderno;

public interface ProcessadorTransacoes {

    RespostaTransacao autorizar(String cartao, double valor, String moeda);
}
