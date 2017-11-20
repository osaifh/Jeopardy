
package Model;

public class Jugador {
   protected String nombreJugador;
    protected int puntos;

    public Jugador() {
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
    
    public void sumarPuntos(){
        int sumaPuntos = 0;
        sumaPuntos=sumaPuntos + getPuntos();
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
}
