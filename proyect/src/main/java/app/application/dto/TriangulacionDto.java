
package app.application.dto;


public class TriangulacionDto {

    private Posicion posiblePosicionMuzan;
    private double nivelConfianza;
    private String descripcion;

    
    public TriangulacionDto(Posicion posiblePosicionMuzan, double nivelConfianza, String descripcion) {
        this.posiblePosicionMuzan = posiblePosicionMuzan;
        this.nivelConfianza = nivelConfianza;
        this.descripcion = descripcion;
    }

    
    public Posicion getPosiblePosicionMuzan() {
        return posiblePosicionMuzan;
    }

    public void setPosiblePosicionMuzan(Posicion posiblePosicionMuzan) {
        this.posiblePosicionMuzan = posiblePosicionMuzan;
    }

    public double getNivelConfianza() {
        return nivelConfianza;
    }

    public void setNivelConfianza(double nivelConfianza) {
        this.nivelConfianza = nivelConfianza;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Clase interna para representar coordenadas
    public static class Posicion {
        private int x;
        private int y;

        public Posicion(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() { return x; }
        public void setX(int x) { this.x = x; }

        public int getY() { return y; }
        public void setY(int y) { this.y = y; }
    }
}
