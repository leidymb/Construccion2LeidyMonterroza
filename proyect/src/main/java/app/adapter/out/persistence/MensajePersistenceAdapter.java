package app.adapter.out.persistence;

import app.domain.model.Mensaje;
import app.domain.port.out.MensajeRepositoryPort;
import app.infrastructure.persistence.entities.MensajeEntity;
import app.infrastructure.persistence.entities.PilarEntity;
import app.infrastructure.persistence.mapper.MensajeMapper;
import app.infrastructure.persistence.jpa.MensajeJpaRepository;
import app.infrastructure.persistence.jpa.PilarEntityJpa;
import app.infrastructure.persistence.jpa.PilarJpaRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class MensajePersistenceAdapter implements MensajeRepositoryPort {

    private final MensajeJpaRepository mensajeJpaRepository;
    private final PilarEntityJpa pilarJpaRepository;

    public MensajePersistenceAdapter(
            MensajeJpaRepository mensajeJpaRepository,
            PilarEntityJpa pilarJpaRepository
    ) {
        this.mensajeJpaRepository = mensajeJpaRepository;
        this.pilarJpaRepository = pilarJpaRepository;
    }

    @Override
    public Mensaje save(Mensaje mensaje) {

        // Buscar el Pilar asociado (sin Optional)
        PilarEntity pilar = pilarJpaRepository.findById(mensaje.getPilarId())
                .orElseThrow(() -> new RuntimeException(
                        "No se encontró el Pilar con id " + mensaje.getPilarId()
                ));

        // Convertir dominio → entidad
        MensajeEntity entity = MensajeMapper.toEntity(mensaje, pilar);

        // Guardar en BD
        MensajeEntity saved = mensajeJpaRepository.save(entity);

        // Convertir entidad → dominio
        return MensajeMapper.toDomain(saved);
    }

    @Override
    public Mensaje findById(Long id) {
        MensajeEntity entity = mensajeJpaRepository.findById(id)
                .orElse(null);

        return MensajeMapper.toDomain(entity);
    }
    
    @Override
    public List<Mensaje> findByPilarId(Long pilarId) {

        List<MensajeEntity> entities = mensajeJpaRepository.findByPilarId(pilarId);

        return entities.stream()
                .map(MensajeMapper::toDomain)
                .collect(Collectors.toList());
    }
}
