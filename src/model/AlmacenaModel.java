package model;

public class AlmacenaModel {

    private int idBodegaFK;
    private int idProductoFK;
    private int cantidad;

    private String nombreBodega;
    private String direccion;
    private double precio;
    private String nombreProducto;
    
    public AlmacenaModel(){
        
    }

    public AlmacenaModel(int idBodegaFK, int idProductoFK, int cantidad) {
        this.idBodegaFK = idBodegaFK;
        this.idProductoFK = idProductoFK;
        this.cantidad = cantidad;
    }

    public AlmacenaModel(int idBodegaFK, int idProductoFK) {
        this.idBodegaFK = idBodegaFK;
        this.idProductoFK = idProductoFK;
    }

    public AlmacenaModel(String bodega, String producto, int cantidad) {
        this.nombreBodega = bodega;
        this.nombreProducto = producto;
        this.cantidad = cantidad;
    }

    public AlmacenaModel(String nombreBodega, String direccion, String nombreProducto, double precio, int cantidad) {
        this.nombreBodega = nombreBodega;
        this.direccion = direccion;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    //---------------------getters y setters ---------------------//
    public String getNombreProducto() {
        return this.nombreProducto;
    }

    public String getNombreBodega() {
        return nombreBodega;
    }

    public String getDireccion() {
        return direccion;
    }

    public double getPrecio() {
        return precio;
    }

    /**
     * @return int return the idBodegaFK
     */
    public int getIdBodegaFK() {
        return idBodegaFK;
    }

    /**
     * @return int return the idProductoFK
     */
    public int getIdProductoFK() {
        return idProductoFK;
    }

    /**
     * @return int return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    public Object[] toArray() {
        Object[] datos = {nombreBodega, direccion, nombreProducto, precio, cantidad};
        return datos;
    }

}
