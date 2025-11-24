package app.infrastructure.persistence.entities;

import app.domain.model.Pilar;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "pilares")
public class PilarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(name = "pos_x")
    private Integer posX;

    @Column(name = "pos_y")
    private Integer posY;

    private String estado;

    @Column(name = "updated_at")
    private Instant updatedAt;

    // ----------------------------------------
    // CONSTRUCTORES
    // ----------------------------------------
    public PilarEntity() {
    }

    public PilarEntity(Long id, String nombre, Integer posX, Integer posY, String estado, Instant updatedAt) {
        this.id = id;
        this.nombre = nombre;
        this.posX = posX;
        this.posY = posY;
        this.estado = estado;
        this.updatedAt = updatedAt;
    }

    // ----------------------------------------
    // MÉTODOS DE CONVERSIÓN A DOMINIO
    // ----------------------------------------
    public static PilarEntity fromDomain(Pilar p) {
        PilarEntity e = new PilarEntity();
        e.setId(p.getId());
        e.setNombre(p.getNombre());
        e.setPosX(p.getPosX());
        e.setPosY(p.getPosY());
        e.setEstado(p.getEstado());
        e.setUpdatedAt(p.getUpdatedAt());
        return e;
    }

    public Pilar toDomain() {
        Pilar p = new Pilar();
        p.setId(this.getId());
        p.setNombre(this.getNombre());
        p.setPosX(this.getPosX());
        p.setPosY(this.getPosY());
        p.setEstado(this.getEstado());
        p.setUpdatedAt(this.getUpdatedAt());
        return p;
    }


    // ----------------------------------------
    // GETTERS Y SETTERS
    // ----------------------------------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPosX() {
        return posX;
    }

    public void setPosX(Integer posX) {
        this.posX = posX;
    }

    public Integer getPosY() {
        return posY;
    }

    public void setPosY(Integer posY) {
        this.posY = posY;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}
