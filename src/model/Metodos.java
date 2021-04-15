package model;

import java.awt.Container;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 * Clase para metodos de apoyo reutilizables
 *
 * @author jovan
 */
public class Metodos {

    /**
     * Metodo para revisar que el String del campo no este vacio
     *
     * @param field Campo a ingresar
     * @param msg Mensaje de error
     * @return regresa un String con el mensaje de error o vacio
     */
    public static String checkField(String field, String msg) {
        String err;
        err = field.isEmpty() ? "- " + msg + "\n" : "";
        return err;
    }

    /**
     * Metodo que llama al metodo JOptionPan, muestra un mensaje de dialogo y
     * emite un pitido
     *
     * @param c Contenedor de donde se llama
     * @param msg Mensaje del cuadro de dialogo
     * @param title Titulo del cuadro de dialogo
     * @param typeMessage Tipo de mensaje del cuadro de dialogo
     */
    public static void dialogMessage(Container c, String msg, String title, int typeMessage) {
        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(c, msg, title, typeMessage);
    }
}
