package app.application.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CrearMensajeRequest {

    @NotNull(message = "El ID del pilar es obligatorio")
    private Long pilarId;

    @Size(max = 500, message = "El contenido fragmentado no debe superar 500 caracteres")
    private String contenidoFragmentado;

    @Size(max = 1000, message = "El contenido reconstruido no debe superar los 1000 caracteres")
    private String contenidoReconstruido;

    public Long getPilarId() {
        return pilarId;
    }

    public void setPilarId(Long pilarId) {
        this.pilarId = pilarId;
    }

    public String getContenidoFragmentado() {
        return contenidoFragmentado;
    }

    public void setContenidoFragmentado(String contenidoFragmentado) {
        this.contenidoFragmentado = contenidoFragmentado;
    }

    public String getContenidoReconstruido() {
        return contenidoReconstruido;
    }

    public void setContenidoReconstruido(String contenidoReconstruido) {
        this.contenidoReconstruido = contenidoReconstruido;
    }
}
