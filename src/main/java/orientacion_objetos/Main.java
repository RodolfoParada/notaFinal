package orientacion_objetos;
import javax.swing.SwingUtilities;
import orientacion_objetos.vista.VistaCalculo;
//Rodolfo Parada Gónzalez
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VistaCalculo());
    }
}
