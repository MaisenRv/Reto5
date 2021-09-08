package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PanelResultados extends JPanel{

    private JTable tblResultados;
    private JScrollPane jspPane;

    public PanelResultados() {
        initComponents();
        setBounds(650, 0, 650, 700);
    }

    private void initComponents() {
        this.tblResultados = new JTable();
        this.tblResultados.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.jspPane = new JScrollPane(this.tblResultados);
        System.out.println(this.tblResultados.getSelectedRow());
        add(jspPane, BorderLayout.CENTER);

    }

     //---------------------getters y setters ---------------------//
    public JTable getTblResultados() {
        return tblResultados;
    }

    public void setTblResultados(JTable tblResultados) {
        this.tblResultados = tblResultados;
    }
}