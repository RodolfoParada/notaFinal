package orientacion_objetos.vista;

import orientacion_objetos.controlador.ControladorNotas;
import orientacion_objetos.modelo.CalcularNotas;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class VistaCalculo extends JFrame {

    // Campos de entrada y botones de la interfaz
    public JTextField textoNota = new JTextField();
    public JButton btnAgregarNota = new JButton("Agregar Nota");
    public JLabel listaNota = new JLabel();
    private ControladorNotas controlador;
    public DefaultListModel<String> modeloLista = new DefaultListModel<>();
    public JList<String> listaNotas = new JList<>(modeloLista);
    private JButton btnEditarNota = new JButton("Editar Nota");
    public JButton btnCalcular = new JButton("Calcular Resultado");
    public JButton btnLimpiar = new JButton("Limpiar Todo");
    public JLabel mostrarResultado = new JLabel("Resultado: ");

    // Lista para almacenar las notas
    public ArrayList<Double> notas = new ArrayList<>();

    public VistaCalculo() {
        // Inicializamos el controlador
        controlador = new ControladorNotas(this);

        // Inicializar el modelo y el JList
        modeloLista = new DefaultListModel<>();
        listaNotas = new JList<>(modeloLista);

        // Configuración de la ventana principal
        setTitle("Calculadora de Nota Final");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Panel ingreso de notas
        JPanel panelIngreso = new JPanel(new GridLayout(2, 2, 10, 10));
        panelIngreso.setBorder(BorderFactory.createTitledBorder("Ingresar Nota (1.0 a 7.0)"));
        panelIngreso.add(new JLabel("Nota:"));
        panelIngreso.add(textoNota);
        panelIngreso.add(btnAgregarNota);

        // Panel para mostrar las notas ingresadas
        JPanel panelCentro = new JPanel(new BorderLayout());
        panelCentro.setBorder(BorderFactory.createTitledBorder("Notas Ingresadas (Máx. 7)"));
        panelCentro.add(new JScrollPane(listaNotas), BorderLayout.CENTER);  // Asegúrate de que la lista esté en un JScrollPane

        // Panel de botones para acciones
        JPanel panelBotones = new JPanel(new GridLayout(3, 1, 5, 5));
        panelBotones.add(btnCalcular);
        panelBotones.add(btnLimpiar);
        panelBotones.add(mostrarResultado);

        // Agregar los paneles al layout principal
        add(panelIngreso, BorderLayout.NORTH);
        add(panelCentro, BorderLayout.CENTER);  // Asegúrate de añadir el panel que contiene la lista
        add(panelBotones, BorderLayout.SOUTH);

        // Centrar la ventana en la pantalla
        setLocationRelativeTo(null);
        setVisible(true);
    }
    // Métodos para acceder a los componentes desde el controlador

    // Obtener el texto de la nota ingresada
    public String getNota() {
        return textoNota.getText();
    }
    // Agregar una nota a la lista de notas
    public void agregarNota(double nota) {
        notas.add(nota);
    }
    // Obtener la lista de notas
    public List<Double> getNotas() {
        return notas;
    }
    // Agregar una nota a la lista visual
    public void agregarNotaLista(String nota) {
        modeloLista.addElement(nota);  // Agregar la nota al modelo

    }
    // Deshabilitar los campos de ingreso
    public void deshabilitarIngreso() {
        textoNota.setEnabled(false);
        btnAgregarNota.setEnabled(false);
    }
    // Mostrar una nota en el campo de texto
    public void mostrarNota(String texto) {
        textoNota.setText(texto);
    }
    // Obtener la nota ingresada como texto
    public String getNotaIngresada() {
        return textoNota.getText();
    }
    // Limpiar el campo de texto de la nota
    public void limpiarCampoNota() {
        textoNota.setText("");
    }
    // Editar una nota en la lista visual
    public void editarNotaLista(int indice, String nuevaNota) {
        modeloLista.set(indice, nuevaNota);
    }
    // Eliminar una nota de la lista visual
    public void eliminarNotaLista(int indice) {
        modeloLista.remove(indice);
    }
    // Limpiar toda la lista visual
    public void limpiarLista() {
        modeloLista.clear();
    }
    // Actualizar el resultado mostrado
    public void actualizarResultado(String resultado) {
        mostrarResultado.setText("Resultado: " + resultado);
    }
    // Habilitar el botón para agregar notas
    public void habilitarBotonAgregar() {
        btnAgregarNota.setEnabled(true);
    }
    // Agregar listeners para los botones
    public void agregarListenerAgregarNota(ActionListener listener) {
        btnAgregarNota.addActionListener(listener);
    }
    public void agregarListenerCalcular(ActionListener listener) {
        btnCalcular.addActionListener(listener);
    }

    public void agregarListenerLimpiar(ActionListener listener) {
        btnLimpiar.addActionListener(listener);
    }
    // Limpiar la lista de notas
    public void limpiarNotas() {
        notas.clear();
    }
    // Obtener las notas como una lista de strings
    public List<String> obtenerNotas() {
        List<String> notas = new ArrayList<>();
        for (int i = 0; i < modeloLista.getSize(); i++) {
            notas.add(modeloLista.getElementAt(i));
        }
        return notas;
    }
}





