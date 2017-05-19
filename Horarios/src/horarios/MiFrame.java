package horarios;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MiFrame extends JFrame {

    public MiFrame(String carrera2) {
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, (screenSize.height - 50));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Image icono = Toolkit.getDefaultToolkit().getImage("src\\imagenes\\SEP.jpg");
        this.setIconImage(icono);
        Principal principal = new Principal(this, carrera2); 
        add(principal);
        setVisible(true);
    }

    public void remover(JPanel remover, JPanel agregar) {
        remove(remover);
        add(agregar);
        setVisible(true);
    }
}
