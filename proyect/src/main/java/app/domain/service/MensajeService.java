package app.domain.service;

import app.application.dto.MensajeDTO;
import app.application.dto.request.CrearMensajeRequest;
import app.application.dto.request.ReconstruirMensajeRequest;
import app.application.exceptions.NotFoundException;
import app.domain.model.Mensaje;
import app.infrastructure.persistence.entities.MensajeEntity;

import app.infrastructure.persistence.entities.PilarEntity;
import app.infrastructure.persistence.jpa.MensajeJpaRepository;
import app.infrastructure.persistence.jpa.PilarEntityJpa;

import app.infrastructure.persistence.mapper.MensajeMapper;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class MensajeService {

    private final MensajeJpaRepository mensajeRepository;
    private final PilarEntityJpa pilarRepository;

    public MensajeService(MensajeJpaRepository mensajeRepository,
                          PilarEntityJpa pilarRepository) {
        this.mensajeRepository = mensajeRepository;
        this.pilarRepository = pilarRepository;
    }

    public MensajeDTO crearMensaje(CrearMensajeRequest request) {

        
        PilarEntity pilar = pilarRepository.findById(request.getPilarId())
                .orElseThrow(() -> new NotFoundException("Pilar no encontrado con id " + request.getPilarId()));

        
        Mensaje domain = new Mensaje();
        domain.setPilarId(request.getPilarId());
        domain.setContenidoFragmentado(request.getContenidoFragmentado());
        domain.setContenidoReconstruido(request.getContenidoReconstruido());
        domain.setTimestamp(Instant.now());

        
        var entity = MensajeMapper.toEntity(domain, pilar);

        
        var saved = mensajeRepository.save(entity);

      
        Mensaje savedDomain = MensajeMapper.toDomain(saved);

        return toDTO(savedDomain);
    }

    
    public MensajeDTO obtenerMensajePorId(Long id) {

        var entity = mensajeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Mensaje no encontrado con id " + id));

        return toDTO(MensajeMapper.toDomain(entity));
    }

    
    public List<MensajeDTO> obtenerMensajes() {
        return mensajeRepository.findAll()
                .stream()
                .map(MensajeMapper::toDomain)
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
    
    public MensajeDTO reconstruirMensaje(Long id, ReconstruirMensajeRequest request) {
        
        MensajeEntity mensajeEntity = mensajeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Mensaje no encontrado con id " + id));

        
        mensajeEntity.setContenidoReconstruido(request.getContenidoReconstruido());
        mensajeEntity.setTimestamp(LocalDateTime.now());

        
        MensajeEntity actualizado = mensajeRepository.save(mensajeEntity);

        
        return mapToDTO(actualizado);
    }

    
    private MensajeDTO mapToDTO(MensajeEntity entity) {
        MensajeDTO dto = new MensajeDTO();
        dto.setId(entity.getId());
        dto.setContenidoFragmentado(entity.getContenidoFragmentado());
        dto.setContenidoReconstruido(entity.getContenidoReconstruido());
        dto.setTimestamp(entity.getTimestamp().atZone(ZoneId.systemDefault()).toInstant());
        dto.setPilarId(entity.getPilar().getId());
        return dto;
    }



    
    public List<MensajeDTO> obtenerMensajesPorPilar(Long pilarId) {

        if (!pilarRepository.existsById(pilarId)) {
            throw new NotFoundException("Pilar no encontrado con id " + pilarId);
        }

        return mensajeRepository.findByPilarId(pilarId)
                .stream()
                .map(MensajeMapper::toDomain)
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    
    public void eliminarMensaje(Long id) {

        var entity = mensajeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Mensaje no encontrado con id " + id));

        mensajeRepository.deleteById(id);
    }


    private MensajeDTO toDTO(Mensaje m) {

        MensajeDTO dto = new MensajeDTO();
        dto.setId(m.getId());
        dto.setPilarId(m.getPilarId());
        dto.setContenidoFragmentado(m.getContenidoFragmentado());
        dto.setContenidoReconstruido(m.getContenidoReconstruido());
        dto.setTimestamp(m.getTimestamp());

        return dto;
    }
}
