
package Controller;

import Model.Jugador;
import Views.ViewTablero;
import Views.ViewUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ControllerVista implements ActionListener{
    private ViewUsuarios vistaUsuarios;
    private Jugador[] usuarios = new Jugador[2];
    private JButton ok;
    private ViewTablero vistaTablero;
    public ControllerVista(ViewUsuarios vistaUsuarios) {
        this.vistaUsuarios = vistaUsuarios;
       
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==this.ok){
        usuarios[0] = new Jugador(vistaUsuarios.obtenerNombreUsuarios()[0]);
        usuarios[1] = new Jugador(vistaUsuarios.obtenerNombreUsuarios()[1]);
        ControllerTablero contTablero = new ControllerTablero(vistaTablero);
    }
}
}
