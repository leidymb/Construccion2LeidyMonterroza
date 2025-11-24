package app.adapter.in.rest.controllers;




import app.application.dto.MensajeDTO;
import app.application.dto.request.CrearMensajeRequest;
import app.application.dto.request.ReconstruirMensajeRequest;
import app.domain.service.MensajeService;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mensajes")
public class MensajeController {

    private final MensajeService mensajeService;

    public MensajeController(MensajeService mensajeService) {
        this.mensajeService = mensajeService;
    }

    
    @PostMapping
    public ResponseEntity<MensajeDTO> crearMensaje(@Valid @RequestBody CrearMensajeRequest request) {
        MensajeDTO dto = mensajeService.crearMensaje(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

   
    @GetMapping("/pilar/{pilarId}")
    public ResponseEntity<List<MensajeDTO>> obtenerMensajesPorPilar(@PathVariable Long pilarId) {
        List<MensajeDTO> mensajes = mensajeService.obtenerMensajesPorPilar(pilarId);
        return ResponseEntity.ok(mensajes);
    }

    // ----------------------------------------
    // Obtener mensaje por ID
    // ----------------------------------------
    @GetMapping("/{id}")
    public ResponseEntity<MensajeDTO> obtenerMensaje(@PathVariable Long id) {
        MensajeDTO mensaje = mensajeService.obtenerMensajePorId(id);
        return ResponseEntity.ok(mensaje);
    }
    
    @PutMapping("/{id}/reconstruir")
    public ResponseEntity<MensajeDTO> reconstruirMensaje(
            @PathVariable Long id,
            @Valid @RequestBody ReconstruirMensajeRequest request) {

        MensajeDTO actualizado = mensajeService.reconstruirMensaje(id, request);
        return ResponseEntity.ok(actualizado);
    }

    // ----------------------------------------
    // Eliminar mensaje
    // ----------------------------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMensaje(@PathVariable Long id) {
        mensajeService.eliminarMensaje(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

