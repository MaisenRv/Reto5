package view;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import controller.DatosIniciales;
import controller.EventoClick;
import controller.EventoMouse;
import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.AlmacenaModel;
import model.BodegaModel;
import model.ProductoModel;

public class PanelControles extends JPanel{

    JPanel titulo_panel;
    private static JTable tlbResultados;
    private JLabel titulo_lbl, insertar_lbl, nBodega_lbl, nProducto_lbl, cantidad_lbl, consultar_lbl, consultarBodega_lbl, consultarProducto_lbl;
    private JComboBox<BodegaModel> nBodega_box, buscarBodega_box; 
    private JComboBox<ProductoModel> nProducto_box, buscarProducto_box;
    private JTextField cantidad_txt;
    private JButton insertar_btn, eliminar_btn, consultar_btn, actualizar_btn, cerrar_btn;

    //Eventos
    private EventoClick eventoClick = new EventoClick(this);
    private EventoMouse eventoMouse = new EventoMouse(this);

    //Controladores
    private DatosIniciales datosIniciales = new DatosIniciales();

    public PanelControles(PanelResultados panelResultados) {
        tlbResultados = panelResultados.getTblResultados();
        add(panelResultados);
        tlbResultados.addMouseListener(eventoMouse);
        initComponents();
    }

    private void initComponents() {
        setLayout(null);
        setSize(650, 700);
        setBackground(Color.gray);

        //Estableciendo los datos de la tabla
        setTablaResultados(datosIniciales.getAlmacena());

        //creando todos los elementos
        crearEtiquetas();
        crearComoBoxes(datosIniciales);
        crearCajasTexto();
        crearBotones();
    }
    
