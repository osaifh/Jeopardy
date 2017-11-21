
package Model;

public class Jugador {
    protected String nombreJugador;
    protected int puntos;

    public Jugador() {
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void sumarPuntos(int puntos){
        this.puntos += puntos;
    }
}
