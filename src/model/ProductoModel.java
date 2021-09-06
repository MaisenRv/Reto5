package model;

public class ProductoModel {
    private int idProducto;
    private String nombreProducto;
    private double precio;

    public ProductoModel(int idProducto,String nombreProducto,double precio){
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
    }

    

    /**
     * @return int return the idProducto
     */
    public int getIdProducto() {
        return idProducto;
    }

    /**
     * @return String return the nombreProducto
     */
    public String getNombreProducto() {
        return nombreProducto;
    }

    /**
     * @return double return the precio
     */
    public double getPrecio() {
        return precio;
    }

    public String toString() {
        return this.nombreProducto;
    }
}