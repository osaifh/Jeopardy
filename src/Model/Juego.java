package Model;

import java.util.ArrayList;
import java.util.HashMap;
import jeopardy.InputFicheros;

/**
 *
 * @author Alumne
 */
public class Juego {
    private Jugador[] jugadores;
    private int contadorTurnos, numeroPreguntas, numeroPreguntasRespondidas;
    private HashMap <String, HashMap <Integer,Pregunta>> preguntas;

    private boolean running;
    public final static int[] PUNTUACIONES = {100, 200, 300, 400, 500};
    public final static String[] CATEGORIAS =
    {
        "Arte",
        "Ciencia",
        "Deporte",
        "Entretenimiento",
        "Geografia",
        "Literatura"
    };
    
    
    public Juego(Jugador[] jugadores){
        this.jugadores = jugadores;
        running = true;
        preguntas = InputFicheros.leerPreguntas(CATEGORIAS);
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
     * @param categoria
     * @param puntuacion
     * @return 
     */
    public Pregunta getPregunta(String categoria, int puntuacion){
        return preguntas.get(categoria).get(puntuacion);
    }
    
    public Pregunta getPregunta(int x, int y){
        return preguntas.get(CATEGORIAS[x]).get(PUNTUACIONES[y]);
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
        System.out.println("Jugador 1 " + jugadores[0].getPuntos());
        System.out.println("Jugador 2 " + jugadores[1].getPuntos());
    }
    
    
}
