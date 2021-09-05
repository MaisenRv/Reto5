package view;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.GridLayout;
import java.util.ArrayList;

import controller.DatosIniciales;
import model.AlmacenaModel;

public class PanelControles extends JPanel{

    JTable tlbResultados;

    public PanelControles(PanelResultados panelResultados){
        this.tlbResultados = panelResultados.getTblResultados();
        initComponents();
    }

    private void initComponents() {
        setLayout(new GridLayout(2,1));

        DatosIniciales datosIniciales = new DatosIniciales(); 

        this.setTablaResultados(datosIniciales.getAlmacena());
    }

    public void setTablaResultados(ArrayList<AlmacenaModel> almacena){
        String [] cabeseras = {"Bodega","Direccion","Producto","Precio unitario","Cantidad"};
        this.tlbResultados.removeAll();

        DefaultTableModel tableModel = new DefaultTableModel();

        tableModel.setColumnIdentifiers(cabeseras);
        this.tlbResultados.setModel(tableModel);

        for(int i=0; i < almacena.size(); i++){
            tableModel.addRow(almacena.get(i).toArray());
        }
    }

}