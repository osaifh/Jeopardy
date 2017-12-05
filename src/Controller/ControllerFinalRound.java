package Controller;

import Model.Juego;
import Model.Pregunta;
import Views.ViewFinalRound;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ControllerFinalRound implements ActionListener, IControllerPrincipal {
    private ViewFinalRound vista;
    private Juego juego;
    private boolean ocupado;
    
    public ControllerFinalRound(Juego juego){
        this.juego = juego;
        vista = new ViewFinalRound();
        ocupado = false;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!ocupado){
            Pregunta pregunta = juego.getPregunta("FinalRound", juego.getContadorTurnos());
            ControllerPreguntas contPreg = new ControllerPreguntas(pregunta,this,juego);
            
            ocupado = true;
        }
        else {
            vista.muestraError("Aun no se ha respondido la pregunta");
        }
    }
    
    public void finDeTurno(){
        ocupado = false;
    }
}
