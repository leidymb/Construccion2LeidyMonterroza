package app.adapter.in.rest.controllers;

import app.application.dto.PilarDTO;
import app.application.dto.request.ActualizarPosicionRequest;
import app.application.dto.request.CrearPilarRequest;
import app.domain.service.PilarService;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pilares")
public class PilarController {

    private final PilarService pilarService;

    public PilarController(PilarService pilarService) {
        this.pilarService = pilarService;
    }

    @PostMapping
    public ResponseEntity<PilarDTO> crearPilar(@Valid @RequestBody CrearPilarRequest request) {
        PilarDTO creado = pilarService.crearPilar(request);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PilarDTO>> listarPilares() {
        return new ResponseEntity<>(pilarService.obtenerTodos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PilarDTO> obtenerPilar(@PathVariable Long id) {
        return new ResponseEntity<>(pilarService.obtenerPilarPorId(id), HttpStatus.OK);
    }

    @PutMapping("/{id}/posicion")
    public ResponseEntity<PilarDTO> actualizarPosicion(
            @PathVariable Long id,
            @Valid @RequestBody ActualizarPosicionRequest request) {

        PilarDTO actualizado = pilarService.actualizarPilar(id, request);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPilar(@PathVariable Long id) {
        pilarService.eliminarPilar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
