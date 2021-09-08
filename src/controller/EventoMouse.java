package controller;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.MouseInputListener;

import access.AlmacenaDAO;
import view.PanelControles;


public class EventoMouse implements MouseInputListener {

    //Atributos
    private PanelControles panelControles;
    private String bodega;
    private String producto;

    //Constructor
    public EventoMouse(PanelControles panelControles) {
        this.panelControles = panelControles;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        // Auto-generated method stub
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TABLA
        if (e.getSource() == this.panelControles.getTlbResultados()) {
            JTable tablaResultados = this.panelControles.getTlbResultados();
            this.panelControles.getEliminar_btn().setEnabled(true);
            this.bodega = String.valueOf(tablaResultados.getValueAt(tablaResultados.getSelectedRow(), 0));
            this.producto = String.valueOf(tablaResultados.getValueAt(tablaResultados.getSelectedRow(), 2));
        }
        // BOTON ELIMINAR
        if (e.getSource() == this.panelControles.getEliminar_btn()) {
            this.panelControles.getEliminar_btn().setEnabled(false);
            int decision = JOptionPane.showConfirmDialog(this.panelControles.getEliminar_btn(), "Esta seguro que quiere eliminar el registro seleccionado",
                    "¿Quiere borrar el registro?", JOptionPane.YES_NO_OPTION);
            if (decision == 0) {
                eliminarDatos(this.bodega,this.producto);
            }
            
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Auto-generated method stub

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // Auto-generated method stub

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //  Auto-generated method stub

    }

    public void eliminarDatos(String bodega,String producto) {
        DatosIniciales datosIniciales = new DatosIniciales(bodega, producto);
        ArrayList<Integer> ids = new ArrayList<Integer>();
        ids.add(datosIniciales.getAlmacenaEliminar().get(0).getIdBodegaFK());
        ids.add(datosIniciales.getAlmacenaEliminar().get(0).getIdProductoFK());
        AlmacenaDAO almacenaDAO = new AlmacenaDAO();
        almacenaDAO.deleteAlmacena(ids.get(0), ids.get(1));
    }

}
