package view;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import java.awt.Dimension;
import java.awt.Toolkit;

public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal() {
        initComponets();
    }

    private void initComponets() {
        setTitle("Te Reto A Programarlo S.A.S.");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Paneles();

        setUndecorated(true);
        setSize(1300, 700);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation((screenSize.width - frameSize.width) / 2,
                (screenSize.height - frameSize.height) / 2);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void Paneles() {
        PanelResultados panelResultados = new PanelResultados();
        PanelControles panelControles = new PanelControles(panelResultados);
        add(panelControles);
    }
}
