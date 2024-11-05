package Programas;
import java.util.Arrays;
import java.util.Comparator;

// Programa que resuelve el problema de la mochila
public class ProblemaDeLaMochila {
    
    // Clase para representar un objeto con su beneficio y peso
    static class Objeto {
        double beneficio, peso;
        int num;

        public Objeto(double beneficio, double peso, int num) {
            this.beneficio = beneficio;
            this.peso = peso;
            this.num = num;
        }

        // Calcula el valor por unidad de peso
        public double valorPorPeso() {
            return beneficio / peso;
        }
    }

    // Función para resolver el problema de la mochila
    public static double[] mochila(Objeto[] objetos, double capacidad) {
        int n = objetos.length;
        double[] sol = new double[n]; // Vector para almacenar la solución
        double beneficioTotal = 0.0; // Inicializamos el beneficio total en 0

        // Ordenamos los objetos por valor/ peso en orden descendente
        Arrays.sort(objetos, Comparator.comparingDouble(Objeto::valorPorPeso).reversed());

        double resto = capacidad;
        int i = 0;

        // Llenamos la mochila con los objetos mientras haya capacidad
        while (i < n && objetos[i].peso <= resto) {
            sol[i] = 1.0; // Tomamos el objeto completo
            beneficioTotal += objetos[i].beneficio; // Agregamos el beneficio completo del objeto
            resto -= objetos[i].peso;
            i++;
        }

        // Si aún queda capacidad, tomamos una fracción del siguiente objeto
        if (i < n) {
            sol[i] = resto / objetos[i].peso;
            beneficioTotal += sol[i] * objetos[i].beneficio; // Agregamos el beneficio parcial
        }

        // Imprimimos el beneficio total
        System.out.println(" == PROBLEMA DE LA MOCHILA FRACCIONADA ==\n");
        System.out.println("Beneficio total de la mochila llena: " + beneficioTotal + "\n");

        return sol;  // Retornamos el arreglo de fracciones de los objetos
    }

    public static void main(String[] args) {
        // Definición de objetos con beneficio y peso
        Objeto[] objetos = {
            new Objeto(60, 10, 1), // Objeto 1 - Indice 6
            new Objeto(100, 20, 2), // Objeto 2 - Indice 5
            new Objeto(120, 30, 3)  // Objeto 3 - Indice 4
        };
        
        double capacidad = 50; // Capacidad de la mochila

        // Se obtiene la solución
        double[] resultado = mochila(objetos, capacidad);

        // Se imprime la solución
        System.out.println(" ● Fracciones de objetos en la mochila:\n");
        for (int i = 0; i < resultado.length; i++) {
            System.out.println("     Objeto " + objetos[i].num + ": " + resultado[i]);
        }
        System.out.println("");
    }   
}