/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Toolkit;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import view.PanelControls;
import view.ViewWindow;

/**
 *
 * @author jovan
 */
public class Logic {

    private String expression;
    private String inputs;
    private String error;
    private PanelControls controls;

    public Logic(ViewWindow v) {
        this.controls = v.getControls();
    }

    public void clear() {
        controls.getTxtExpression().setText("");
        controls.getTxtInput().setText("");
        controls.getListModel().clear();
    }

    public void check() {
        if (isEmptyFields()) {
            checkInputs();
        } else {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(controls, error, "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void checkInputs() {
        controls.getListModel().clear();
        StringBuilder sb = new StringBuilder();
        DefaultListModel currentModel = controls.getListModel();
        String[] inputsArr = inputs.split("\n");
        for (String input : inputsArr) {
            sb.append(input).append(input.matches(expression) ? " Valido" : " No valido");
            currentModel.addElement(sb.toString());
            sb.delete(0, sb.length());
        }
        controls.getJlInputs().setModel(currentModel);
    }

    private boolean isEmptyFields() {
        error = "";
        expression = controls.getTxtExpression().getText();
        inputs = controls.getTxtInput().getText();
        error += checkField(expression, "Ingrese una expresion");
        error += checkField(inputs, "Ingrese al menos una entrada");
        return error.isEmpty();
    }

    private String checkField(String field, String msj) {
        String err = "";
        err = field.isEmpty() ? "- " + msj + "\n" : "";
        return err;
    }

}
