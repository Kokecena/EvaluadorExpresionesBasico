package model;

import java.awt.Toolkit;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import view.PanelControls;
import view.ViewWindow;

/**
 * Clase encargada de la logica del programa
 * @author jovan
 */
public class Logic {

    /**
     * Expresion ingresada
     */
    private String expression;
    
    /**
     * Entradas ingresadas
     */
    private String inputs;
    
    /**
     * Errores generados
     */
    private String error;
    
    /**
     * Controles del programa
     */
    private PanelControls controls;

    /**
     * Constructor de la clase logica recibe como argumento y se le asigna a la
     * variable controls el panel de controles para tener mas facildad de acceso
     * a los controles que maneja el panel.
     *
     * @param v
     */
    public Logic(ViewWindow v) {
        this.controls = v.getControls();
    }

    /**
     * Metodo publico que limpia los campos de texto asi como tambien la lista
     * de las cadenas ingresadas
     */
    public void clear() {
        controls.getTxtExpression().setText("");
        controls.getTxtInput().setText("");
        controls.getListModel().clear();
    }

    /**
     * Metodo publico para comprobar
     */
    public void check() {
        if (isEmptyFields()) {
            checkInputs();
        } else {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(controls, error, "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Verifica las entradas ingresadas Primero limpia el modelo de la lista, se
     * instancia un StringBuilder y se obtiene el modelo de la lista para crear
     * un nuevo modelo con los nuevos valores ingresados, se separa en un
     * arreglo cada entrada, iteramos el arreglo y comprobamos que cumpla con la
     * expresion regular ingresada en dado caso de que asi sea se agregara el
     * "Valido" o "No valido" si no se cumple, se añade el objeto a al modelo de
     * la lista y al final se agrega el modelo de la lista al componente lista.
     *
     */
    private void checkInputs() {
        controls.getListModel().clear();
        StringBuilder sb = new StringBuilder();
        DefaultListModel newListModel = controls.getListModel();
        String[] inputsArr = inputs.split("\n");
        for (String input : inputsArr) {
            sb.append(input).append(input.matches(expression) ? " Valido" : " No valido");
            newListModel.addElement(sb.toString());
            sb.delete(0, sb.length());
        }
        controls.getJlInputs().setModel(newListModel);
    }

    /**
     * Metodo encargado de verificar si los campos se encuentran vacios
     *
     * @return retorna true si el String error esta vacio
     */
    private boolean isEmptyFields() {
        error = "";
        expression = controls.getTxtExpression().getText();
        inputs = controls.getTxtInput().getText();
        error += checkField(expression, "Ingrese una expresion");
        error += checkField(inputs, "Ingrese al menos una entrada");
        return error.isEmpty();
    }

    /**
     * Metodo para revisar que el String del campo no este vacio
     *
     * @param field Campo a ingresar
     * @param msj Mensaje de error
     * @return regresa un String con el mensaje de error o vacio
     */
    private String checkField(String field, String msj) {
        String err;
        err = field.isEmpty() ? "- " + msj + "\n" : "";
        return err;
    }

}
