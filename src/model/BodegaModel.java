package model;

public class BodegaModel {
    private int idBodega;
    private String nombreBodega;
    private String direccion;

    public BodegaModel(int idBodega,String nombreBodega,String direccion){
        this.idBodega = idBodega;
        this.nombreBodega = nombreBodega;
        this.direccion = direccion;
    }
    
    //---------------------getters y setters ---------------------//
    /**
     * @return int return the idBodega
     */
    public int getIdBodega() {
        return idBodega;
    }

    /**
     * @return String return the nombre
     */
    public String getNombre() {
        return nombreBodega;
    }

    /**
     * @return String return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    public String toString() {
        return this.nombreBodega;
    }

}