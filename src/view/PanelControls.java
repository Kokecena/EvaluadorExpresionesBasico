package view;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
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
import model.MyRender;

/**
 * Panel donde se encuentran distribuidos todos los controles del programa
 *
 * @author jovan
 */
public class PanelControls extends JPanel {

    private final JPanel panelInput;
    private final JPanel panelCheck;
    private final JSeparator separator;
    private final MyRender myRenderCell;
    private final GridBagLayout inputLayout;
    private final BoxLayout panelLayout;
    private final BorderLayout checkLayout;
    private final JLabel etiExpresion;
    private final JLabel etiCadenas;
    private JTextArea txtExpression;
    private JScrollPane jsExpression;
    private JScrollPane jsInput;
    private JScrollPane jsInputs;
    private JTextArea txtInput;
    private JList jlInputs;
    private DefaultListModel listModel;
    private JButton btnCheck;
    private JButton btnClear;

    /**
     * Constructor del panel control
     */
    public PanelControls() {
        this.checkLayout = new BorderLayout();
        this.panelLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.inputLayout = new GridBagLayout();
        this.myRenderCell = new MyRender();
        this.separator = new JSeparator();
        this.panelCheck = new JPanel();
        this.panelInput = new JPanel();
        this.etiCadenas = new JLabel("Cadenas");
        this.etiExpresion = new JLabel("Expresión");
        initComponents();
        addComponents();
        setLayout(panelLayout);
    }

    /**
     * Metodo que crea el panel de entradas asi como tambien la distribucion de
     * todos los controles
     */
    private void createInputPanel() {
        Insets insets = new Insets(5, 5, 5, 5);
        panelInput.setLayout(inputLayout);
        panelInput.setBorder(BorderFactory.createTitledBorder("Entradas"));
        GBMetodos.addComponentGBLayout(panelInput, etiExpresion, 0, 0, GridBagConstraints.NORTHEAST, insets);
        GBMetodos.addComponentGBLayout(panelInput, jsExpression, 2, 0, GridBagConstraints.HORIZONTAL, insets, GridBagConstraints.RELATIVE, 1.0, 30, 16);
        GBMetodos.addComponentGBLayout(panelInput, etiCadenas, 0, 2, GridBagConstraints.NORTHEAST, insets);
        GBMetodos.addComponentGBLayout(panelInput, jsInput, 2, 2, GridBagConstraints.HORIZONTAL, insets, GridBagConstraints.RELATIVE, 1.0, 30, 80);
        GBMetodos.addComponentGBLayout(panelInput, btnClear, 0, 4, insets);
        GBMetodos.addComponentGBLayout(panelInput, btnCheck, 2, 4, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, insets);
    }

    /**
     * Metodo que crea el panel donde se encontrara la lista de entradas y
     * mostrara si son validas o no
     */
    private void createCheckPanel() {
        panelCheck.setBorder(BorderFactory.createTitledBorder("Salidas"));
        panelCheck.setLayout(checkLayout);
        panelCheck.setPreferredSize(new Dimension(350, 200));
        panelCheck.add(jsInputs, BorderLayout.CENTER);
    }

    /**
     * Metodo encargado de inicializar todos los controles asi como tambien
     * colocando caracteristicas
     */
    private void initComponents() {
        /**
         * Instanciando controles
         */
        txtExpression = new JTextArea();
        jsExpression = new JScrollPane(txtExpression, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        txtInput = new JTextArea();
        jsInput = new JScrollPane(txtInput);
        btnCheck = new JButton("Comprobar");
        btnClear = new JButton("Limpiar");
        listModel = new DefaultListModel();
        jlInputs = new JList(listModel);
        jlInputs.setCellRenderer(myRenderCell);
        jsInputs = new JScrollPane(jlInputs);
        /**
         * Añadiendo tips de ayuda a componentes
         */
        txtExpression.setToolTipText("<html>Introduce la expresion regular que quieras comprobar.<br> Ej. [0-9]{10}</html>");
        txtInput.setToolTipText("<html>Introduce las cadenas de caracteres que quieras comprobar"
                + "<br> utilizando el salto de linea para separarlos."
                + "<br> Ejemplo: "
                + "<br>     Hola como estas"
                + "<br>     Korewa Giorno Giovanna Yumegaru! "
                + "<br>     783-123-4567</html>");
        btnCheck.setToolTipText("Comprobar las cadenas ingresadas");
        btnClear.setToolTipText("Limpiar todos los datos");
        jlInputs.setToolTipText("Aqui se mostraran si las cadenas son validas o no");
        /**
         * Añadiendo comandos de accion a los botones
         */
        btnCheck.setActionCommand("check");
        btnClear.setActionCommand("clear");
        /**
         * Añadiendo tipo de cursor a los botones
         */
        btnCheck.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnClear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    /**
     * Metodo donde se añaden los componentes al contenedor principal
     */
    private void addComponents() {
        createInputPanel();
        createCheckPanel();
        add(panelInput);
        add(separator);
        add(panelCheck);
    }

    /**
     * Campo donde se encuentra la expresion ingresada
     *
     * @return Campo de expresion
     */
    public JTextArea getTxtExpression() {
        return txtExpression;
    }

    /**
     * Campo donde se encuentran todas las entradas ingresadas
     *
     * @return Campo de entradas
     */
    public JTextArea getTxtInput() {
        return txtInput;
    }

    /**
     * Lista donde se muestra si las entradas fueron validas o no
     *
     * @return
     */
    public JList getJlInputs() {
        return jlInputs;
    }

    /**
     * Es el boton comprobar
     *
     * @return Boton de comprobar
     */
    public JButton getBtnCheck() {
        return btnCheck;
    }

    /**
     * Es el boton limpiar
     *
     * @return Boton de limpieza
     */
    public JButton getBtnClear() {
        return btnClear;
    }

    /**
     * Modelo vacio de la lista
     *
     * @return Modelo por defecto de la lista
     */
    public DefaultListModel getListModel() {
        return listModel;
    }

}
