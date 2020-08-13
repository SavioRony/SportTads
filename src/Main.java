
import View.TelaCarregamentoView;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author savio
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        TelaCarregamentoView telaPrincipal = new TelaCarregamentoView();
        telaPrincipal.setVisible(true);
        UIManager.setLookAndFeel(new WindowsLookAndFeel());
    }
}
