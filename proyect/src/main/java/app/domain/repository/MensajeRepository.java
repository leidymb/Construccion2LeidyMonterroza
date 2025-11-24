
package app.domain.repository;

import app.infrastructure.persistence.entities.MensajeEntity;
import java.util.List;
import java.util.Optional;

public interface MensajeRepository {
    MensajeEntity save(MensajeEntity mensaje);

    Optional<MensajeEntity> findById(Long id);

    List<MensajeEntity> findAll();

    void deleteById(Long id);
    
    List<MensajeEntity> findByPilarId(Long pilarId);
}
