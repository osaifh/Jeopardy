package Controller;

import Model.Juego;
import Model.Pregunta;
import Views.ViewFinalRound;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

public class ControllerFinalRound implements ActionListener, IControllerPrincipal {
    private ViewFinalRound vista;
    private Juego juego;
    private boolean ocupado;
    
    public ControllerFinalRound(Juego juego){
        this.juego = juego;
        juego.startFinalRound();
        vista = new ViewFinalRound();
        ocupado = false;
        setLabels();
    }
    
    private void setLabels(){
        vista.getPanelJugadores()[0].setBackground(java.awt.Color.cyan);
        vista.getPanelJugadores()[1].setBackground(java.awt.Color.white);
        ((JLabel)vista.getPanelJugadores()[0].getComponent(0)).setText(juego.getJugadores()[0].getNombreJugador());
        ((JLabel)vista.getPanelJugadores()[1].getComponent(0)).setText(juego.getJugadores()[1].getNombreJugador());
        vista.getBoton().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!ocupado){
            Pregunta pregunta = juego.getPregunta("FinalRound", juego.getContadorTurnos());
            ControllerPreguntas contPreg = new ControllerPreguntas(pregunta,this,juego);
            vista.getBoton().setEnabled(false);
            ocupado = true;
        }
        else {
            vista.muestraError("Aun no se ha respondido la pregunta");
        }
    }
    
    public void finDeTurno(){
        ocupado = false;
        vista.getPanelJugadores()[juego.getContadorTurnos()%2].setBackground(java.awt.Color.cyan);
        vista.getPanelJugadores()[(juego.getContadorTurnos()+1)%2].setBackground(java.awt.Color.white);
        if (!juego.isFinalRound()) finDelJuego();
        else {
            vista.getBoton().setEnabled(true);
        }
    }
    
    public void finDelJuego(){
        ControllerResultado controladorResultado = new ControllerResultado(juego);
        vista.dispose();
    }
}
