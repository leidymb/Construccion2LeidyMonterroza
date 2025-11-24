
package app.domain.port.in;

import app.domain.model.Pilar;
import app.application.dto.TriangulacionDto;
import java.util.List;


public interface PilarServicePort {
    Pilar getPilar(Long id);
    Pilar actualizarPosicion(Long id, Integer posX, Integer posY, String estado);
    List<Pilar> listarPilares();
    TriangulacionDto triangulacionEstimacion();
}
