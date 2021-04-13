package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 * Clase vista del programa
 * @author jovan
 */
public class ViewWindow extends JFrame {

    private PanelControls controls;

    /**
     * Constructor de la clase ViewWindow
     */
    public ViewWindow() {
        initFrame();
    }

    
    /**
     * Metodo donde se inicializan todos los componentes de la ventana
     */
    private void initFrame() {
        setTitle("E. de expresiones");
        setLayout(new BorderLayout());
        controls = new PanelControls();
        add(controls, BorderLayout.CENTER);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * Metodo que retorna el panel donde estan alojados los controles del programa
     * 
     * @return Panel de controles
     */
    public PanelControls getControls() {
        return controls;
    }
}
