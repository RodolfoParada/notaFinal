package orientacion_objetos;
import javax.swing.SwingUtilities;
import orientacion_objetos.vista.VistaCalculo;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VistaCalculo());
    }
}