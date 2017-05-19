package horariosBeans;

import conexion.Conexion;
import horarios.Renderizar;
import java.awt.Color;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class HorariosBeans {

    private JTable tabla;

    public HorariosBeans() {
    }

    public HorariosBeans(JTable tabla) {
        this.tabla = tabla;
    }

    public DefaultTableModel horarios_carreraEspecifica(String carrera) {
        tabla.setDefaultRenderer(Object.class, new Renderizar());
        DefaultTableModel modelo;
        String[] titulos = {"Estado", "Materia", "Semestre", "Maestro", "Lunes", "Martes", "Miercoles", "Juves", "Viernes"};
        Object[] registros = new Object[9];
        modelo = new DefaultTableModel(null, titulos) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        if (Conexion.establecerConexion()) {
            String sql = "SELECT Materia, Semestre, Maestro, HLunes, HMartes, HMiercoles, HJuves, HViernes FROM grupo where Carrera ='" + carrera + "'";
            try {
                ResultSet consulta;
                consulta = Conexion.ejecutarSQLSelect(sql);
                JButton boton = new JButton("Alta");
                boton.setBackground(Color.GREEN);
                while (consulta.next()) {
                    registros[0] = boton;
                    registros[1] = consulta.getString("Materia");
                    registros[2] = consulta.getString("Semestre");
                    registros[3] = consulta.getString("Maestro");
                    registros[4] = consulta.getString("HLunes");
                    registros[5] = consulta.getString("HMartes");
                    registros[6] = consulta.getString("HMiercoles");
                    registros[7] = consulta.getString("HJuves");
                    registros[8] = consulta.getString("HViernes");
                    modelo.addRow(registros);
                }
                return modelo;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error horarios_carreraEspecifica " + e);
                return null;
            }
        } else {
            return null;
        }
    }
}
