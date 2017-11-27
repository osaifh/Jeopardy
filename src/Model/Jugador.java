
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
<<<<<<< HEAD
    
    public void sumarPuntos(int puntos){
        this.puntos += puntos;
    }
    
    public void restarPuntos(int valorPregunta){
        int puntosActuales;
        puntosActuales = getPuntos() -  valorPregunta;
    }
    ///metodo vcm
      /*public void cambiarPuntuaciobn(int puntos) {
        if (this.turno == 15) {
            puntos = puntos * 2;
        }
        this.puntuacion = puntuacion + puntos;
    }*/
=======

    public void sumarPuntos(int puntos){
        this.puntos += puntos;
    }
>>>>>>> 9488f1c8d80bfdf8695d724f7154467dcd9c18d1
}
