
package Model;

public class Jugador {
    private String nombreJugador;
        private int puntos, respuestasCorrectas, respuestasErroneas;
    
    public Jugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public  String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public int getPuntos() {
        return puntos;
    }

    public int getRespuestasCorrectas(){
        return respuestasCorrectas;
    }
    
    public int getRespuestasErroneas(){
        return respuestasErroneas;
    }
    
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void sumarPuntos(int puntos) {
        if (puntos > 0) ++respuestasCorrectas;
        else ++respuestasErroneas;
        this.puntos += puntos;
        if (this.puntos < 0) this.puntos = 0;
    }

}
