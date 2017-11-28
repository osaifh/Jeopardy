
package Controller;

import Model.Juego;
import Model.Pregunta;
import Views.ViewPregunta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class ControllerPreguntas implements ActionListener {
    private Pregunta pregunta;
    private ControllerTablero controllerTablero;
    private ViewPregunta viewPregunta;
    private Juego juego;
    private ActionListener taskPerformer = (ActionEvent e) -> {
        viewPregunta.dispose();
        controllerTablero.finDeTurno();
    };
    private Timer timer = new Timer(3000,taskPerformer);
    
    public ControllerPreguntas(Pregunta preguntaModel, ControllerTablero controllerTablero, Juego juego) {
        this.pregunta = preguntaModel;
        this.controllerTablero = controllerTablero;
        viewPregunta = new ViewPregunta(preguntaModel);
        viewPregunta.getBotonRespuesta().addActionListener(this);
        this.juego = juego;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (viewPregunta.respuestaSeleccionada()){
            int respSelec = viewPregunta.getRespuestaSeleccionada();
            if (juego.preguntaRespondida(pregunta, respSelec)){
                viewPregunta.cambiarColorVerde(respSelec);
            }
            else {
                viewPregunta.cambiarColorVerde(pregunta.getRespuestaCorrecta());
                viewPregunta.cambiarColorRojo(respSelec);
            }
            viewPregunta.getBotonRespuesta().setEnabled(false);
            timer.start();
        }
    }
    
}
