package orientacion_objetos.modelo;

import java.util.List;
//Rodolfo Parada Gónzalez
public class CalcularNotas {
    private final double[] ponderaciones = {0.07, 0.14, 0.21, 0.07, 0.07, 0.14, 0.30};

    public double CalcularPromedio(List<Double> notas) {
        // Validar que el número de notas sea igual a 7 (6 evaluaciones + 1 examen final)
        if (notas == null || notas.size() != ponderaciones.length) {
            throw new IllegalArgumentException("Se requieren exactamente 7 notas.");
        }

        double promedio = 0.0;

        // Calcular la suma ponderada de las notas
        for (int i = 0; i < notas.size(); i++) {
            promedio += notas.get(i) * ponderaciones[i];
        }

        return promedio;
    }

    public String ResultadoFinal(double promedio) {
        // Si la nota final es mayor o igual a 4.0, aprueba
        if (promedio >= 4.0) {
            return "Aprobó con nota " + String.format("%.2f", promedio);
        } else {
            return "Reprobó con nota " + String.format("%.2f", promedio);
        }
    }
}
