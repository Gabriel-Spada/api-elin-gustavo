package gustavo.elin.api.model;

import gustavo.elin.api.integrante.DadosIntegrante;
import gustavo.elin.api.time.DadosTime;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@EqualsAndHashCode(of = "id")
@Entity(name = "Time")
@Table(name = "time")
@Embeddable
@Getter
@AllArgsConstructor
public class Time {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column
    private String time;

    @Column
    private String data;

    public Time() {

    }

    public Time(DadosTime dados) {
        this.id = dados.id();
        this.time = dados.Time();
        this.data = dados.Data();

    }

    public void atualizarInformacoes(DadosTime dados) {
        if (dados.Time() != null) {
            this.time = dados.Time();
        }
        if (dados.Data() != null) {
            this.data = dados.Data();
        }

    }
}

