package model;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 * Clase para ocupar de manera sencilla GridBagLayout
 *
 * @author jovan
 */
public class GBMetodos {

    /**
     * Uso basico para añadir un componenete usando GridBagLayout
     *
     * @param container Contenedor afectado
     * @param component Componente a agregar
     * @param gridx Localizacion en X
     * @param gridy Localizacion en Y
     * @param inset Espaciado
     */
    public static void addComponentGBLayout(Container container, Component component, int gridx, int gridy, Insets inset) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = inset;
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        container.add(component, gbc);
    }

    /**
     * Uso basico para añadir un componenete usando GridBagLayout agregando
     * tambien la localizacion cardinal de la misma
     *
     * @param container Contenedor afectado
     * @param component Componente a agregar
     * @param gridx Localizacion en X
     * @param gridy Localizacion en Y
     * @param anchor Localizacion cardinal del componente NORTH, SOUTH, etc.
     * @param inset Espaciado
     */
    public static void addComponentGBLayout(Container container, Component component, int gridx, int gridy, int anchor, Insets inset) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = inset;
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.anchor = anchor;
        container.add(component, gbc);
    }

    /**
     * Uso basico para añadir un componenete usando GridBagLayout agregando
     * tambien la localizacion cardinal de la misma asi como tambien el
     * estiramiento del componente de manera horizontal o vertical
     *
     * @param container Contenedor afectado
     * @param component Componente a agregar
     * @param gridx Localizacion en X
     * @param gridy Localizacion en Y
     * @param fill Estirar componente Horizontal, Vertical, etc
     * @param anchor Localizacion cardinal del componente NORTH, SOUTH, etc.
     * @param inset Espaciado
     */
    public static void addComponentGBLayout(Container container, Component component, int gridx, int gridy, int fill, int anchor, Insets inset) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = inset;
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.fill = fill;
        gbc.anchor = anchor;
        container.add(component, gbc);
    }
}
