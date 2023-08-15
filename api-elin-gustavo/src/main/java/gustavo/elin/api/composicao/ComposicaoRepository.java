package gustavo.elin.api.composicao;

import gustavo.elin.api.model.ComposicaoTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComposicaoRepository extends JpaRepository<ComposicaoTime, Long> {
}
