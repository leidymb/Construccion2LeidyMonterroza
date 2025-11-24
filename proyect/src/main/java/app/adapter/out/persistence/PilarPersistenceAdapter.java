package app.adapter.out.persistence;

import app.domain.model.Pilar;
import app.domain.port.out.PilarRepositoryPort;
import app.infrastructure.persistence.entities.PilarEntity;
import app.infrastructure.persistence.jpa.PilarEntityJpa;
import app.infrastructure.persistence.jpa.PilarJpaRepository;
import app.infrastructure.persistence.mapper.PilarMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PilarPersistenceAdapter implements PilarRepositoryPort {

    private final PilarEntityJpa repo;

    public PilarPersistenceAdapter(PilarEntityJpa repo) {
        this.repo = repo;
    }

    // ------------------------------------------------------
    // Buscar por ID (sin Optional)
    // ------------------------------------------------------
    @Override
    public Pilar findById(Long id) {
        PilarEntity entity = repo.findById(id).orElse(null);
        return PilarMapper.toDomain(entity);
    }

    // ------------------------------------------------------
    // Guardar / actualizar
    // ------------------------------------------------------
    @Override
    public Pilar save(Pilar pilar) {
        PilarEntity entity = PilarMapper.toEntity(pilar);
        PilarEntity saved = repo.save(entity);
        return PilarMapper.toDomain(saved);
    }

    // ------------------------------------------------------
    // Listar todos
    // ------------------------------------------------------
    @Override
    public List<Pilar> findAll() {
        return repo.findAll()
                .stream()
                .map(PilarMapper::toDomain)
                .toList();
    }
}
