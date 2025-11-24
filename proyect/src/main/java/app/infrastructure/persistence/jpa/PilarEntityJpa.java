
package app.infrastructure.persistence.jpa;

import app.infrastructure.persistence.entities.PilarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PilarEntityJpa extends JpaRepository<PilarEntity, Long> {
}