    public void crearEtiquetas() {
        this.titulo_lbl = new JLabel("Te reto a programarlo S.A.S");
        this.titulo_lbl.setForeground(Color.BLACK);
        this.titulo_lbl.setFont(new Font("Courier new", Font.BOLD, 25));
        this.titulo_lbl.setBounds(25, 5, 500, 25);
        add(this.titulo_lbl).setVisible(true);

        this.insertar_lbl = new JLabel("Insertar un nuevo dato");
        this.insertar_lbl.setForeground(Color.BLACK);
        this.insertar_lbl.setFont(new Font("Courier new", Font.BOLD, 16));
        this.insertar_lbl.setBounds(25, 50, 300, 20);
        add(this.insertar_lbl).setVisible(true);

        this.nBodega_lbl = new JLabel("Seleccione una bodega:");
        this.nBodega_lbl.setForeground(Color.BLACK);
        this.nBodega_lbl.setFont(new Font("Courier new", Font.BOLD, 16));
        this.nBodega_lbl.setBounds(25, 75, 300, 20);
        add(this.nBodega_lbl).setVisible(true);

        this.nProducto_lbl = new JLabel("Seleccione un producto:");
        this.nProducto_lbl.setForeground(Color.BLACK);
        this.nProducto_lbl.setFont(new Font("Courier new", Font.BOLD, 16));
        this.nProducto_lbl.setBounds(25, 100, 300, 20);
        add(this.nProducto_lbl).setVisible(true);

        this.cantidad_lbl = new JLabel("Cantidad de datos:");
        this.cantidad_lbl.setForeground(Color.BLACK);
        this.cantidad_lbl.setFont(new Font("Courier new", Font.BOLD, 16));
        this.cantidad_lbl.setBounds(25, 125, 300, 20);
        add(this.cantidad_lbl).setVisible(true);

        this.consultar_lbl = new JLabel("Consultar un dato");
        this.consultar_lbl.setForeground(Color.BLACK);
        this.consultar_lbl.setFont(new Font("Courier new", Font.BOLD, 16));
        this.consultar_lbl.setBounds(25, 190, 300, 20);
        add(this.consultar_lbl).setVisible(true);

        this.consultarBodega_lbl = new JLabel("Consultar por bodega:");
        this.consultarBodega_lbl.setForeground(Color.BLACK);
        this.consultarBodega_lbl.setFont(new Font("Courier new", Font.BOLD, 16));
        consultarBodega_lbl.setBounds(25, 215, 300, 20);
        add(this.consultarBodega_lbl).setVisible(true);

        this.consultarProducto_lbl = new JLabel("Consultar por producto:");
        this.consultarProducto_lbl.setForeground(Color.BLACK);
        this.consultarProducto_lbl.setFont(new Font("Courier new", Font.BOLD, 16));
        this.consultarProducto_lbl.setBounds(25, 240, 300, 20);
        add(this.consultarProducto_lbl).setVisible(true);
    }
    public void crearComoBoxes(DatosIniciales datosIniciales) {
        this.nBodega_box = new JComboBox<BodegaModel>();
        this.nBodega_box.setModel(new DefaultComboBoxModel<>(datosIniciales.getBodegas().toArray(new  BodegaModel[datosIniciales.getBodegas().size()])));
        this.nBodega_box.setBounds(330, 75, 150, 20);
        add(this.nBodega_box).setVisible(true);

        this.nProducto_box = new JComboBox<ProductoModel>();
        this.nProducto_box.setModel(new DefaultComboBoxModel<>(datosIniciales.getProductos().toArray(new ProductoModel[datosIniciales.getProductos().size()])));
        this.nProducto_box.setBounds(330, 100, 150, 20);
        add(this.nProducto_box).setVisible(true);

        this.buscarBodega_box = new JComboBox<BodegaModel>();
        this.buscarBodega_box.setModel(new DefaultComboBoxModel<>(datosIniciales.getBodegas().toArray(new  BodegaModel[datosIniciales.getBodegas().size()])));
        this.buscarBodega_box.setBounds(330, 215, 150, 20);
        add(this.buscarBodega_box).setVisible(true);

        this.buscarProducto_box = new JComboBox<ProductoModel>();
        this.buscarProducto_box.setModel(new DefaultComboBoxModel<>(datosIniciales.getProductos().toArray(new ProductoModel[datosIniciales.getProductos().size()])));
        this.buscarProducto_box.setBounds(330, 240, 150, 20);
        add(this.buscarProducto_box).setVisible(true);
    }
    public void crearCajasTexto() {
        this.cantidad_txt = new JTextField();
        this.cantidad_txt.setBounds(330, 125, 80, 20);
        add(this.cantidad_txt).setVisible(true);
    }
    public void crearBotones() {
        this.insertar_btn = new JButton("INSERTAR");
        this.insertar_btn.setFont(new Font("Courier new", Font.BOLD, 14));
        this.insertar_btn.setBounds(420, 125, 120, 20);
        add(this.insertar_btn).setVisible(true);
        this.insertar_btn.addActionListener(eventoClick);

        this.eliminar_btn = new JButton("ELIMINAR");
        this.eliminar_btn.setFont(new Font("Courier new", Font.BOLD, 14));
        this.eliminar_btn.setBounds(420, 150, 120, 20);
        add(this.eliminar_btn).setVisible(true);
        this.eliminar_btn.setEnabled(false);
        this.eliminar_btn.addMouseListener(eventoMouse);

        this.consultar_btn = new JButton("BUSCAR");
        this.consultar_btn.setFont(new Font("Courier new", Font.BOLD, 14));
        this.consultar_btn.setBounds(420, 265, 120, 20);
        add(this.consultar_btn).setVisible(true);
        this.consultar_btn.addMouseListener(eventoMouse);
        
        this.actualizar_btn = new JButton("ACTUALIZAR");
        this.actualizar_btn.setFont(new Font("Courier new", Font.BOLD, 14));
        this.actualizar_btn.setBounds(420, 290, 120, 20);
        add(this.actualizar_btn).setVisible(true);
        this.actualizar_btn.addActionListener(eventoClick);

        this.cerrar_btn = new JButton("<html><center>X<html>");
        this.cerrar_btn.setFont(new Font("Consolas", Font.BOLD, 30));
        this.cerrar_btn.setBounds(1230, 10, 40, 30);
        add(this.cerrar_btn).setVisible(true);
        this.cerrar_btn.addActionListener(eventoClick);
    }
    public static void setTablaResultados(ArrayList<AlmacenaModel> almacena){
        tlbResultados.removeAll();
        String [] cabeseras = {"Bodega","Direccion","Producto","Precio unitario","Cantidad"};
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(cabeseras);
        tlbResultados.setModel(tableModel);
        for(int i=0; i < almacena.size(); i++){
            tableModel.addRow(almacena.get(i).toArray());
        }
    }

     //---------------------getters y setters ---------------------//
    public JTable getTlbResultados() {
        return tlbResultados;
    }

    public JButton getInsertar_btn() {
        return insertar_btn;
    }

    public JButton getEliminar_btn() {
        return eliminar_btn;
    }

    public JButton getConsultar_btn() {
        return consultar_btn;
    }


    public JButton getActualizar_btn() {
        return actualizar_btn;
    }

    public JComboBox<BodegaModel> getNBodegaBox() {
        return this.nBodega_box;
    }

    public JComboBox<ProductoModel> getNProductoBox() {
        return this.nProducto_box;
    }
    public JTextField getCantidadTxt() {
        return this.cantidad_txt;
    }

      /**
     * @return the buscarBodega_box
     */
    public JComboBox<BodegaModel> getBuscarBodega_box() {
        return buscarBodega_box;
    }

    /**
     * @return the buscarProducto_box
     */
    public JComboBox<ProductoModel> getBuscarProducto_box() {
        return buscarProducto_box;
    }

    /**
     * @return the cerrar_btn
     */
    public JButton getCerrar_btn() {
        return cerrar_btn;
    }


}