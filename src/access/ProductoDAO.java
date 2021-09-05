package access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.ProductoModel;
import utils.ConexionDB;

public class ProductoDAO {
    private Connection conn = null; 

    public ArrayList<ProductoModel> getAllProductos() {
        ArrayList<ProductoModel> productos = new ArrayList<ProductoModel>();

        try {
            if (conn == null) conn = ConexionDB.getConexion();


            String sql = "SELECT idproducto,nombre,precio FROM producto;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            while (result.next()) {
                ProductoModel producto = new ProductoModel(result.getInt(1), result.getString(2), result.getDouble(3));
                productos.add(producto);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Código : " + e.getErrorCode() + "\nError :" + e.getMessage());
        }


        return productos;
    }

    public ProductoModel getProducto(int id) {
        ProductoModel producto = null;

        try {
            if (conn == null) ConexionDB.getConexion();

            String sql = "SELECT nombre,precio FROM producto WHERE idproducto = ? ;";
            PreparedStatement statement =conn.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                producto = new ProductoModel(id, result.getString(1), result.getDouble(2));
                break;
            } 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Código : " + e.getErrorCode() + "\nError :" + e.getMessage());
        }
        
        return producto;
    }

    public void insertProducto(ProductoModel producto) {
        try {
            if (conn == null) ConexionDB.getConexion();

            String sql = "INSERT INTO producto(nombre,precio) VALUES (?,?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, producto.getNombreProducto());
            statement.setDouble(2, producto.getPrecio());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0 ) {
                JOptionPane.showMessageDialog(null, "El registro fue agregado exitosamente !");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Código : " + e.getErrorCode() + "\nError :" + e.getMessage());
        }
        
    }

    public void updateProducto(ProductoModel producto) {
        try {
            if (conn == null) ConexionDB.getConexion();

            String sql = "UPDATE producto SET nombre = ?, precio = ? WHERE idproducto = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, producto.getNombreProducto());
            statement.setDouble(2, producto.getPrecio());
            statement.setInt(3, producto.getIdProducto());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "El registro fue actualizado exitosamente !");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Código : " + e.getErrorCode() + "\nError :" + e.getMessage());
        }
    }

    public void deleteProducto(int id) {
        try {
            if (conn == null) ConexionDB.getConexion();
            String sql = "DELETE FROM producto WHERE idproducto = ?";
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