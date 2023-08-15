package gustavo.elin.api.controller;

import gustavo.elin.api.composicao.DadosComposicao;
import gustavo.elin.api.integrante.DadosIntegrante;
import gustavo.elin.api.integrante.DadosListagemIntegrantes;
import gustavo.elin.api.integrante.IntegranteRepository;
import gustavo.elin.api.model.Integrante;
import gustavo.elin.api.time.DadosListagemTimes;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("integrante")
public class IntegranteController {

    @Autowired
    private IntegranteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosIntegrante dados) {
        repository.save(new Integrante(dados));
    }

    @GetMapping
    public List<DadosListagemIntegrantes> listar() {
        return repository.findAll().stream().map(DadosListagemIntegrantes::new).toList();
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosIntegrante dados) {
        var integrante = repository.getReferenceById(dados.id());
        integrante.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
