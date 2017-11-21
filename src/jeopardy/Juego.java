package jeopardy;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Alumne
 */
public class Juego {
    private Jugador[] jugadores;
    private int contadorTurnos, numeroPreguntas, numeroPreguntasRespondidas;
    //private HashMap <String, HashMap <Integer,Pregunta>> preguntas;
    private ArrayList<Pregunta> preguntas;
    private boolean running;
    
    public Juego(Jugador[] jugadores, ArrayList<Pregunta> preguntas){
        this.jugadores = jugadores;
        this.preguntas = preguntas;
        running = true;
    }
    
    /**
     * Obten el jugador al que le toca
     * @return el jugador actual
     */
    public Jugador getJugadorActual(){
        return(jugadores[contadorTurnos%2]);
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
     * @param indice el indice de la pregunta
     * @return 
     */
    public Pregunta getPregunta(int indice){
        return preguntas.get(indice);
    }
    
    /**
     * Retorna true si el juego no se ha acabado
     * @return retorna true si el juego no se ha acabado
     */
    public boolean getRunning(){
        return running;
    }
    
    /**
     * Procesa una pregunta respondida por un usuario, añadiendo o restando puntos dependiendo de si la respuesta es correcta
     * @param pregunta la pregunta respondida
     * @param respuestaUsuario la respuesta del usuario
     */
    public void preguntaRespondida(Pregunta pregunta, int respuestaUsuario){
        if (pregunta.getRespuestaCorrecta()==respuestaUsuario){
            //respuesta correcta
            jugadores[contadorTurnos%2].sumarPuntos(pregunta.getValorRespuesta());
        }
        else {
            //respuesta incorrecta
            jugadores[contadorTurnos%2].sumarPuntos(-pregunta.getValorRespuesta());
        }
        ++numeroPreguntasRespondidas;
        if (numeroPreguntasRespondidas == numeroPreguntas){
            running = false;
        }
        ++contadorTurnos;
    }
    
    
}
