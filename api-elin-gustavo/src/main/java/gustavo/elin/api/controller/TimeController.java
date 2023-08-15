package gustavo.elin.api.controller;

import gustavo.elin.api.integrante.DadosIntegrante;
import gustavo.elin.api.model.Time;
import gustavo.elin.api.time.DadosListagemTimes;
import gustavo.elin.api.time.DadosTime;
import gustavo.elin.api.time.TimeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("time")
public class TimeController {

    @Autowired
    private TimeRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosTime dados) {
        repository.save(new Time(dados));
    }

    @GetMapping
    public List<DadosListagemTimes> listar() {
        return repository.findAll().stream().map(DadosListagemTimes::new).toList();
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosTime dados) {
        var time = repository.getReferenceById(dados.id());
        time.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
