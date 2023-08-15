package gustavo.elin.api.model;

import gustavo.elin.api.integrante.DadosIntegrante;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@EqualsAndHashCode(of = "id")
@Entity(name = "Integrante")
@Table(name = "integrante")
@Embeddable
@Getter
@AllArgsConstructor
public class Integrante{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column
    private String franquia;

    @NotNull
    @Column
    private String nome;

    @NotNull
    @Column
    private String funcao;

    @NotNull
    @Column
    private String composicao;


    public Integrante(DadosIntegrante dados) {
        this.id = dados.id();
        this.franquia = dados.Franquia();
        this.nome = dados.Nome();
        this.funcao = dados.Funcao();
        this.composicao = dados.Composicao();

    }

    public Integrante() {

    }

    public void atualizarInformacoes(DadosIntegrante dados) {
        if (dados.Franquia() != null) {
            this.franquia = dados.Franquia();
        }
        if (dados.Nome() != null) {
            this.nome = dados.Nome();
        }
        if (dados.Funcao() != null) {
            this.funcao = dados.Funcao();
        }
        if (dados.Composicao() != null) {
            this.composicao = dados.Composicao();
        }
    }
}



