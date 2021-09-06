package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.PanelControles;


public class EventoClick implements ActionListener{
    private PanelControles panelControles;

    
    public EventoClick(PanelControles panelControles) {
        this.panelControles = panelControles;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.panelControles.getEliminar_btn()) {
            this.panelControles.getEliminar_btn().setEnabled(false);
            int decision = JOptionPane.showConfirmDialog(this.panelControles.getEliminar_btn(), "Esta seguro que quiere eliminar el registro seleccionado"
                                            , "¿Quiere borrar el registro?", JOptionPane.YES_NO_OPTION);
            if (decision == 0)  {
                

            }
        }
    }
    
}