package gustavo.elin.api.controller;

import gustavo.elin.api.composicao.ComposicaoRepository;
import gustavo.elin.api.composicao.DadosComposicao;
import gustavo.elin.api.composicao.DadosListagemComposicao;
import gustavo.elin.api.integrante.DadosIntegrante;
import gustavo.elin.api.integrante.DadosListagemIntegrantes;
import gustavo.elin.api.integrante.IntegranteRepository;
import gustavo.elin.api.model.ComposicaoTime;
import gustavo.elin.api.model.Integrante;
import gustavo.elin.api.time.DadosTime;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("composicao")
public class ComposicaoTimeController {

    @Autowired
    private ComposicaoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosComposicao dados) {

        repository.save(new ComposicaoTime(dados));
    }

    @GetMapping
    public List<DadosListagemComposicao> listar() {
        return repository.findAll().stream().map(DadosListagemComposicao::new).toList();
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosComposicao dados) {
        var composicao = repository.getReferenceById(dados.id());
        composicao.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
