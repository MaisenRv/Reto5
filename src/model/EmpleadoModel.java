package model;

public class EmpleadoModel {
    private int idEmpleado;
    private int idBodegaFK;
    private String nombreEmpleado;
    private int edad;

    public EmpleadoModel(int idEmpleado, int idBodegaFK, String nombreEmpleado, int edad) {
        this.idEmpleado = idEmpleado;
        this.idBodegaFK = idBodegaFK;
        this.nombreEmpleado = nombreEmpleado;
        this.edad = edad;
    }

     //---------------------getters y setters ---------------------//

    /**
     * @return int return the idEmpleado
     */
    public int getIdEmpleado() {
        return idEmpleado;
    }


    /**
     * @return int return the idBodegaFK
     */
    public int getIdBodegaFK() {
        return idBodegaFK;
    }

    /**
     * @return String return the nombreEmpleado
     */
    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    /**
     * @return int return the edad
     */
    public int getEdad() {
        return edad;
    }

}