package view;

import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import model.GBMetodos;
import model.MiRender;

/**
 * Panel donde se encuentran distribuidos todos los controles del programa
 * @author jovan
 */
public class PanelControls extends JPanel {

    private JTextArea txtExpression;
    private JScrollPane jsExpression;
    private JScrollPane jsInput;
    private JScrollPane jsInputs;
    private JTextArea txtInput;
    private JList jlInputs;
    private DefaultListModel listModel;
    private JButton btnCheck;
    private JButton btnClear;
    private JPanel panelInput;
    private JPanel panelCheck;

    /**
     * Constructor del panel control
     */
    public PanelControls() {
        initComponents();
        addComponents();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    /**
     * Metodo que crea el panel de entradas asi como tambien la distribucion
     * de todos los controles
     */
    private void createInputPanel() {
        Insets insets = new Insets(5, 5, 5, 5);
        panelInput = new JPanel(new GridBagLayout());
        GBMetodos.addComponentGBLayout(panelInput, new JLabel("Expresión: "), 0, 0, GridBagConstraints.NORTHEAST, insets);
        GBMetodos.addComponentGBLayout(panelInput, jsExpression, 2, 0, insets);
        GBMetodos.addComponentGBLayout(panelInput, new JLabel("Entradas: "), 0, 2, GridBagConstraints.NORTHEAST, insets);
        GBMetodos.addComponentGBLayout(panelInput, jsInput, 2, 2, insets);
        GBMetodos.addComponentGBLayout(panelInput, btnClear, 0, 4, insets);
        GBMetodos.addComponentGBLayout(panelInput, btnCheck, 2, 4, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, insets);
    }

    /**
     * Metodo que crea el panel donde se encontrara la lista de entradas
     * y mostrara si son validas o no
     */
    private void createCheckPanel() {
        panelCheck = new JPanel();
        panelCheck.setBorder(BorderFactory.createTitledBorder("Validación"));
        panelCheck.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panelCheck.add(Box.createVerticalStrut(5));
        panelCheck.add(jsInputs);
    }

    /**
     * Metodo encargado de inicializar todos los controles
     * asi como tambien colocando caracteristicas 
     */
    private void initComponents() {
        txtExpression = new JTextArea(2,18);
        jsExpression = new JScrollPane(txtExpression,JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        txtInput = new JTextArea(8, 18);
        jsInput = new JScrollPane(txtInput);
        btnCheck = new JButton("Comprobar");
        btnClear = new JButton("Limpiar");
        listModel = new DefaultListModel();
        jlInputs = new JList(listModel);
        jlInputs.setCellRenderer(new MiRender());
        jsInputs = new JScrollPane(jlInputs);
        btnCheck.setActionCommand("check");
        btnCheck.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnClear.setActionCommand("clear");
        btnClear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    /**
     * Metodo donde se añaden los componentes al contenedor principal
     */
    private void addComponents() {
        createInputPanel();
        createCheckPanel();
        add(panelInput);
        add(new JSeparator());
        add(panelCheck);
    }

    /**
     * Campo donde se encuentra la expresion ingresada
     * @return Campo de expresion 
     */
    public JTextArea getTxtExpression() {
        return txtExpression;
    }

    /**
     * Campo donde se encuentran todas las entradas ingresadas
     * @return Campo de entradas 
     */
    public JTextArea getTxtInput() {
        return txtInput;
    }

    /**
     * Lista donde se muestra si las entradas fueron validas o no
     * @return 
     */
    public JList getJlInputs() {
        return jlInputs;
    }

    /**
     * Es el boton comprobar
     * @return Boton de comprobar 
     */
    public JButton getBtnCheck() {
        return btnCheck;
    }

    /**
     * Es el boton limpiar
     * @return Boton de limpieza
     */
    public JButton getBtnClear() {
        return btnClear;
    }

    /**
     * Modelo vacio de la lista
     * @return Modelo por defecto de la lista
     */
    public DefaultListModel getListModel() {
        return listModel;
    }

}
