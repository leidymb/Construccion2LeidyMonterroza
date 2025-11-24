
package app.domain.model;

import java.time.Instant;


public class Mensaje {
    private Long id;
    private Long pilarId;
    private String contenidoFragmentado;
    private String contenidoReconstruido;
    private Instant timestamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }
    
    
}
