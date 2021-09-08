package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import access.AlmacenaDAO;
import model.*;
import view.PanelControles;


public class EventoClick implements ActionListener {

    //Atribitos
    private PanelControles panelControles;

    //Constructor
    public EventoClick(PanelControles panelControles) {
        this.panelControles = panelControles;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        //BOTON ACTUALIZAR
        if (e.getSource() == this.panelControles.getActualizar_btn()) {
            AlmacenaDAO almacenaDAO = new AlmacenaDAO();
            PanelControles.setTablaResultados(almacenaDAO.getAllAlmacena());;
            //System.out.println("Actualizado"); 
        }

        //BOTON INSERTAR
        else if (e.getSource() == this.panelControles.getInsertar_btn()){
            int idBodega = ((BodegaModel)panelControles.getNBodegaBox().getSelectedItem()).getIdBodega();
            int idProducto = ((ProductoModel)panelControles.getNProductoBox().getSelectedItem()).getIdProducto();
            int cantidad = -1;

            //validando los datos
            try {
                cantidad =  Integer.parseInt(panelControles.getCantidadTxt().getText());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "La cantidad deber ser un numero", 
                                            "Dato incorrecto", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            if (idBodega == -1 || idProducto == -1 ||cantidad <= 0) {
                JOptionPane.showMessageDialog(null, "Para insertar un nuevo registro debe seleccionar una opcion en los dos campos requeridos y la cantidad debe ser mayor a 0", 
                                            "Datos faltantes", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            //agregando los datos
            AlmacenaModel almacenaModel = new AlmacenaModel(idBodega,idProducto,cantidad);
            AlmacenaDAO almacenaDAO = new AlmacenaDAO();
            if (almacenaDAO.siExisteRegistro("SELECT idBodega,idproducto FROM almacena WHERE idBodega = ? AND idproducto = ?", idBodega, idProducto)) {
                 almacenaDAO.updateAlmacena(almacenaModel);
             }else{
                almacenaDAO.insertAlmacena(almacenaModel);
            }
            panelControles.getCantidadTxt().setText("");
        }
    }

}
