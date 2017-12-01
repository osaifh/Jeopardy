package Model;

import java.util.HashMap;
import jeopardy.InputFicheros;

public class Juego {
    private Jugador[] jugadores;
    private int contadorTurnos, numeroPreguntas;
    private HashMap <String, HashMap <Integer,Pregunta>> preguntas;
    private boolean rondaDoble, running;
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
        numeroPreguntas = CATEGORIAS.length * PUNTUACIONES.length;
    }
    
    /**
     * Obten el jugador al que le toca
     * @return el jugador actual
     */
    public Jugador getJugadorActual(){
        return(jugadores[contadorTurnos%2]);
    }
    
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
    public boolean isRunning(){
        return running;
    }
    
    /**
     * Procesa una pregunta respondida por un usuario, añadiendo o restando puntos dependiendo de si la respuesta es correcta
     * @param pregunta la pregunta respondida
     * @param respuestaUsuario la respuesta del usuario
     */
    public boolean preguntaRespondida(Pregunta pregunta, int respuestaUsuario){
        int puntos = pregunta.getValorRespuesta();
        if (rondaDoble) puntos *= 2;
        if (!(pregunta.getRespuestaCorrecta()==respuestaUsuario)){
            puntos = -puntos;
        }
        jugadores[contadorTurnos%2].sumarPuntos(puntos);
        if (contadorTurnos == numeroPreguntas){
            running = false;
            System.out.println("Aqui acaba el juego");
        }
        ++contadorTurnos;
        rondaDoble = (contadorTurnos%19==0 || contadorTurnos%20==0);
        System.out.println("Jugador " + jugadores[0].getNombreJugador() + " puntos:" + jugadores[0].getPuntos());
        System.out.println("Jugador " + jugadores[1].getNombreJugador() + " puntos:" + jugadores[1].getPuntos());
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
        if (jugadores[0].getPuntos()>jugadores[1].getPuntos()) return jugadores[0];
        return jugadores[1];
    }
}
