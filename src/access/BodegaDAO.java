package access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.BodegaModel;
import utils.ConexionDB;

public class BodegaDAO {
    
    private Connection conn = null;

    public ArrayList<BodegaModel> getAllBodegas() {
        ArrayList<BodegaModel> bodegas = new ArrayList<BodegaModel>();
        try {
            if (conn == null) conn = ConexionDB.getConexion();


            String sql = "SELECT idBodega,nombre,direccion FROM bodega;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            while (result.next()) {
                BodegaModel bodega = new BodegaModel(result.getInt(1), result.getString(2), result.getString(3));
                bodegas.add(bodega);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Código : " + e.getErrorCode() + "\nError :" + e.getMessage());
        }

        return bodegas;
    }

    public BodegaModel getBodega(int id) {
        BodegaModel bodega = null;

        try {
            if (conn == null) conn = ConexionDB.getConexion();

            String sql = "SELECT nombre,direccion FROM bodega WHERE idBodega = ?;";
            PreparedStatement statement =conn.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                bodega = new BodegaModel(id,result.getString(1),result.getString(2));
                break;
            } 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Código : " + e.getErrorCode() + "\nError :" + e.getMessage());
        }
        
        return bodega;
    }

    public void insertBodega(BodegaModel bodega) {
        try {
            if (conn == null) conn = ConexionDB.getConexion();

            String sql = "INSERT INTO bodega(nombre,direccion) VALUES (?,?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, bodega.getNombre());
            statement.setString(2, bodega.getDireccion());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0 ) {
                JOptionPane.showMessageDialog(null, "El registro fue agregado exitosamente !");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Código : " + e.getErrorCode() + "\nError :" + e.getMessage());
        }
        
    }

    public void updateBodega(BodegaModel bodega) {
        try {
            if (conn == null) conn = ConexionDB.getConexion();

            String sql = "UPDATE bodega SET nombre = ?, direccion = ? WHERE idBodega = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, bodega.getNombre());
            statement.setString(2, bodega.getDireccion());
            statement.setInt(3, bodega.getIdBodega());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "El registro fue actualizado exitosamente !");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Código : " + e.getErrorCode() + "\nError :" + e.getMessage());
        }
    }

    public void deleteBodega(int id) {
        try {
            if (conn == null) conn = ConexionDB.getConexion();
            String sql = "DELETE FROM bodega WHERE idbodega = ?";
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