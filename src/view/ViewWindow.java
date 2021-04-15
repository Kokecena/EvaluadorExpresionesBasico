package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.Box;
import javax.swing.JFrame;

/**
 * Clase vista del programa
 *
 * @author jovan
 */
public class ViewWindow extends JFrame {

    private final PanelControls controls;
    private final int SPACE = 12;

    /**
     * Constructor de la clase ViewWindow
     */
    public ViewWindow() {
        this.controls = new PanelControls();
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
        setMinimumSize(new Dimension(this.getWidth(), this.getHeight()));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * Distribuye los componentes de la ventana
     */
    private void addComponents() {
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
