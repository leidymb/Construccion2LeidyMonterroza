package app.application.dto.request;

import jakarta.validation.constraints.NotBlank;

public class ReconstruirMensajeRequest {

    @NotBlank(message = "El contenido reconstruido es obligatorio")
    private String contenidoReconstruido;

    public String getContenidoReconstruido() {
        return contenidoReconstruido;
    }

    public void setContenidoReconstruido(String contenidoReconstruido) {
        this.contenidoReconstruido = contenidoReconstruido;
    }
}
