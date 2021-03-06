package Model;

import java.util.HashMap;
import jeopardy.InputFicheros;

public class Juego {
    private Jugador[] jugadores;
    private int contadorTurnos, numeroPreguntas;
    private HashMap <String, HashMap <Integer,Pregunta>> preguntas;
    private boolean rondaDoble, running, finalRound;
    private int indexGanadorFinalRound;
    public final static int[] PUNTUACIONES = {100, 200, 300, 400, 500};
    public final static String[] CATEGORIAS =
    {
        "Arte",
        "Ciencia",
        "Deporte",
        "Entretenimiento",
        "Geografia",
        "Literatura",
        "FinalRound"
    };
    
    
    /**
     * Constructor generico para juego
     * @param jugadores los jugadores para el juego
     */
    public Juego(Jugador[] jugadores){
        this.jugadores = jugadores;
        finalRound = false;
        running = true;
        preguntas = InputFicheros.leerPreguntas(CATEGORIAS);
        numeroPreguntas = (CATEGORIAS.length-1) * PUNTUACIONES.length;
    }
    
    /**
     * Obten el jugador al que le toca
     * @return el jugador actual
     */
    public Jugador getJugadorActual(){
        return(jugadores[contadorTurnos%2]);
    }
    
    /**
     * Retorna los jugadores
     * @return el array con los jugadores
     */
    public Jugador[] getJugadores(){
        return jugadores;
    }
    
    /**
     * Retorna el contador de turnos
     * @return el contador de turnos
     */
    public int getContadorTurnos(){
        return contadorTurnos;
    }
    
    /**
     * esta funcion se usa de manera temporal mientras aun estamos usando un arraylist para almacenar los datos
     * @param categoria
     * @param puntuacion
     * @return retorna la preg
     */
    public Pregunta getPregunta(String categoria, int puntuacion){
        return preguntas.get(categoria).get(puntuacion);
    }
    
    /**
     * retorna una pregunta con las coordenadas x, y
     * @param x categoria
     * @param y puntuacion
     * @return  la pregunta correspondiente
     */
    public Pregunta getPregunta(int x, int y){
        return preguntas.get(CATEGORIAS[x]).get(PUNTUACIONES[y]);
    }
    
    /**
     * Retorna true si el juego no se ha acabado
     * @return retorna true si el juego no se ha acabado
     */
    public boolean isRunning(){
        return running;
    }
    
    /**
     * Procesa una pregunta respondida por un usuario, añadiendo o restando puntos dependiendo de si la respuesta es correcta
     * @param pregunta la pregunta respondida
     * @param respuestaUsuario la respuesta del usuario
     * @return 
     */
    public boolean preguntaRespondida(Pregunta pregunta, int respuestaUsuario){
        if (!finalRound){
            int puntos = pregunta.getValorRespuesta();
            if (rondaDoble) puntos *= 2;
            if (!(pregunta.getRespuestaCorrecta()==respuestaUsuario)){
                puntos = -puntos;
            }
            jugadores[contadorTurnos%2].sumarPuntos(puntos);
            ++contadorTurnos;
            if (contadorTurnos == numeroPreguntas){
                running = false;
                finalRound = (jugadores[0].getPuntos() == jugadores[1].getPuntos());
            }
            rondaDoble = (contadorTurnos%19==0 || contadorTurnos%20==0);
        } else {
            if (!(pregunta.getRespuestaCorrecta()==respuestaUsuario)){
                finalRound = false;
                indexGanadorFinalRound = (contadorTurnos+1)%2;
            }
            else if (contadorTurnos >= preguntas.get("FinalRound").size()-1){
                finalRound = false;
            }
            ++contadorTurnos;
        }
        return (pregunta.getRespuestaCorrecta()==respuestaUsuario);
    }
    
    public boolean isRondaDoble(){
        return rondaDoble;
    }
    
    public String getStringPuntuacion(int i){
        if (rondaDoble){
            return ""+2*PUNTUACIONES[i];
        }
        return ""+PUNTUACIONES[i];
    }
    
    public Jugador getGanador(){
        if (indexGanadorFinalRound!=-1){
            return jugadores[indexGanadorFinalRound];
        }
        if (jugadores[0].getPuntos()>jugadores[1].getPuntos()) return jugadores[0];
        if (jugadores[1].getPuntos()>jugadores[0].getPuntos()) return jugadores[1];
        return null;
    }
    
    public void startFinalRound(){
        finalRound = true;
        contadorTurnos = 0;
        indexGanadorFinalRound = -1;
    }
    
    public boolean isFinalRound(){
        return  finalRound;
    }
    
    public void setGanadorFinalRound(int i){
        indexGanadorFinalRound = i;
    }
    
    public int getGanadorFinalRound(){
        return indexGanadorFinalRound;
    }
}
