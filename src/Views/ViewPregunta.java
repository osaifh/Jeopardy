
package Views;
import java.awt.*;
import Model.Pregunta;
import javax.swing.*;

public class ViewPregunta extends JFrame {
    private Pregunta modelP;
    private String[] respuestas;
    private JRadioButton respuesta1;
    private JRadioButton respuesta2;
    private JRadioButton respuesta3;
    private JButton intento;
    
    public ViewPregunta(Pregunta modelP){
    this.modelP=modelP;
    respuestas = modelP.getRespuestas();
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    addComponentsToPane(this.getContentPane());
    this.setResizable(false);
        this.setVisible(true);
        this.pack(); //me esta dando errores
    }
     private void addComponentsToPane(Container panel) {
      JLabel pregunta = new JLabel(modelP.getTexto());
       JPanel respuesta = new JPanel();
       respuesta.setLayout(new GridLayout(3, 1));
       respuesta1 = new JRadioButton(respuestas[0]);
       respuesta2 = new JRadioButton(respuestas[1]);
       respuesta3 = new JRadioButton(respuestas[2]);
       respuesta.add(respuesta1);
       respuesta.add(respuesta2);
       respuesta.add(respuesta3);
     }
      public void addListeners(ViewPregunta preguntasController) {

        //intento.addActionListener(preguntasController);

    }   
    public int getRespuestaSeleccionada() {
        if (respuesta1.isSelected()) {
            return 0;
        } else {
            if (respuesta2.isSelected()) {
                return 1;
            } else {
                if (respuesta3.isSelected()) {
                    return 2;
                } else {
                    return 3;
                }
            }
        }
    }  
    
    public void cambiarColorVerde(int respuesta) {
        if (respuesta == 0) {
            respuesta1.setBackground(Color.GREEN);
        }
        if (respuesta == 1) {
            respuesta2.setBackground(Color.GREEN);
        }
        if (respuesta == 2) {
            respuesta3.setBackground(Color.GREEN);
        }
    }

    public void cambiarColorRojo(int respuesta) {
        if (respuesta == 0) {
            respuesta1.setBackground(Color.red);
        }
        if (respuesta == 1) {
            respuesta2.setBackground(Color.red);
        }
        if (respuesta == 2) {
            respuesta3.setBackground(Color.red);
        }
    }

    public void txt() {
        intento.setText("Siguiente");
    }
}
