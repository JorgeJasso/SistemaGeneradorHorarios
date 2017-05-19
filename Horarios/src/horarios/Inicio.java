package horarios;

import conexion.Conexion;
import horariosBeans.HorariosBeans;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import tablas.Alumno;

public class Inicio extends JFrame {

    private HorariosBeans horariosBeans;
    private final JLabel txtNumControl;
    private final JLabel txtContraseña;
    private final JButton aceptar;
    private final JTextField contraseña;
    private final JTextField numControl;
    static Inicio marco;

    public String carrera1;

    public Inicio() {
        super("Registro");
        setLayout(null);

        txtNumControl = new JLabel("Número de Control");
        txtNumControl.setBounds(30, 10, 200, 30);
        add(txtNumControl);
        numControl = new JTextField();
        numControl.setBounds(220, 10, 100, 20);
        numControl.setEditable(true);
        add(numControl);

        aceptar = new JButton("Aceptar");
        aceptar.setBounds(120, 120, 100, 30);
        add(aceptar);

        txtContraseña = new JLabel("Contraseña");
        txtContraseña.setBounds(30, 60, 200, 30);
        add(txtContraseña);
        contraseña = new JTextField();
        contraseña.setBounds(220, 60, 100, 20);
        contraseña.setEditable(true);
        add(contraseña);

        Eventos click = new Eventos();

        aceptar.addActionListener(click);

    }

    private class Eventos implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            if (validarAlumno(Integer.parseInt(numControl.getText()), contraseña.getText())) {
                horariosBeans = new HorariosBeans();
                marco.dispose();
                MiFrame entre = new MiFrame(carrera1);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro registro con el numero de control \n y contraseña introducidos");
            }
        }

    }

    public boolean validarAlumno(int num_control, String contraseña) {
        boolean estado = false;
        if (Conexion.establecerConexion()) {
            String sql = "Select * from horarios.alumno where num_Control = '" + num_control + "' and contraseña='" + contraseña + "'";

            try {
                ResultSet consulta;
                consulta = Conexion.ejecutarSQLSelect(sql);

                while (consulta.next()) {
                    carrera1 = consulta.getString("Carrera");
                    Alumno.num_Control = Integer.parseInt(consulta.getString("Num_Control"));
                    Alumno.nombre_Alumno = consulta.getString("Nombre_Alumno");
                    Alumno.apellido_Paterno = consulta.getString("Apellido_Paterno");
                    Alumno.apellido_Materno = consulta.getString("Apellido_Materno");
                    Alumno.carrera = consulta.getString("Carrera");
                    Alumno.semestre = Integer.parseInt(consulta.getString("Semestre"));
                    //Alumno.contraseña = consulta.getString("Contraseña");
                    estado = true;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error metodo validarAlumno" + e);
                estado = false;
            }
        } else {
            estado = false;
        }
        return estado;
    }

    public static void main(String[] args) {
        marco = new Inicio();
        marco.setSize(400, 200);
        marco.setVisible(true);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
