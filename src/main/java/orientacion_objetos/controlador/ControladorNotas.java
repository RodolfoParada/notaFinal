package orientacion_objetos.controlador;

import orientacion_objetos.vista.VistaCalculo;
import orientacion_objetos.modelo.CalcularNotas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorNotas {
    private VistaCalculo vista;
    private CalcularNotas modelo;

    public ControladorNotas(VistaCalculo vista) {
        this.vista = vista;
        this.modelo = new CalcularNotas();

        vista.agregarListenerAgregarNota(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = vista.getNota();
                try {
                    // Verificar si el formato es válido y convertir a doble
                    double nota = Double.parseDouble(input);

                    // Aceptar notas entre 1.0 y 7.0 (inclusive) y permitir el formato 7 o 7.0
                    if (nota >= 1.0 && nota <= 7.0) {
                        // Agregar la nota a la lista de notas
                        vista.agregarNota(nota);
                        vista.agregarNotaLista("Nota: " + input);
                        vista.getNota();  // Limpiar el campo de texto
                        vista.limpiarCampoNota();

                        // Si ya se han ingresado 7 notas, mostrar el mensaje
                        if (vista.getNotas().size() == 7) {
                            JOptionPane.showMessageDialog(vista, "Se han ingresado las 7 notas. Ahora el cálculo del promedio se puede realizar.");

                            // Deshabilitar el botón y el campo de texto para evitar más entradas
                            vista.deshabilitarIngreso();
                        }
                    } else {
                        JOptionPane.showMessageDialog(vista, "Nota inválida. La nota debe estar entre 1.0 y 7.0.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(vista, "Entrada no válida. Ingrese un número.");
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(vista, ex.getMessage());
                }
            }
        });
        // Listener para calcular el resultado
        vista.agregarListenerCalcular(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double promedio = modelo.CalcularPromedio(vista.getNotas());
                    // devuelve un String de resultado y una nota
                    String resultadoFinal = modelo.ResultadoFinal(promedio);  // Por ejemplo: "Aprobado"
                    String nota = String.valueOf(promedio);  // La nota que se muestra, usando el promedio calculado

                    // Crear un arreglo con el resultado y la nota
                    String[] resultado = new String[]{resultadoFinal, nota};

                    // Ahora puedes acceder a los dos elementos del arreglo
                    vista.actualizarResultado(resultado[0] + " con nota " + resultado[1]);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(vista, ex.getMessage());
                }
            }
        });


        // Listener para limpiar todo
        vista.agregarListenerLimpiar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.limpiarLista();
                vista.limpiarNotas();
                vista.limpiarCampoNota();
                vista.habilitarBotonAgregar();
            }
        });
    }
}

