
package Views;

import Controller.ControllerTablero;
import Model.Pregunta;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
 

public class ViewTablero extends JFrame{
    public JLabel[] categoryNames = new JLabel[6];
    public JButton[][] buttonArray = new JButton[6][5];
    private ControllerTablero controlador;
    private Pregunta preg;
    private JLabel jugador1;
    private JLabel turnoJugador;
    private JLabel jugador2;
    public ViewTablero(){
        setLayout(new GridLayout(6,5));
       
       addComponentsToPane(this);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    private void addComponentsToPane(Container panel) {
    String[] nombreBoton = {"100", "200", "300", "400", "500"};
        String[] categoriaNombre = {"Deporte", "Historia", "Literatura", "Arte", "Geografia","Cultura"};

    Border border = BorderFactory.createLineBorder(Color.BLACK, 1);

// panel categorias

    for (int i = 0; i < categoriaNombre.length; ++i){
        JLabel categoria = new JLabel(categoriaNombre[i]);
        categoria.setHorizontalAlignment(SwingConstants.CENTER);
        
        categoria.setBorder(border);
        panel.add(categoria);
    }
    
    for (int i = 0; i < buttonArray[0].length; ++i){
        for (int j = 0; j < buttonArray.length; ++j){
            buttonArray[j][i] = new JButton(nombreBoton[i]);
            buttonArray[j][i].setSize(150, 100);
            buttonArray[j][i].setName("x: "+j+" y: "+i);
            panel.add(buttonArray[j][i], BorderLayout.CENTER);
        }
        
    }
    
    }
     public void doubleRound() {
        String[] doubleRoundNombreBotones = {"200", "400", "600", "800", "1000"};
        for (int i = 0; i < doubleRoundNombreBotones.length; i++) {
            for (int j = 0; j < 6; j++) {
                buttonArray[i][j].setText(doubleRoundNombreBotones[i]);
            }
        }
    }
     
     public JButton[][] getBotones(){
         return buttonArray;
     }
}
