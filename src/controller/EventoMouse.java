package controller;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.event.MouseInputListener;



import view.PanelControles;

public class EventoMouse implements MouseInputListener{

    private PanelControles panelControles;

    public EventoMouse(PanelControles panelControles) {
        this.panelControles = panelControles;
    }
    public EventoMouse() {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == this.panelControles.getTlbResultados()) {
            JTable tablaResultados = this.panelControles.getTlbResultados();
            int filaSeleccionada = tablaResultados.rowAtPoint(e.getPoint());
            System.out.println(String.valueOf(tablaResultados.getValueAt(filaSeleccionada, 0)));
            System.out.println(String.valueOf(tablaResultados.getValueAt(filaSeleccionada, 2)));
            this.panelControles.getEliminar_btn().setEnabled(true);

        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    
}