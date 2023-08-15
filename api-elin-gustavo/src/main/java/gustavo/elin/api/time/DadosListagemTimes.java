package gustavo.elin.api.time;

import gustavo.elin.api.model.Time;

public record DadosListagemTimes(Long id, String Data) {
    public DadosListagemTimes (Time time){
        this(time.getId(), time.getData());
    }
}
