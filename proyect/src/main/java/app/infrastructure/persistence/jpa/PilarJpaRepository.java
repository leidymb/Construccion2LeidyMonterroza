package app.infrastructure.persistence.jpa;

import app.domain.model.Pilar;
import app.domain.repository.PilarRepository;
import app.infrastructure.persistence.entities.PilarEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PilarJpaRepository implements PilarRepository {

    private final PilarEntityJpa jpa;

    public PilarJpaRepository(PilarEntityJpa jpa) {
        this.jpa = jpa;
    }

    @Override
    public Pilar save(Pilar p) {
        PilarEntity entity = PilarEntity.fromDomain(p);
        PilarEntity saved = jpa.save(entity);
        return saved.toDomain();
    }

    @Override
    public List<Pilar> findAll() {
        return jpa.findAll().stream()
                .map(PilarEntity::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Pilar findById(Long id) {
        return jpa.findById(id)
                .map(PilarEntity::toDomain)
                .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        jpa.deleteById(id);
    }
}
