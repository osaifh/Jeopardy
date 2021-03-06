package Views;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ViewResultado extends JFrame {
    private JPanel[] panelJugadores;
    private JButton restart;
    
    public ViewResultado(){
        addComponentsToPane(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.pack();
        centrarPanel(this);
    }
    
    public void centrarPanel(JFrame frame){
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x,y);
    }
    
    private void addComponentsToPane(Container panel) {
        JPanel panelTitulo = new JPanel();
        JLabel titulo = new JLabel("Fin del juego\n");
        panelTitulo.setPreferredSize(new Dimension(500,40));
        panelTitulo.add(titulo);
        panel.add(panelTitulo,BorderLayout.NORTH);
        JPanel panelResultado = new JPanel();
        panelResultado.setLayout(new GridLayout(1,2));
        panelJugadores = new JPanel[2];
        
        for (int i = 0; i < panelJugadores.length; i++){
            panelJugadores[i] = new JPanel();
            panelJugadores[i].setLayout(new BoxLayout(panelJugadores[i],BoxLayout.Y_AXIS));
            for (int j = 0; j < 4; j++){
                panelJugadores[i].add(Box.createRigidArea(new Dimension(50,20)));
                panelJugadores[i].add(new JLabel("\n\n"));
            }
            panelJugadores[i].add(Box.createRigidArea(new Dimension(50,20)));
            panelResultado.add(panelJugadores[i]);
        }
        panel.add(panelResultado,BorderLayout.CENTER);
        restart = new JButton("Reiniciar");
        panel.add(restart,BorderLayout.SOUTH);
    }
    
    public JPanel[] getPanelJugadores(){
        return panelJugadores;
    }
    
    public JButton getRestart(){
        return restart;
    }
}
