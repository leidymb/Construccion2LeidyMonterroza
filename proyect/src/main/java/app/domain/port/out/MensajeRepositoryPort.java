
package app.domain.port.out;

import app.domain.model.Mensaje;
import java.util.List;
import java.util.Optional;

public interface MensajeRepositoryPort {
    Mensaje save(Mensaje m);
    Mensaje findById(Long id);
    List<Mensaje> findByPilarId(Long pilarId);
}
