
package Model;

public class Jugador {
   protected String nombreJugador;
    protected int puntos;

    public  Jugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }


    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
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
    
    public void restarPuntos(int valorPregunta){
        int puntosActuales;
        puntosActuales = getPuntos() -  valorPregunta;
    }
    
}
