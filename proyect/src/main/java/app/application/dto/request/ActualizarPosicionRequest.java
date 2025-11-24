package app.application.dto.request;

import jakarta.validation.constraints.NotNull;

public class ActualizarPosicionRequest {

    @NotNull(message = "La posición X no puede ser nula")
    private Integer posX;

    @NotNull(message = "La posición Y no puede ser nula")
    private Integer posY;

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
}

