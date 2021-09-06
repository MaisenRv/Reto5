package controller;

import java.util.ArrayList;

import access.*;
import model.*;

public class DatosIniciales {
    private ArrayList<AlmacenaModel> almacena= null;
    private ArrayList<BodegaModel> bodegas= null;
    private ArrayList<EmpleadoModel> empleados= null;
    private ArrayList<ProductoModel> productos= null;

    public DatosIniciales() {
        BodegaDAO bodegaDAO = new BodegaDAO();
        this.bodegas = bodegaDAO.getAllBodegas();
        this.bodegas.add(0,new BodegaModel(-1, "Todas las bodegas", "-1"));

        ProductoDAO productoDAO = new ProductoDAO();
        this.productos = productoDAO.getAllProductos();
        this.productos.add(0, new ProductoModel(-1, "Todos los productos", -1));
        


        AlmacenaDAO almacenaDAO = new AlmacenaDAO();
        this.almacena =  almacenaDAO.getAllAlmacena();
    }

    public ArrayList<BodegaModel> getBodegas() {
        return bodegas;
    }

    public ArrayList<AlmacenaModel> getAlmacena() {
        return this.almacena;
    }

    public ArrayList<ProductoModel> getProductos() {
        return productos;
    }


}