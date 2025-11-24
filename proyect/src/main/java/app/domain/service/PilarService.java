package app.domain.service;

import app.application.dto.PilarDTO;
import app.application.dto.request.ActualizarPosicionRequest;
import app.application.dto.request.CrearPilarRequest;
import app.application.exceptions.NotFoundException;
import app.domain.model.Pilar;
import app.domain.repository.PilarRepository;
import app.infrastructure.persistence.jpa.PilarJpaRepository;

import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PilarService {

    private final PilarJpaRepository pilarRepository;

    public PilarService(PilarJpaRepository pilarRepository) {
        this.pilarRepository = pilarRepository;
    }

    
    public PilarDTO crearPilar(CrearPilarRequest request) {
    try {
        Pilar p = new Pilar();
        p.setNombre(request.getNombre());
        p.setPosX(request.getPosX().intValue());  
        p.setPosY(request.getPosY().intValue());  
        p.setEstado(request.getEstado());
        p.setUpdatedAt(Instant.now());

        Pilar guardado = pilarRepository.save(p);
        return mapToDTO(guardado);
    } catch (Exception e) {
        e.printStackTrace();  // <--- imprime la traza completa
        throw e;
    }
}


   
    public List<PilarDTO> obtenerTodos() {
        return pilarRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    
    public PilarDTO obtenerPilarPorId(Long id) {

        Pilar p = pilarRepository.findById(id);

        if (p == null) {
            throw new NotFoundException("Pilar no encontrado con id " + id);
        }

        return mapToDTO(p);
    }

    
    public PilarDTO actualizarPilar(Long id, ActualizarPosicionRequest request) {

        Pilar p = pilarRepository.findById(id);

        if (p == null) {
            throw new NotFoundException("Pilar no encontrado con id " + id);
        }

        p.setPosX(request.getPosX().intValue());  
        p.setPosY(request.getPosY().intValue());  
        p.setUpdatedAt(Instant.now());

        Pilar actualizado = pilarRepository.save(p);

        return mapToDTO(actualizado);
    }

    
    public void eliminarPilar(Long id) {
        Pilar p = pilarRepository.findById(id);
        if (p == null) {
            throw new NotFoundException("Pilar no encontrado con id " + id);
        }
        pilarRepository.deleteById(id);
    }

    // ----------------------------------------
    // Mapper: Pilar → PilarDTO
    // ----------------------------------------
    private PilarDTO mapToDTO(Pilar p) {
        PilarDTO dto = new PilarDTO();
        dto.setId(p.getId());
        dto.setNombre(p.getNombre());
        dto.setPosX(p.getPosX() != null ? p.getPosX().doubleValue() : null);
        dto.setPosY(p.getPosY() != null ? p.getPosY().doubleValue() : null);
        dto.setEstado(p.getEstado());
        dto.setUpdatedAt(p.getUpdatedAt());
        return dto;
    }
}
