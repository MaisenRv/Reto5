package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import access.AlmacenaDAO;
import model.AlmacenaModel;
import view.PanelControles;


public class EventoClick implements ActionListener {

    private PanelControles panelControles;
    private AlmacenaModel almacena;
    private String bodega, producto;
    int cantidad, guevos;

    public EventoClick(PanelControles panelControles) {
        this.panelControles = panelControles;
    }

    public EventoClick() {

    }

    public void setDatosEliminar(String bodega, String producto, int cantidad) {
        this.bodega = bodega;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //BOTON ACTUALIZAR
        if (e.getSource() == this.panelControles.getActualizar_btn()) {
            AlmacenaDAO almacenaDAO = new AlmacenaDAO();
            PanelControles.setTablaResultados(almacenaDAO.getAllAlmacena());;
            //System.out.println("Actualizado");
        }
    }

    
    public void setAlmacena(AlmacenaModel almacena) {
        this.almacena = almacena;
    }
}
