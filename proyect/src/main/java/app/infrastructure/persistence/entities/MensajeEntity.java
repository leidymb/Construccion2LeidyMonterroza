package app.infrastructure.persistence.entities;


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "mensajes")
public class MensajeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500)
    private String contenidoFragmentado;

    @Column(length = 500)
    private String contenidoReconstruido;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "pilar_id", nullable = false)
    private PilarEntity pilar;

    public MensajeEntity() {}

    public Long getId() {
        return id;
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

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public PilarEntity getPilar() {
        return pilar;
    }

    public void setPilar(PilarEntity pilar) {
        this.pilar = pilar;
    }
}
