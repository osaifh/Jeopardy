package Views;

import java.awt.*;
import Model.Pregunta;
import javax.swing.*;

public class ViewPregunta extends JFrame {
    private Pregunta modelP;
    private String[] respuestas;
    private JRadioButton[] botonesRespuesta;
    private JButton responder;
    private ButtonGroup group;
    
    public ViewPregunta(Pregunta modelP) {
        this.modelP = modelP;
        respuestas = modelP.getRespuestas();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addComponentsToPane(this.getContentPane());
        this.setResizable(false);
        this.setVisible(true);
        this.pack();
    }

    private void addComponentsToPane(Container panel) {
        JLabel pregunta = new JLabel(modelP.getTexto());
        JPanel respuesta = new JPanel();
        JPanel confirmar = new JPanel();
        group = new ButtonGroup();
        botonesRespuesta = new JRadioButton[3];
        respuesta.setLayout(new GridLayout(3, 1));
        botonesRespuesta[0] = new JRadioButton(respuestas[0]);
        botonesRespuesta[1] = new JRadioButton(respuestas[1]);
        botonesRespuesta[2] = new JRadioButton(respuestas[2]);
        for (JRadioButton boton : botonesRespuesta){
            group.add(boton);
            respuesta.add(boton);
        }
        responder = new JButton();
        responder.setText("Responde");
        confirmar.add(responder);
        panel.add(pregunta, BorderLayout.NORTH);
        panel.add(respuesta, BorderLayout.CENTER);
        panel.add(confirmar, BorderLayout.SOUTH);
    }
    
    public int getRespuestaSeleccionada() {
        for (int i = 0; i < botonesRespuesta.length; i++){
            if (botonesRespuesta[i].isSelected()) return i;
        }
        return -1;
    }

    public JButton getBotonRespuesta() {
        return responder;
    }

    public void cambiarColorVerde(int respuesta) {
        botonesRespuesta[respuesta].setBackground(Color.GREEN);
    }

    public void cambiarColorRojo(int respuesta) {
        botonesRespuesta[respuesta].setBackground(Color.RED);
    }

    public boolean respuestaSeleccionada(){
        for (JRadioButton boton : botonesRespuesta){
            if (boton.isSelected()) return true;
        }
        return false;
    }

}
