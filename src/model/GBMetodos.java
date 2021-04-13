package model;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 *
 * @author jovan
 */
public class GBMetodos {
    public static void addComponentGBLayout(Container container, Component component, int gridx, int gridy, Insets inset) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = inset;
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        container.add(component, gbc);
    }
    
    public static void addComponentGBLayout(Container container, Component component, int gridx, int gridy, int anchor, Insets inset) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = inset;
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.anchor = anchor;
        container.add(component, gbc);
    }
    
    public static void addComponentGBLayout(Container container, Component component, int gridx, int gridy, int fill, int anchor, Insets inset) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = inset;
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.fill = fill;
        gbc.anchor = anchor;
        container.add(component, gbc);
    }


    public static void addComponentGBLayout(Container container, Component component, int gridx, int gridy, int gridheigth, int gridwidth, double weighty, double weightx, int fill, int anchor, Insets inset) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = inset;
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridheight = gridheigth;
        gbc.gridwidth = gridwidth;
        gbc.weightx = weightx;
        gbc.weighty = weighty;
        gbc.fill = fill;
        gbc.anchor = anchor;
        container.add(component, gbc);
    }
    
    
    public static void addComponentGBLayout(Container container, Component component, int gridx, int gridy, int gridheigth, int gridwidth, double weighty, int fill, Insets inset) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = inset;
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridheight = gridheigth;
        gbc.gridwidth = gridwidth;
        gbc.weightx = weighty;
        gbc.fill = fill;
        container.add(component, gbc);
    }
    
    public static void addComponentGBLayout(Container container, Component component, int gridx, int gridy, int gridheigth, int gridwidth, double weighty, int fill, int anchor, Insets inset) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = inset;
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridheight = gridheigth;
        gbc.gridwidth = gridwidth;
        gbc.weightx = weighty;
        gbc.fill = fill;
        gbc.anchor = anchor;
        container.add(component, gbc);
    }
    
    
    
}
