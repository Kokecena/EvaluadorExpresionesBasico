package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Logic;
import view.ViewWindow;

/**
 * Controlador de los controles que contiene la ventana Implementando el modelo
 * MVC
 *
 * @author jovan
 */
public class Controller implements ActionListener {

    private final ViewWindow view;
    private final Logic model;

    /**
     * Recibe como parametro el modelo y la vista del programa
     *
     * @param model La clase Logica
     * @param view La clase Vista ventana
     */
    public Controller(Logic model, ViewWindow view) {
        this.model = model;
        this.view = view;
    }

    /**
     * *
     * Muestra la ventana principal
     */
    public void initWindow() {
        view.setVisible(true);
    }

    /**
     * De acuerdo al boton presionado recibira el comando y se ejecutara el
     * metodo relacionado a este
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "check" -> model.check();
            case "clear" -> model.clear();
        }
    }

    /**
     * Se añaden los escuchas a los controles de botones
     *
     * @param e
     */
    public void actionListener(ActionListener e) {
        view.getControls().getBtnCheck().addActionListener(e);
        view.getControls().getBtnClear().addActionListener(e);
    }

}
