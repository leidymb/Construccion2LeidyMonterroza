
package app.domain.repository;

import app.domain.model.Pilar;
import java.util.List;


public interface PilarRepository {
    Pilar save(Pilar pilar);

    Pilar findById(Long id);

    List<Pilar> findAll();

    void deleteById(Long id);
}
