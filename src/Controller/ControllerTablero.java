package Controller;

import Model.Juego;
import Model.Pregunta;
import Views.ViewTablero;
import java.awt.event.*;
import javax.swing.JButton;

public class ControllerTablero implements ActionListener {
private ViewTablero vistaTablero;
private ControllerPreguntas controllerPreguntas;
private JButton[][] botones;
private Juego juego;
private boolean ocupado;

    public ControllerTablero(Juego juego, ViewTablero vistaTablero) {
        this.juego = juego;
        this.vistaTablero = vistaTablero;
        botones = vistaTablero.getBotones();
        ocupado = false;
        for (int i = 0; i < botones.length; i++){
            for (int j = 0; j < botones[i].length; j++){
                botones[i][j].addActionListener(this);
            }
        }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (!ocupado){
            String[] codigo = ((JButton)ae.getSource()).getName().split(":");
            int x = Integer.parseInt(codigo[1]);
            int y = Integer.parseInt(codigo[3]);
             Pregunta pregunta = juego.getPregunta(x, y);
             ControllerPreguntas contPreg = new ControllerPreguntas(pregunta,this,juego);
             ((JButton)ae.getSource()).setEnabled(false);
             ocupado = true;
        }
    }
    
    public void finDeTurno(){
        ocupado = false;
        setPuntuacionBotones();
    }
    
    public void setPuntuacionBotones(){
        JButton[][] botones = vistaTablero.getBotones();
        for (int i = 0; i < botones[0].length; i++){
            for (int j = 0; j < botones.length; j++){
                botones[j][i].setText(juego.getStringPuntuacion(i));
            }
        }
    }
}
