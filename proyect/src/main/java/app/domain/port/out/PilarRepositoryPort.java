
package app.domain.port.out;

import app.domain.model.Pilar;
import java.util.List;


public interface PilarRepositoryPort {
    Pilar findById(Long id);
    Pilar save(Pilar pilar);
    List<Pilar> findAll();
}
