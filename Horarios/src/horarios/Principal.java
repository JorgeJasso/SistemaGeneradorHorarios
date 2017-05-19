package horarios;

import horariosBeans.HorariosBeans;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Principal extends JPanel {

    private final JLabel fondo;
    private final JButton modificar;
    private final JButton salir;
    private final MiFrame interfaz;
    private final Principal principal;
    private final JPanel inferior;
    private String carrera3;

    public Principal(MiFrame interfaz, String carrera3) {
        this.carrera3 = carrera3;
        EventosPrincipal eventos = new EventosPrincipal();
        this.interfaz = interfaz;
        principal = this;
        inferior = new JPanel();
        setLayout(null);

        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        ImageIcon icon = new ImageIcon("src\\imagenes\\SEP.jpg");
        fondo = new JLabel(icon);
        fondo.setBounds(15, 15, (screenSize.width - 50), (screenSize.height - 140));
        add(fondo);

        modificar = new JButton("Modificar Horario");
        modificar.setBounds(149, 330, 95, 33);
        modificar.setBackground(Color.DARK_GRAY);
        modificar.setForeground(Color.WHITE);
        modificar.addActionListener(eventos);
        inferior.add(modificar);

        salir = new JButton("Salir");
        salir.setBounds(361, 330, 80, 33);
        salir.setBackground(Color.DARK_GRAY);
        salir.setForeground(Color.WHITE);
        salir.addActionListener(eventos);
        inferior.add(salir);

        interfaz.add(inferior, BorderLayout.SOUTH);

    }
    HorariosBeans horariosBeans = new HorariosBeans();

    public class EventosPrincipal implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == modificar) {
                ModificarHorario modificar = new ModificarHorario(interfaz, carrera3);
                interfaz.remove(principal);
                interfaz.remove(inferior);
            } else {
                System.exit(0);
            }
        }
    }
}
