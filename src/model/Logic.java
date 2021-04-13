package model;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import view.PanelControls;
import view.ViewWindow;

/**
 * Clase encargada de la logica del programa
 *
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
    private final PanelControls controls;

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
            Metodos.dialogMessage(error, "¡ERROR!", JOptionPane.ERROR_MESSAGE);
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
        String regex = expression.replaceAll(" ", "");
        try {
            for (String input : inputsArr) {
                sb.append(input).append(Pattern.matches(regex, input) ? " Valido" : " No valido");
                newListModel.addElement(sb.toString());
                sb.delete(0, sb.length());
            }
            controls.getJlInputs().setModel(newListModel);
        } catch (PatternSyntaxException ex) {
            Metodos.dialogMessage(ex.getMessage(), "¡Patron invalido!", JOptionPane.WARNING_MESSAGE);
        }
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
        error += Metodos.checkField(expression, "Ingrese una expresion");
        error += Metodos.checkField(inputs, "Ingrese al menos una entrada");
        return error.isEmpty();
    }

}
