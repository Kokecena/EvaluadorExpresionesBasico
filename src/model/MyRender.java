package model;

import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.border.MatteBorder;

/**
 * Clase para tener las celdas de la lista personalizadas, sea verde cuando el
 * objeto tiene en su interior el valido o rojo cuando no sea el caso.
 *
 * @author jovan
 */
public class MyRender extends DefaultListCellRenderer {

    private final Color GREEN = new Color(76, 175, 80);
    private final Color RED = new Color(244, 67, 54);
    private final MatteBorder BORDER = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK);

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel c = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        String valor = value.toString();
        boolean esValido = valor.contains("Valido");
        c.setBorder(BORDER);
        c.setHorizontalAlignment(JLabel.CENTER);
        c.setBackground(esValido ? GREEN : RED);
        c.setForeground(Color.WHITE);
        return c;
    }

}
