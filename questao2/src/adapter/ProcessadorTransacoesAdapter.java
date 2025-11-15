package adapter;

import moderno.ProcessadorTransacoes;
import moderno.RespostaTransacao;
import legado.SistemaBancarioLegado;
import legado.RespostaLegada;

import java.util.HashMap;

public class ProcessadorTransacoesAdapter implements ProcessadorTransacoes {

    private final SistemaBancarioLegado legado;

    public ProcessadorTransacoesAdapter(SistemaBancarioLegado legado) {
        this.legado = legado;
    }

    @Override
    public RespostaTransacao autorizar(String cartao, double valor, String moeda) {

        HashMap<String, Object> parametros = new HashMap<>();

        parametros.put("cartao", cartao);
        parametros.put("valor", valor);
        parametros.put("moeda", converterMoeda(moeda));

        parametros.put("canal", "E-COMMERCE");

        RespostaLegada respostaLegada = legado.processarTransacao(parametros);

        return converterResposta(respostaLegada);
    }

    private RespostaTransacao converterResposta(RespostaLegada resposta) {
        return new RespostaTransacao(
                resposta.isSucesso(),
                resposta.getCodigo(),
                resposta.getMensagem()
        );
    }

    private int converterMoeda(String moeda) {
        return switch (moeda.toUpperCase()) {
            case "USD" -> 1;
            case "EUR" -> 2;
            case "BRL" -> 3;
            default -> 0;
        };
    }
}
