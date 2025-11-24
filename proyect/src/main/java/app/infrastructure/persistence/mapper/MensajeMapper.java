package app.infrastructure.persistence.mapper;

import app.domain.model.Mensaje;
import app.infrastructure.persistence.entities.MensajeEntity;
import app.infrastructure.persistence.entities.PilarEntity;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class MensajeMapper {

    private static final ZoneId DEFAULT_ZONE = ZoneId.systemDefault();

    
    public static Mensaje toDomain(MensajeEntity entity) {
        if (entity == null) return null;

        Mensaje mensaje = new Mensaje();
        mensaje.setId(entity.getId());
        mensaje.setContenidoFragmentado(entity.getContenidoFragmentado());
        mensaje.setContenidoReconstruido(entity.getContenidoReconstruido());

       
        if (entity.getTimestamp() != null) {
            mensaje.setTimestamp(entity.getTimestamp().atZone(DEFAULT_ZONE).toInstant());
        }

        
        if (entity.getPilar() != null) {
            mensaje.setPilarId(entity.getPilar().getId());
        }

        return mensaje;
    }

    
    public static MensajeEntity toEntity(Mensaje domain, PilarEntity pilar) {
        if (domain == null) return null;

        MensajeEntity entity = new MensajeEntity();

        entity.setContenidoFragmentado(domain.getContenidoFragmentado());
        entity.setContenidoReconstruido(domain.getContenidoReconstruido());

        
        if (domain.getTimestamp() != null) {
            entity.setTimestamp(
                LocalDateTime.ofInstant(domain.getTimestamp(), DEFAULT_ZONE)
            );
        }

        
        entity.setPilar(pilar);

        return entity;
    }
}
