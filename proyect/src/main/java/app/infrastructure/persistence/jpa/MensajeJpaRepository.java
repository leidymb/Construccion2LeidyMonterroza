
package app.infrastructure.persistence.jpa;

import app.infrastructure.persistence.entities.MensajeEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensajeJpaRepository extends JpaRepository<MensajeEntity, Long> { 
    List<MensajeEntity> findByPilarId(Long pilarId); 
}
