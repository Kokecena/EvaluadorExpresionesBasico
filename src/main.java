
import controller.Controller;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;
import model.Logic;
import view.ViewWindow;

/**
 * Clase principal del programa
 *
 * @author jovan
 */
public class main {

    /**
     * Metodo para colocar el tema de la ventana
     */
    private static void setWindowTheme() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                System.out.println(info.getName());
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo para inciar el programa instanciado todos los componentes del
     * programa MVC
     *
     * @return Controlador
     */
    public static Controller init() {
        ViewWindow v = new ViewWindow();
        Logic m = new Logic(v);
        Controller c = new Controller(m, v);
        return c;
    }

    public static void main(String[] args) {
        setWindowTheme();
        init().initWindow();
    }
}
