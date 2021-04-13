package model;

import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 * Clase para tener las celdas de la lista personalizadas, sea verde cuando el
 * objeto tiene en su interior el valido o rojo cuando no sea el caso.
 *
 * @author jovan
 */
public class MiRender extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel c = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        String valor = value.toString();
        boolean esValido = valor.contains("Valido");
        c.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        c.setHorizontalAlignment(JLabel.CENTER);
        c.setBackground(esValido ? new Color(76, 175, 80) : new Color(244, 67, 54));
        c.setForeground(Color.WHITE);
        return c;
    }

}
