
package Controller;

import Model.Pregunta;
import Views.ViewPregunta;
import Views.ViewTablero;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import jeopardy.InputFicheros;


public class ControllerPreguntas implements ActionListener{
    private Pregunta preguntaModel;
    private ControllerTablero controllerTablero;
    private ViewPregunta viewPregunta;
    

    public ControllerPreguntas(Pregunta preguntaModel, ControllerTablero controllerTablero) {
        this.preguntaModel = preguntaModel;
        this.controllerTablero = controllerTablero;
        viewPregunta = new ViewPregunta(preguntaModel);
        viewPregunta.devuelveBottonRespuesta().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
      int respSelec = viewPregunta.getRespuestaSeleccionada();
      controllerTablero.responderPregunta(preguntaModel, respSelec);
      viewPregunta.dispose();
    }
    
    
}
