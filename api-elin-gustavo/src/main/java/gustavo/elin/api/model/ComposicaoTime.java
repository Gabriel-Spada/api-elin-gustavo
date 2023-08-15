package gustavo.elin.api.model;

import gustavo.elin.api.composicao.DadosComposicao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;


@Entity
@Table(name = "composicao")
@Embeddable
@Getter
@AllArgsConstructor
public class ComposicaoTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column
    private String time;

    @NotNull
    @Column
    private String integrante;

    public ComposicaoTime() {
    }

    public ComposicaoTime(DadosComposicao dados) {
        this.id = dados.id();
        this.time = dados.Time();
        this.integrante = dados.Integrante();
    }


    public void atualizarInformacoes(DadosComposicao dados) {
        if (dados.Time() != null) {
            this.time = dados.Time();
        }
        if (dados.Integrante() != null) {
            this.integrante = dados.Integrante();
        }

    }
}

