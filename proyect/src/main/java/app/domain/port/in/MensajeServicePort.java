
package app.domain.port.in;

import app.domain.model.Mensaje;


public interface MensajeServicePort {
    Mensaje crearMensaje(Long pilarId, String contenidoFragmentado);
    Mensaje reconstruirMensaje(Long mensajeId, String contenidoReconstruido);
    Mensaje getMensaje(Long id);
}
