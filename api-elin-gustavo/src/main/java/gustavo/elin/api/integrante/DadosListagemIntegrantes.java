package gustavo.elin.api.integrante;

import gustavo.elin.api.model.Integrante;

public record DadosListagemIntegrantes(Long id, String Franquia, String Nome, String Funcao, String Composicao) {
    public DadosListagemIntegrantes (Integrante integrante){
        this(integrante.getId(), integrante.getFranquia(), integrante.getNome(), integrante.getFuncao(), integrante.getComposicao());
    }
}
