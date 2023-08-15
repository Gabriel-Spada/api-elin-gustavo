package gustavo.elin.api.composicao;

import gustavo.elin.api.model.ComposicaoTime;

public record DadosListagemComposicao(Long id, String time, String integrante) {
    public DadosListagemComposicao (ComposicaoTime composicao){
        this(composicao.getId(), composicao.getTime(), composicao.getIntegrante());
    }
}
