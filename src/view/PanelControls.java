/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.swing.JTextField;
import model.GBMetodos;
import model.MiRender;

/**
 *
 * @author jovan
 */
public class PanelControls extends JPanel {

    private JTextField txtExpression;
    private JScrollPane jsInput;
    private JScrollPane jsInputs;
    private JTextArea txtInput;
    private JList jlInputs;
    private DefaultListModel listModel;
    private JButton btnCheck;
    private JButton btnClear;
    private JPanel panelInput;
    private JPanel panelCheck;

    public PanelControls() {
        initComponents();
        addComponents();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    }

    private void createInputPanel() {
        Insets insets = new Insets(5, 5, 5, 5);
        panelInput = new JPanel(new GridBagLayout());
        GBMetodos.addComponentGBLayout(panelInput, new JLabel("Expresión: "), 0, 0, GridBagConstraints.NORTHEAST, insets);
        GBMetodos.addComponentGBLayout(panelInput, txtExpression, 2, 0, insets);
        GBMetodos.addComponentGBLayout(panelInput, new JLabel("Entradas: "), 0, 2, GridBagConstraints.NORTHEAST, insets);
        GBMetodos.addComponentGBLayout(panelInput, jsInput, 2, 2, insets);
        GBMetodos.addComponentGBLayout(panelInput, btnClear, 0, 4, insets);
        GBMetodos.addComponentGBLayout(panelInput, btnCheck, 2, 4, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, insets);

    }

    private void createCheckPanel() {
        panelCheck = new JPanel();
        panelCheck.setBorder(BorderFactory.createTitledBorder("Validación"));
        panelCheck.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panelCheck.add(Box.createVerticalStrut(5));
        panelCheck.add(jsInputs);
    }

    private void initComponents() {
        txtExpression = new JTextField(18);
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

    public void addComponents() {
        createInputPanel();
        createCheckPanel();
        add(panelInput);
        add(new JSeparator());
        add(panelCheck);
    }

    public JTextField getTxtExpression() {
        return txtExpression;
    }

    public JTextArea getTxtInput() {
        return txtInput;
    }

    public JList getJlInputs() {
        return jlInputs;
    }

    public JButton getBtnCheck() {
        return btnCheck;
    }

    public JButton getBtnClear() {
        return btnClear;
    }

    public DefaultListModel getListModel() {
        return listModel;
    }

}
