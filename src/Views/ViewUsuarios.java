
package Views;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;

public class ViewUsuarios extends JFrame {

    private JLabel userL1;
    private JTextField user1;
    private JLabel userL2;
    private JTextField user2;
    private JButton ok;

    public ViewUsuarios() {
        this.setTitle("Jeopardy");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(this.getContentPane());
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

    public JButton getBoton() {
        return ok;
    }

    private void addComponentsToPane(Container panel) {
        BoxLayout boxuser = new BoxLayout(panel, BoxLayout.Y_AXIS);
        userL1 = new JLabel("Jugador 1: ");
        userL2 = new JLabel("Jugador 2: ");
        user1 = new JTextField();
        user1.setPreferredSize(new Dimension(400, 25));

        user2 = new JTextField();
        user2.setPreferredSize(new Dimension(400, 25));

        ok = new JButton("ok");
        panel.setLayout(boxuser);
        userL1.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(userL1);
        user1.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(user1);
        userL2.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(userL2);
        user2.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(user2);
        ok.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(ok);

    }

    public String[] obtenerNombreUsuarios() {
        String[] nombre = new String[2];
        nombre[0] = user1.getText();
        nombre[1] = user2.getText();
        return nombre;
    }
    
    public JTextField[] getCampos(){
        JTextField[] campos = { user1, user2 };
        return campos;
    }

    public void muestraError(String error) {
        JOptionPane.showMessageDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
