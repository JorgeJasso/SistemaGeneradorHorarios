package conexion;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {

    private static Connection conexion;

    public static Connection getConexion() {
        return conexion;
    }

    public static void setConexion(Connection aConexion) {
        conexion = aConexion;
    }

    public static boolean establecerConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:1997/horarios?zeroDateTimeBehavior=convertToNull", "root", "Araceli1997");
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos " + ex);
            return false;
        }
        return true;
    }

    public static boolean ejecutarSQL(String sql) {
        try {
            Statement instruccion = Conexion.getConexion().createStatement();
            instruccion.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar SQL" + ex);
            return false;
        }
        return true;
    }

    public static ResultSet ejecutarSQLSelect(String sql) {
        ResultSet consulta;
        try {
            Statement instruccion = Conexion.getConexion().createStatement();
            consulta = instruccion.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar SQLSelect" + ex);
            return null;
        }
        return consulta;
    }

    public static void cerrarConexion() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexion con la base de datos" + ex);
        }
    }
}
