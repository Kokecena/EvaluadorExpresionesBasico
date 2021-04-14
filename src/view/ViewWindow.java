package view;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import javax.swing.Box;
import javax.swing.JFrame;

/**
 * Clase vista del programa
 *
 * @author jovan
 */
public class ViewWindow extends JFrame {

    private PanelControls controls;
    private final int SPACE = 12;

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
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/icon.png").getPath()));
        setTitle("Evaluador de expresiones");
        setLayout(new BorderLayout());
        addComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * Distribuye los componentes de la ventana
     */
    private void addComponents() {
        controls = new PanelControls();
        add(Box.createVerticalStrut(SPACE), BorderLayout.NORTH);
        add(Box.createHorizontalStrut(SPACE), BorderLayout.EAST);
        add(controls, BorderLayout.CENTER);
        add(Box.createHorizontalStrut(SPACE), BorderLayout.WEST);
        add(Box.createVerticalStrut(SPACE), BorderLayout.SOUTH);
        pack();
    }

    /**
     * Metodo que retorna el panel donde estan alojados los controles del
     * programa
     *
     * @return Panel de controles
     */
    public PanelControls getControls() {
        return controls;
    }

}
