package app.infrastructure.persistence.mapper;

import app.domain.model.Pilar;
import app.infrastructure.persistence.entities.PilarEntity;

public class PilarMapper {

    // -------------------------
    // De Entity → Domain
    // -------------------------
    public static Pilar toDomain(PilarEntity entity) {
        if (entity == null) return null;

        Pilar pilar = new Pilar();
        pilar.setId(entity.getId());
        pilar.setNombre(entity.getNombre());
        pilar.setPosX(entity.getPosX());
        pilar.setPosY(entity.getPosY());
        pilar.setEstado(entity.getEstado());
        pilar.setUpdatedAt(entity.getUpdatedAt());

        return pilar;
    }

    
    public static PilarEntity toEntity(Pilar model) {
        if (model == null) return null;

        PilarEntity entity = new PilarEntity();
        entity.setId(model.getId());
        entity.setNombre(model.getNombre());
        entity.setPosX(model.getPosX());
        entity.setPosY(model.getPosY());
        entity.setEstado(model.getEstado());
        entity.setUpdatedAt(model.getUpdatedAt());

        return entity;
    }
}
