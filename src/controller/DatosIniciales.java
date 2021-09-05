package controller;

import java.util.ArrayList;

import access.AlmacenaDAO;
import model.AlmacenaModel;

public class DatosIniciales {
    private ArrayList<AlmacenaModel> almacena= null;

    public DatosIniciales() {
        AlmacenaDAO almacenaDAO = new AlmacenaDAO();
        this.almacena =  almacenaDAO.getAllAlmacena();
    }

    public ArrayList<AlmacenaModel> getAlmacena() {
        return this.almacena;
    }


}