package Views;

import java.awt.Container;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ViewResultado extends JFrame {
    private JLabel jugadorGanador;

    
    public ViewResultado(String nombreGanador){
        jugadorGanador = new JLabel("Ha ganado el jugador " + nombreGanador);
        addComponentsToPane(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.pack();
    }
    
    private void addComponentsToPane(Container panel) {
        //panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new BoxLayout(panelTitulo, BoxLayout.PAGE_AXIS));
        panelTitulo.add(new JLabel("Fin del juego"));
        panelTitulo.add(jugadorGanador);
        panel.add(panelTitulo);
    }
}
