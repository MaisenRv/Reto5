package access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.EmpleadoModel;
import utils.ConexionDB;

public class EmpleadoDAO {
    private Connection conn = null;

    public ArrayList<EmpleadoModel> getAllEmpleados() {
        ArrayList<EmpleadoModel> empleados = new ArrayList<EmpleadoModel>();
        try {
            if (conn == null) conn = ConexionDB.getConexion();


            String sql = "SELECT idempleado,idBodega,nombre,edad FROM empleado;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            while (result.next()) {
                EmpleadoModel empleado = new EmpleadoModel(result.getInt(1), result.getInt(2), result.getString(3),result.getInt(4));
                empleados.add(empleado);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Código : " + e.getErrorCode() + "\nError :" + e.getMessage());
        }

        return empleados;
    }

    public EmpleadoModel getEmpleado(int id) {
        EmpleadoModel empleado = null;

        try {
            if (conn == null) conn = ConexionDB.getConexion();

            String sql = "SELECT idBodega,nombre,edad FROM empleado WHERE idempleado = ?;";
            PreparedStatement statement =conn.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                empleado = new EmpleadoModel(id,result.getInt(1),result.getString(2),result.getInt(3));
                break;
            } 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Código : " + e.getErrorCode() + "\nError :" + e.getMessage());
        }
        
        return empleado;
    }

    public void insertEmpleado(EmpleadoModel empleado) {
        try {
            if (conn == null) conn = ConexionDB.getConexion();

            String sql = "INSERT INTO empleado(idBodega,nombre,edad) VALUES (?,?,?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, empleado.getIdBodegaFK());
            statement.setString(2, empleado.getNombreEmpleado());
            statement.setInt(3, empleado.getEdad());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0 ) {
                JOptionPane.showMessageDialog(null, "El registro fue agregado exitosamente !");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Código : " + e.getErrorCode() + "\nError :" + e.getMessage());
        }
        
    }

    public void updateEmpleado(EmpleadoModel empleado) {
        try {
            if (conn == null) conn = ConexionDB.getConexion();

            String sql = "UPDATE empleado SET idBodega = ?, nombre = ?, edad = ? WHERE idempleado = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, empleado.getIdBodegaFK());
            statement.setString(2, empleado.getNombreEmpleado());
            statement.setInt(3, empleado.getEdad());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "El registro fue actualizado exitosamente !");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Código : " + e.getErrorCode() + "\nError :" + e.getMessage());
        }
    }

    public void deleteEmpleado(int id) {
        try {
            if (conn == null) conn = ConexionDB.getConexion();
            String sql = "DELETE FROM empleado WHERE idempleado = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "El registro fue borrado exitosamente !");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Código : "+ e.getErrorCode() + "\nError :" + e.getMessage());
        }
        
    }
}