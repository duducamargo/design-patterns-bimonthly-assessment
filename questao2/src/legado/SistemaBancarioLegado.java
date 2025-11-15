package legado;

import java.util.HashMap;
import java.util.UUID;

public class SistemaBancarioLegado {

    public RespostaLegada processarTransacao(HashMap<String, Object> parametros) {

        if (!parametros.containsKey("canal")) {
            return new RespostaLegada(false, null, "Erro: campo obrigatório 'canal' não informado.");
        }

        System.out.println("[LEGADO] Processando com parâmetros: " + parametros);

        boolean aprovado = (double) parametros.get("valor") <= 5000.0;

        return new RespostaLegada(
                aprovado,
                aprovado ? UUID.randomUUID().toString().substring(0, 8) : null,
                aprovado ? "Transação aprovada." : "Transação recusada: valor acima do limite."
        );
    }
}
