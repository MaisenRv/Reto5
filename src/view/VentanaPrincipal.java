package view;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import java.awt.Dimension;
import java.awt.Toolkit;

public class VentanaPrincipal extends JFrame {
    public VentanaPrincipal(){
        initComponets();
    }
    private void initComponets() {
        setTitle("Te Reto A Programarlo S.A.S.");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        PanelResultados panelResultados = new PanelResultados();
        setContentPane(panelResultados);
        add(new PanelControles(panelResultados));

        setSize(700, 600);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize  = getSize();
        setLocation((screenSize.width  - frameSize.width)  / 2, 
                    (screenSize.height - frameSize.height) / 2);
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}