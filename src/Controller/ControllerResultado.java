package Controller;

import Model.Juego;
import Views.ViewResultado;

public class ControllerResultado {
    private Juego juego;
    private ViewResultado vistaResultado;
    
    public ControllerResultado(Juego juego){
        this.juego = juego;
        vistaResultado = new ViewResultado(juego.getGanador().getNombreJugador());
    }
}
